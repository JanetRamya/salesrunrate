package com.botree.salesrunrate.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customerDetails")
public class CustomerDetails extends MongoEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String custCode;
	private String custName;
	private String distName;
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	 
	

}
