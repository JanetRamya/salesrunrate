package com.botree.salesrunrate.salesmanProfile;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("salesmanProfile")
@Scope("session")
public class SalesmanProfileBean {
	private String smname;
	private String smcode;
	private String dtbranch;
	private String compname;
	private String mobile;
	private String email;
	private String allow;
	private String msal;
	
	public String getSmname() {
		return smname;
	}
	public void setSmname(String smname) {
		this.smname = smname;
	}
	public String getSmcode() {
		return smcode;
	}
	public void setSmcode(String smcode) {
		this.smcode = smcode;
	}
	public String getDtbranch() {
		return dtbranch;
	}
	public void setDtbranch(String dtbranch) {
		this.dtbranch = dtbranch;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAllow() {
		return allow;
	}
	public void setAllow(String allow) {
		this.allow = allow;
	}
	public String getMsal() {
		return msal;
	}
	public void setMsal(String msal) {
		this.msal = msal;
	}
	
	
	

}
