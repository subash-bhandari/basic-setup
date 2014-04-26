package com.sajhasite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jConfigurationListener implements ServletContextListener {
	public static final String LOG4J_CONFIG_FILE = "com/sajhasite/resource/log4j.xml";
	public static final String JBOSS_LOGGING_PROVIDER_SYS_PROP = "org.jboss.logging.provider"; 
	public static final String JBOSS_LOGGING_PROVIDER = "log4j";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ClassLoader classLoader = Log4jConfigurationListener.class.getClassLoader();
		DOMConfigurator.configure(classLoader.getResource(LOG4J_CONFIG_FILE));		
		Logger logger = LoggerFactory.getLogger(Log4jConfigurationListener.class);
		logger.info("Log4j configuration complete!");		
		//tell jboss logging to use log4j log manager
		String prevVal = System.setProperty(JBOSS_LOGGING_PROVIDER_SYS_PROP, JBOSS_LOGGING_PROVIDER);
		logger.info(String.format("Jboss logging provider is changed from %s to %s.", prevVal, JBOSS_LOGGING_PROVIDER));
	}
}
