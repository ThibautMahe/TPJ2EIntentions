package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import DB.access.Populator;

@WebListener
public class MyServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent evt) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Populator.createSchema();
		Populator.populateSchema();
	}

	@Override
	public void contextDestroyed(ServletContextEvent evt) {

	}
}
