package com.botree.salesrunrate.productDetails;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("productDetailsBean")
@Scope("session")

public class ProductDetailsBean {
	
	private String prdcode;
	private String prdname;
	private String price;
	
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
