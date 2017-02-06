package com.botree.salesrunrate.distributorTarget;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("distributorTarget")
@Scope("session")
public class DistributorTargetBean {
	
	private String dtcode;
	private String dtname;
	private String prdcode;
	private String prdname;
	private String tqty;
	
	public String getDtcode() {
		return dtcode;
	}
	public void setDtcode(String dtcode) {
		this.dtcode = dtcode;
	}
	public String getDtname() {
		return dtname;
	}
	public void setDtname(String dtname) {
		this.dtname = dtname;
	}
	public String getPrdcode() {
		return prdcode;
	}
	public void setPrdcode(String prdcode) {
		this.prdcode = prdcode;
	}
	public String getPrdname() {
		return prdname;
	}
	public void setPrdname(String prdname) {
		this.prdname = prdname;
	}
	public String getTqty() {
		return tqty;
	}
	public void setTqty(String tqty) {
		this.tqty = tqty;
	}
	
	

}
