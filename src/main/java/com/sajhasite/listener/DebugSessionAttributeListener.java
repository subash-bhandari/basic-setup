package com.sajhasite.listener;

import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugSessionAttributeListener implements HttpSessionAttributeListener {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void attributeAdded(HttpSessionBindingEvent e) {
		HttpSession session = e.getSession();
		log.debug("A new attribute has been added to a http seesion ... ");
		log.debug("http session id is " + session.getId() + " and the attribute name is " + e.getName());
		log.debug("all attribute names are " + Collections.list(session.getAttributeNames()));
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent e) {
		HttpSession session = e.getSession();
		log.debug("An attribute has been removed from a http seesion ... ");
		log.debug("http session id is " + session.getId() + " and the attribute name is " + e.getName());
		log.debug("all attribute names are " + Collections.list(session.getAttributeNames()));
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent e) {
		HttpSession session = e.getSession();
		log.debug("An attribute has been replaced in a http seesion ... ");
		log.debug("http session id is " + session.getId() + " and the attribute name is " + e.getName());
		log.debug("all attribute names are " + Collections.list(session.getAttributeNames()));
	}

}
