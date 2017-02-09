package com.botree.salesrunrate.salesmanDetails;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.botree.salesrunrate.entity.SalesmanDetails;

@Component("salesmanDetailsBean")
@Scope("session")
public class SalesmanDetailsBean {
	
	private String smCode;
    private String smName;
    private String distBranch;
    private String compName;
    private String mobile;
    private String email;
    private String allow;
    private String monSalary;
    
    @Autowired
    private ISalesmanDetailsService service;
    SalesmanDetails salesmanDetails=new SalesmanDetails();
    
    public void save(){
    	service.save(smCode, smName, distBranch, compName, mobile, email, allow, monSalary);
    	RequestContext.getCurrentInstance().addCallbackParam("showDialog",true);
    	
    }
    public void findSalesmanDetails()
	{
		salesmanDetails=service.findAll(smCode);
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
	public SalesmanDetails getSalesmanDetails() {
		return salesmanDetails;
	}
	public void setSalesmanDetails(SalesmanDetails salesmanDetails) {
		this.salesmanDetails = salesmanDetails;
	}

    
    

}
