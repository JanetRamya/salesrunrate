package com.botree.salesrunrate.productDetails;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.ProductDetails;

@Component("productDetailsBean")
@Scope("session")

public class ProductDetailsBean {
	
	private String prdCode;
	private String prdName;
	private String price;
	
	@Autowired
	private IProductDetailsService service;
	ProductDetails productDetails=new ProductDetails();
	
	List<ProductDetails> details=new ArrayList<>();
	
	public void save(){
		service.save(prdCode,prdName,price);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog",true);
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public List<ProductDetails> getDetails() {
		return details;
	}

	public void setDetails(List<ProductDetails> details) {
		this.details = details;
	}
	
	

}
