package com.botree.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.botree.common.UserSession;

public class AbstractBean {
	@Autowired
	protected UserSession userSession;

}
