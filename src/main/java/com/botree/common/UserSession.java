package com.botree.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userSession")
@Scope("session")
public class UserSession {
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}