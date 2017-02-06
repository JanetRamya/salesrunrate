package com.botree.salesrunrate.inventory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("inventory")
@Scope("session")
public class InventoryBean {
private String prdcode;
private String prdname;
private String qty;
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
public String getQty() {
	return qty;
}
public void setQty(String qty) {
	this.qty = qty;
}


}
