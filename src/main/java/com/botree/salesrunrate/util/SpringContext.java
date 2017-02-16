package com.botree.salesrunrate.util;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContextIn) throws BeansException {
		applicationContext = applicationContextIn;
	}

	public static Object getBean(String beanId) {
		return applicationContext.getBean(beanId);
	}

	/**
	 * Returns a message which are defined in a property file. This can be used
	 * in exception and localization
	 * 
	 * @param code
	 * @return message
	 */
	public static String getMessage(String code) {
		return applicationContext.getMessage(code, null, Locale.US);
	}

	public static String getMessage(String code, Object[] params) {
		return applicationContext.getMessage(code, params, Locale.US);
	}
}