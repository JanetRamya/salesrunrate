package com.botree.salesrunrate.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="salesmanTarget")
public class SalesmanTarget extends MongoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String smCode;
	private String smName;
	private Date sdate;
	private Date edate;
	private String prdCode;
	private String prdName;
	private String qty;
	private String tqty;
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
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
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
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getTqty() {
		return tqty;
	}
	public void setTqty(String tqty) {
		this.tqty = tqty;
	}
	
}
