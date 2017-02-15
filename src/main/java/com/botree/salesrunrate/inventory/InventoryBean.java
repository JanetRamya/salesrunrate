package com.botree.salesrunrate.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.Inventory;
import com.botree.salesrunrate.entity.ProductDetails;
import com.botree.salesrunrate.productDetails.IProductDetailsService;

@Component("inventoryBean")
@Scope("session")
public class InventoryBean {
	private String prdCode;
	private String prdName;
	private String qty;

	@Autowired
	private IInventoryService service;

	@Autowired
	private IProductDetailsService productService;
	List<ProductDetails> prodList = new ArrayList<>();
	ProductDetails prodNameList = new ProductDetails();
	Map<String, String> prodMap = new HashMap<>();
	private String productName;
	List<Inventory> stock= new ArrayList<>();
	
Inventory inventory = new Inventory();

	public void save() {
		service.save(prdCode,prdName,qty);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
	}

	public void findInventory() {
		inventory = service.findAll(prdName);

	}

	@PostConstruct
	public void findAll(){
		stock=service.findAll();
	}
	@PostConstruct
	public List<ProductDetails> findProducts()

	{
		prodMap = new HashMap<>();
		prodList = productService.findAll();

		for (ProductDetails retailer : prodList) {
			prodMap.put(retailer.getPrdCode(), retailer.getPrdName());

		}
		return prodList;
	}

	public void loadProductName() {
		prodNameList = productService.findProdName(prdCode);
		productName = prodNameList.getPrdName();

	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public IInventoryService getService() {
		return service;
	}

	public void setService(IInventoryService service) {
		this.service = service;
	}

	public IProductDetailsService getProductService() {
		return productService;
	}

	public void setProductService(IProductDetailsService productService) {
		this.productService = productService;
	}

	public List<ProductDetails> getProdList() {
		return prodList;
	}

	public void setProdList(List<ProductDetails> prodList) {
		this.prodList = prodList;
	}

	public Map<String, String> getProdMap() {
		return prodMap;
	}

	public void setProdMap(Map<String, String> prodMap) {
		this.prodMap = prodMap;
	}

	public ProductDetails getProdNameList() {
		return prodNameList;
	}

	public void setProdNameList(ProductDetails prodNameList) {
		this.prodNameList = prodNameList;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public List<Inventory> getStock() {
		return stock;
	}

	public void setStock(List<Inventory> stock) {
		this.stock = stock;
	}


}
