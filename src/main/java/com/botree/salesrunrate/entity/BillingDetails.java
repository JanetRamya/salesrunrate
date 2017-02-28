package com.botree.salesrunrate.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="billingDetails")
public class BillingDetails extends MongoEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id	
private String custCode;
private String custName;
private String smCode;
private String prdCode;
private String prdName;
private String qty;
private String orderQuantity;
private String price;

public String getPrdName() {
	return prdName;
}
public void setPrdName(String prdName) {
	this.prdName = prdName;
}
public String getCustCode() {
	return custCode;
}
public void setCustCode(String custCode) {
	this.custCode = custCode;
}
public String getSmCode() {
	return smCode;
}
public void setSmCode(String smCode) {
	this.smCode = smCode;
}
public String getPrdCode() {
	return prdCode;
}
public void setPrdCode(String prdCode) {
	this.prdCode = prdCode;
}
public String getQty() {
	return qty;
}
public void setQty(String qty) {
	this.qty = qty;
}

public String getOrderQuantity() {
	return orderQuantity;
}
public void setOrderQuantity(String orderQuantity) {
	this.orderQuantity = orderQuantity;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}

}
