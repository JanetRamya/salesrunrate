package com.botree.salesrunrate.userProfile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.common.UserSession;
import com.botree.salesrunrate.entity.UserProfile;

@Component("userProfileBean")
@Scope("session")
public class UserProfileBean {

	private String userName;
	private String password;
	private String mobileNo;
	private String emailId;

	@Autowired
	private IUserProfileService service;
	UserProfile userProfile =new UserProfile();
	
	@Autowired
	private UserSession userSession;
	

	public void save() {
		
		if(userProfile.getUserName()==null)
		{
		service.save(userName, password, emailId, mobileNo);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog",true);
		}
		else
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("content:save", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Either UserName or Password Invalid", "UserName already exists"));
		}
	}
	
	@PostConstruct 
	public void findUserProfile()
	{
		userProfile=service.findAll(userSession.getUserName());
	}
	
	public void delete(UserProfile user)
	{
		service.delete(user);
	}
	
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	
	
	

}
