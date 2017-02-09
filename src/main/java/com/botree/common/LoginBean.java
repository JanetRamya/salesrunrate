package com.botree.common;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.common.LoginBean;
import com.botree.common.SessionHolder;
import com.botree.salesrunrate.entity.UserProfile;

@Component("loginBean")
@Scope("session")
public class LoginBean extends AbstractBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginBean.class);

	private String userName;
	private String password;

	@Autowired
	UserService userService;
	
	@Autowired 
	UserSession userSession;
	UserProfile user = new UserProfile();

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

	public void login() {
		userSession.setUserName(userName);
		userSession.setPassword(password);
		user = userService.findUser(userName, password);
		
		try {
			if (user != null) {
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
						.getSession(true);
				SessionHolder.getIntance().saveSession(userName, session);
				FacesContext.getCurrentInstance().getExternalContext()
				.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
						+ "/pages/landing.xhtml");
			} else {
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
						.getSession(true);
				SessionHolder.getIntance().saveSession(userName, session);
				FacesContext.getCurrentInstance().getExternalContext()
				.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
						+ "/pages/login.xhtml");
			}

		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void logout()
	{
		SessionHolder.getIntance().clearSession(userSession.getUserName());
		try {
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
					+ "/pages/login.xhtml");
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

	}	
	
	
	

}
