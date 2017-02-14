package com.botree.salesrunrate.distributorDetails;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.DistributorDetails;

@Component("distributorDetailsBean")
@Scope("session")
public class DistributorDetailsBean {
	private String distCode;
	private String distName;
	private String mobile;
	private String email;
	private String country;
	private String state;
	private String city;

	@Autowired
	private IDistributorDetailsService service;
	List<DistributorDetails> distributorDetails = new ArrayList<>();

	public void save() {
		service.save(distCode, distName, mobile, email, country, state, city);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
	}

	@PostConstruct
	public void findAll() {
		distributorDetails = service.findAll();
	}

	public String getDistCode() {
		return distCode;
	}

	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
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

	public List<DistributorDetails> getDistributorDetails() {
		return distributorDetails;
	}

	public void setDistributorDetails(List<DistributorDetails> distributorDetails) {
		this.distributorDetails = distributorDetails;
	}

}
