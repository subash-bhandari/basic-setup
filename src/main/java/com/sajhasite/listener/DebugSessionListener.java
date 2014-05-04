package com.sajhasite.listener;

import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugSessionListener implements HttpSessionListener {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		HttpSession session = e.getSession();
		log.debug("A new http session has been created with session id " + session.getId());		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {		
		HttpSession session = e.getSession();
		log.debug("A http session with id " + session.getId() + " is being destroyed ...");
		log.debug("Attribute names are " + Collections.list(session.getAttributeNames()));		
	}
}
