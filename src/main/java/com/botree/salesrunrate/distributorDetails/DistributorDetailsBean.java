package com.botree.salesrunrate.distributorDetails;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.common.AbstractBean;
import com.botree.common.Navigation;
import com.botree.salesrunrate.entity.DistributorDetails;

@Component("distributorDetailsBean")
@Scope("session")
public class DistributorDetailsBean extends AbstractBean {

	private String distCode;
	private String distName;
	private String mobile;
	private String email;
	private String country;
	private String state;
	private String city;
	private String mode;

	@Autowired
	private IDistributorDetailsService service;
	List<DistributorDetails> distributorDetails = new ArrayList<>();
	DistributorDetails distributor=new DistributorDetails();

	@Autowired
	Navigation navi;

	public void save() {
		if (this.mode != "edit") {
			distributor = service.findAll(distCode);
			if (distributor == null) {
				service.save(distCode, distName, mobile, email, country, state, city);
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
			} else {
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("content:save", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Distributor Code already exists", "Distributor Code already exists"));
			}
		}
	}

	@PostConstruct
	public void findDistributorDetails() {
		distributorDetails = service.findAll();

	}

	public List<DistributorDetails> getDistributorDetails() {
		return distributorDetails;
	}

	public void setDistributorDetails(List<DistributorDetails> distributorDetails) {
		this.distributorDetails = distributorDetails;
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String getHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void setSearchPage() {
		// TODO Auto-generated method stub

	}

	public void update(DistributorDetails dist) {
		this.mode = "edit";
		distCode=dist.getDistCode();
		distName=dist.getDistName();
		mobile=dist.getMobile();
		email=dist.getEmail();
		country=dist.getCountry();
		state=dist.getState();
		city=dist.getCity();
		navi.selectUrl("/pages/distributorDetails/entity.xhtml");
	}

	@Override
	public void delete() {
		service.delete(distributorDetails);
	}
	

}
