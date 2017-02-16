package com.botree.salesrunrate.salesmanDetails;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.botree.common.AbstractBean;
import com.botree.common.Navigation;
import com.botree.salesrunrate.entity.SalesmanDetails;

@Component("salesmanDetailsBean")
@Scope("session")
public class SalesmanDetailsBean extends AbstractBean {

	private String smCode;
	private String smName;
	private String distBranch;
	private String compName;
	private String mobile;
	private String email;
	private String allow;
	private String monSalary;
	private String mode;
	@Autowired
	private ISalesmanDetailsService service;
	List<SalesmanDetails> salesmanDetails = new ArrayList<>();
	SalesmanDetails sales = new SalesmanDetails();

	@Autowired
	Navigation navi;

	public void save() {
		if (this.mode != "edit") {
			sales=service.findAll(smCode);
			if(sales==null){
				service.save(smCode, smName, distBranch, compName, mobile, email, allow, monSalary);
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
			}
			else {
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("content:save", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Salesman Code already exists",
						"Salesman Code already exists"));
			}
		}

		}

		@PostConstruct
		public void findAll() {
			salesmanDetails = service.findAll();
		}

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

		public List<SalesmanDetails> getSalesmanDetails() {
			return salesmanDetails;
		}

		public void setSalesmanDetails(List<SalesmanDetails> salesmanDetails) {
			this.salesmanDetails = salesmanDetails;
		}

		@Override
		public String getHeader() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete() {
			service.delete(salesmanDetails);
			

		}

		@Override
		public void setSearchPage() {
			// TODO Auto-generated method stub

		}
		public void update(SalesmanDetails sale)
		{
			this.mode="edit";
			smCode=sale.getSmCode();
			 smName=sale.getSmName();
			 distBranch=sale.getDistBranch();
			 compName=sale.getCompName();
			 mobile=sale.getMobile();
			 email=sale.getEmail();
			 allow=sale.getAllow();
			 monSalary=sale.getMonSalary();
		}

	}
