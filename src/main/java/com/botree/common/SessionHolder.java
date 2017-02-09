package com.botree.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionHolder {

	private static final Logger LOG = LoggerFactory.getLogger(SessionHolder.class);
	private static SessionHolder sessionHolder = null;
	private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

	private SessionHolder() {
	}

	public static synchronized SessionHolder getIntance() {
		if (sessionHolder == null) {
			sessionHolder = new SessionHolder();
		}
		return sessionHolder;
	}

	public void saveSession(final String userName, final HttpSession session) {
		sessionMap.put(userName.toLowerCase(), session);
	}

	public void clearSession(final String userName) {
		if (userName != null) {
			HttpSession session = sessionMap.get(userName.toLowerCase());
			if (session != null) {
				invalidateSession(session);
				sessionMap.remove(userName);
			}
		}
	}

	private void invalidateSession(HttpSession session) {
		try {
			session.invalidate();
		} catch (Exception e) {
			LOG.error("Session already invalidated", e);
		}
	}
}
