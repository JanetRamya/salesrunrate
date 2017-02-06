package com.botree.salesrunrate.distributorDetails;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("distributorDetails")
@Scope("session")
public class DistributorDetailsBean {
	private String dtname;
	private String dtcode;
    private String mobile;
    private String email;
	private String country;
	private String state;
	private String city;
	public String getDtname() {
		return dtname;
	}
	public void setDtname(String dtname) {
		this.dtname = dtname;
	}
	public String getDtcode() {
		return dtcode;
	}
	public void setDtcode(String dtcode) {
		this.dtcode = dtcode;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	

}
