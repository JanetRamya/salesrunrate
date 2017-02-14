package com.botree.salesrunrate.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "salesmanDetails")
public class SalesmanDetails extends MongoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String smCode;
	private String smName;
	private String distBranch;
	private String compName;
	private String mobile;
	private String email;
	private String allow;
	private String monSalary;

	public String getSmCode() {
		return smCode;
	}

	public void setSmCode(String smCode) {
		this.smCode = smCode;
	}

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public String getDistBranch() {
		return distBranch;
	}

	public void setDistBranch(String distBranch) {
		this.distBranch = distBranch;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
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

	public String getMonSalary() {
		return monSalary;
	}

	public void setMonSalary(String monSalary) {
		this.monSalary = monSalary;
	}

}
