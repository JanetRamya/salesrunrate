package com.botree.salesrunrate.inventory;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.Inventory;

@Component("inventoryBean")
@Scope("session")
public class InventoryBean {
	private String prdName;
	private String prdCode;
	private String qty;

	@Autowired
	private IInventoryService service;
	Inventory inventory =new Inventory();
	
	public void save(){
		service.save(prdName,prdCode,qty);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog",true);
	}
	
	public void findInventory()
	{
		inventory=service.findAll(prdName);
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
	
}
