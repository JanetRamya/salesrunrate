package com.botree.salesrunrate.productDetails;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
	List<ProductDetails> productDetails = new ArrayList<>();
	ProductDetails product=new ProductDetails();

	public void save() {
		product=service.findAll(prdCode);
		if(product==null){
			service.save(prdCode, prdName, price);
			RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
		} else {
			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("content:saveForm:save", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Product Code already exists",
					"Product Code already exists"));
		}
		
	}

	@PostConstruct
	public void findAll() {
		productDetails = service.findAll();
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

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

}
