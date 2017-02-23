package com.botree.salesrunrate.billingDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.common.AbstractBean;
import com.botree.salesrunrate.customerDetails.ICustomerDetailsService;
import com.botree.salesrunrate.entity.BillingDetails;
import com.botree.salesrunrate.entity.CustomerDetails;
import com.botree.salesrunrate.entity.Inventory;
import com.botree.salesrunrate.inventory.IInventoryService;
@Component("billingDetailsBean")
@Scope("session")

public class BillingDetailsBean extends AbstractBean {
	
	private String custCode;
	private String custName;
	private String smCode;
	private String prdCode;
	private String prdName;
	private String qty;
	private String orderQuantity;
	private String price;

	@Autowired
	private ICustomerDetailsService custService;
	@Autowired
	private IInventoryService invService;
	@Autowired
	private IBillingDetailsService service;
	
	
	List<CustomerDetails> custList= new ArrayList<>();
	CustomerDetails custNameList=new CustomerDetails();
	Map<String, String> custMap = new HashMap<>();
	
	List<Inventory> invList= new ArrayList<>();
	Inventory invNameList=new Inventory();
	Map<String, String> invMap = new HashMap<>();
	
	private String quantity;
	List<BillingDetails> bill=new ArrayList<>();
	BillingDetails billingDetails =new BillingDetails();

	public void save()
	{
		service.save(custCode, custName, smCode, prdCode, prdName, qty, orderQuantity, price);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
	}
	
	public void findBill()
	{
	
	}
	
	@PostConstruct
	public List<CustomerDetails> findCustomer()
	{
		bill=service.findAll();
		custMap = new HashMap<>();
		custList = custService.findAll();

		for (CustomerDetails cust : custList) {
			custMap.put(cust.getCustCode()+ " - " + cust.getCustName(), cust.getSmCode());
		}
		return custList;
	}
	@PostConstruct
	public List<Inventory> findProd()
	{
		bill=service.findAll();
		invMap = new HashMap<>();
		invList =invService.findAll();

		for (Inventory inv : invList) {
			invMap.put(inv.getPrdCode()+ " - " + inv.getPrdName(), inv.getQty());
		}
		return invList;
	}
	
	public void loadSalesman(){
		String[] first = custCode.split(" - ");
		custCode = first[0];
		custNameList = custService.findAll(custCode);
		smCode = custNameList.getSmCode();
		}
	public void loadQuantity() {
		
		qty = invMap.get(prdCode);

	}
	public BillingDetails getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public List<BillingDetails> getBill() {
		return bill;
	}

	public void setBill(List<BillingDetails> bill) {
		this.bill = bill;
	}

	public List<Inventory> getInvList() {
		return invList;
	}

	public void setInvList(List<Inventory> invList) {
		this.invList = invList;
	}

	public Inventory getInvNameList() {
		return invNameList;
	}

	public void setInvNameList(Inventory invNameList) {
		this.invNameList = invNameList;
	}

	public Map<String, String> getInvMap() {
		return invMap;
	}

	public void setInvMap(Map<String, String> invMap) {
		this.invMap = invMap;
	}

	public List<CustomerDetails> getCustList() {
		return custList;
	}

	public void setCustList(List<CustomerDetails> custList) {
		this.custList = custList;
	}

	public CustomerDetails getCustNameList() {
		return custNameList;
	}

	public void setCustNameList(CustomerDetails custNameList) {
		this.custNameList = custNameList;
	}

	public Map<String, String> getCustMap() {
		return custMap;
	}

	public void setCustMap(Map<String, String> custMap) {
		this.custMap = custMap;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

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

	@Override
	public String getHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSearchPage() {
		// TODO Auto-generated method stub
		
	}

}
