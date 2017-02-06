package com.botree.salesrunrate.salesmanTarget;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("salesmanTarget")
@Scope("session")
public class SalesmanTargetBean {
	private String smcode;
	private String smname;
	private String prdcode;
	private String prdname;
	private String tqty;
	public String getSmcode() {
		return smcode;
	}
	public void setSmcode(String smcode) {
		this.smcode = smcode;
	}
	public String getSmname() {
		return smname;
	}
	public void setSmname(String smname) {
		this.smname = smname;
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
