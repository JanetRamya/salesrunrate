package com.botree.salesrunrate.userProfile;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.UserProfile;

@Component("userProfileBean")
@Scope("session")
public class UserProfileBean {

	private String id;
	private String userName;
	private String password;
	private String mobileNo;
	private String emailId;

	@Autowired
	private IUserProfileService service;
	
	UserProfile userProfile =new UserProfile();

	public void save() {
		service.save(userName, password, emailId, mobileNo);
	}
	
	@PostConstruct
	public void findUserProfile()
	{
		userProfile=service.findAll(userName);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
