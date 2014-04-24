package com.sajhasite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jConfigurationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		DOMConfigurator.configure(Log4jConfigurationListener.class.getClassLoader().getResource("com/sajhasite/resource/log4j.xml"));
		Logger logger = LoggerFactory.getLogger(Log4jConfigurationListener.class);
		logger.debug("Log4j configuration complete!");
		
		//tell jboss logging to use log4j log manager
		
		String JBOSS_LOGGING_PROVIDER = "org.jboss.logging.provider";
		String LOG_MANAGER_NAME = "log4j";
		String previousValue = System.setProperty(JBOSS_LOGGING_PROVIDER, LOG_MANAGER_NAME);
		logger.debug("Jboss logging log manager is change from " + previousValue + " to " + LOG_MANAGER_NAME);
	}
}
