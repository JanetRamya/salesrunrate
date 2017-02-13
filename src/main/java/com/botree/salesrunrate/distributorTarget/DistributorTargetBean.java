package com.botree.salesrunrate.distributorTarget;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("distributorTarget")
@Scope("session")
public class DistributorTargetBean {
	private String distname;
	private String distCode;
	private String prdCode;
	private String prdName;
	private String tQty;
	public String getDistname() {
		return distname;
	}
	public void setDistname(String distname) {
		this.distname = distname;
	}
	public String getDistCode() {
		return distCode;
	}
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}
	public String getPrdCode() {
		return prdCode;
	}
	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public String gettQty() {
		return tQty;
	}
	public void settQty(String tQty) {
		this.tQty = tQty;
	}
	
	
	
	

}
