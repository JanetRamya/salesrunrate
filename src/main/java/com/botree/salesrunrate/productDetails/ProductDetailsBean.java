package com.botree.salesrunrate.productDetails;

import javax.annotation.PostConstruct;

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
	
	public void save(){
		service.save(prdCode,prdName,price);

	}
	@PostConstruct
	public void findProductDetails()
	{
		productDetails=service.findAll(prdCode);
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
	
	

}
