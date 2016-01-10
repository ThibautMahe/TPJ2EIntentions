package launcher.lab;

import org.apache.catalina.*;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.tomcat.JarScanFilter;
import org.apache.tomcat.JarScanType;
import org.apache.tomcat.util.scan.StandardJarScanFilter;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Launcher {
  public static final Integer PORT = 8080;

  public static void startTomcat(Class<?> caller) {
    startTomcat(LauncherHelper.getContext(caller), true);
  }

  public static void startTomcat(String contextRoot) {
    startTomcat(contextRoot, true);
  }

  public static void startTomcat(String contextRoot, boolean fastStartup) {
    try {
      new TomcatLauncher(contextRoot, fastStartup).start();
    } catch (Exception e) {
      throw new RuntimeException("Cannot start Tomcat container", e);
    }
  }

  static class TomcatLauncher {
    final String contextRoot;
    final boolean fastStartup;

    TomcatLauncher(String contextRoot, boolean fastStartup) {
      this.contextRoot = contextRoot;
      this.fastStartup = fastStartup;
    }

    void start() throws ServletException, LifecycleException {
      long timeBegin = System.currentTimeMillis();

      String contextPath = "/";
      String webAppDirLocation = contextRoot + "src/main/webapp/";
      String baseDirectory = new File(webAppDirLocation).getAbsolutePath();

      if (!Files.exists(Paths.get(baseDirectory))) {
        try {
          Files.createDirectories(Paths.get(baseDirectory));
        } catch (IOException e) {
          throw new RuntimeException("Cannot create dir: " + baseDirectory, e);
        }
      }

      Tomcat tomcat = (fastStartup) ? new TomcatWithFastStartup() : new Tomcat();
      tomcat.setPort(PORT);
      StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);

      // Additions to make @WebServlet work
      String buildPath = contextRoot + "target/classes";
      String webAppMount = "/WEB-INF/classes";

      File additionalWebInfClasses = new File(buildPath);
      WebResourceRoot resources = new StandardRoot(context);
      resources.addPreResources(
          new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), contextPath));
      context.setResources(resources);
      // End of additions

      tomcat.start();
      long timeEnd = System.currentTimeMillis();
      System.out.println("Started server on http://localhost:" + PORT + " (" + (timeEnd - timeBegin) + " ms)");

      tomcat.getServer().await();
    }
  }

  // We almost disable jarscan as we stay in the IDE
  static class TomcatWithFastStartup extends org.apache.catalina.startup.Tomcat {
    private Pattern[] allowedPatterns = new Pattern[]{Pattern.compile("jstl.*"), Pattern.compile("spring-web.*")};

    @Override
    public void start() throws LifecycleException {
      for (Service service : getServer().findServices()) {
        for (Container container : service.getContainer().findChildren()) {
          for (Container c : container.findChildren()) {
            ((Context) c).getJarScanner().setJarScanFilter(new JarScanFilter() {
              public boolean check(JarScanType jarScanType, String jarName) {
                for (Pattern each : allowedPatterns) {
                  if (each.matcher(jarName).matches()) {
                    return true;
                  }
                }
                return false;
              }
            });
          }
        }
      }
      super.start();
    }
  }
}
