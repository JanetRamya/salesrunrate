package com.botree.salesrunrate.userProfile;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.botree.common.AbstractBean;
import com.botree.common.Navigation;
import com.botree.common.UserSession;
import com.botree.salesrunrate.entity.UserProfile;

@Component("userProfileBean")
@Scope("session")
public class UserProfileBean extends AbstractBean {
	private String userName;
	private String password;
	private String mobileNo;
	private String emailId;
	private String mode;
	

	@Autowired
	private IUserProfileService service;
	UserProfile userProfile = new UserProfile();
	UserProfile usr = new UserProfile();

	@Autowired
	private UserSession userSession;
	
	@Autowired
	Navigation navi;

	public void save() {
		if (this.mode != "edit") {
			usr = service.findAll(userName);
			if (usr == null) {
				service.save(userName, password, emailId, mobileNo);
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
			} else {
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("content:saveForm:save", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"UserName already exists", "UserName already exists"));
			}
		} else {
			service.save(userName, password, emailId, mobileNo);
			RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
		}
	}
	
	@PostConstruct
	public void findUserProfile() {
		userProfile = service.findAll(userSession.getUserName());
	}

	
	@Override
	public String getHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		service.delete(userProfile);
		
	}

	@Override
	public void setSearchPage() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(UserProfile user)
	{
		this.mode="edit";
	userName=user.getUserName();
	password=userSession.getPassword();
	mobileNo=user.getMobileNo();
	emailId=user.getEmailId();
		navi.selectUrl("/pages/userProfile/entity.xhtml");	
		
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	

}
