package com.sajhasite.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemPropertiesHelperListener implements ServletContextListener {
	public static final String PROPERTY_NAME_PREFIX = "_SYSTEM_PROPERTY_";
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext context = e.getServletContext();
		Enumeration<String> initParamNames = context.getInitParameterNames();
		while(initParamNames.hasMoreElements()) {
			String initParamName = initParamNames.nextElement();
			if(initParamName.startsWith(PROPERTY_NAME_PREFIX)) {
				String sysPropName = initParamName.substring(PROPERTY_NAME_PREFIX.length());
				String sysProp = context.getInitParameter(initParamName);
				System.setProperty(sysPropName, sysProp);
				log.debug("System property added [" + sysPropName + ": " + sysProp + "]");
			}
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) { }
}
