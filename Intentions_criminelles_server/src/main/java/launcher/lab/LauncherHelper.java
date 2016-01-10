package launcher.lab;

import java.io.File;

public class LauncherHelper {
  public static String getContext(Class<?> clazz) {
    String value = System.getenv("MYTRAININGS_IDE");
    if (value == null || value.length() == 0) {
      System.out.println("Using context: \"\"");
      return "";
    }

    ClassLoader loader = clazz.getClassLoader();
    String path = loader.getResource(".").getPath();
    path = path.substring(0, path.length() - "/target/classes/".length());
    path = path.substring(path.lastIndexOf(File.separatorChar) + 1);
    return path + "/";
  }
}