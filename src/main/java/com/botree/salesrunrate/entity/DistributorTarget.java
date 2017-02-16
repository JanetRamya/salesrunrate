package com.botree.salesrunrate.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "distributorTarget")
public class DistributorTarget extends MongoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String distCode;
	private String distName;
	private String prdCode;
	private String prdName;
	private String stock;
	private String tQty;
	
	
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
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String gettQty() {
		return tQty;
	}
	public void settQty(String tQty) {
		this.tQty = tQty;
	}
	
	
	

}
