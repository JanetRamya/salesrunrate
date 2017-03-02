package com.botree.salesrunrate.billingDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.common.AbstractBean;
import com.botree.salesrunrate.customerDetails.ICustomerDetailsService;
import com.botree.salesrunrate.entity.BillingDetails;
import com.botree.salesrunrate.entity.CustomerDetails;
import com.botree.salesrunrate.entity.Inventory;
import com.botree.salesrunrate.entity.ProductDetails;
import com.botree.salesrunrate.inventory.IInventoryService;
import com.botree.salesrunrate.productDetails.IProductDetailsService;

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
	private boolean renderFlag;

	@Autowired
	private ICustomerDetailsService custService;
	@Autowired
	private IInventoryService invService;
	@Autowired
	private IBillingDetailsService service;

	@Autowired
	private IProductDetailsService prodService;
	@Autowired
	private BillingDetailsRepo billingDetailsRepo;

	@Autowired
	private IInventoryService inventoryService;

	Inventory inventory = new Inventory();

	List<CustomerDetails> custList = new ArrayList<>();
	CustomerDetails custNameList = new CustomerDetails();
	Map<String, String> custMap = new HashMap<>();

	List<Inventory> invList = new ArrayList<>();
	Inventory invNameList = new Inventory();
	Map<String, String> invMap = new HashMap<>();

	private String quantity;
	List<BillingDetails> bill = new ArrayList<>();
	BillingDetails billingDetails = new BillingDetails();

	ProductDetails productPrice = new ProductDetails();

	List<BillingForm> list = new ArrayList<>();
	List<BillingForm> listProd = new ArrayList<>();
	BillingForm productList = new BillingForm();
	BillingDetails billingDetailsList = new BillingDetails();

	public void save() {
		String[] cust = custCode.split(" - ");
		billingDetailsList.setCustCode(cust[0]);
		billingDetailsList.setCustName(cust[1]);
		billingDetailsList.setDistrCode(userSession.getDistrCode());
		billingDetailsList.setSmCode(smCode);
		for (BillingForm billing : list) {
			billingDetailsList.setPrdCode(billing.getPrdCode());
			billingDetailsList.setPrdName(billing.getPrdName());
			billingDetailsList.setQty(billing.getQty());
			billingDetailsList.setOrderQuantity(billing.getOrderQuantity());
			billingDetailsList.setPrice(billing.getPrice());
			billingDetailsRepo.save(billingDetailsList);
			Integer totalQty = Integer.parseInt(billing.getQty()) - Integer.parseInt(billing.getOrderQuantity());
			// inventory.setQty(totalQty.toString());
			inventoryService.save(billing.getPrdCode(), billing.getPrdName(), totalQty.toString());
			RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
		}
	}

	public void findBill() {

	}

	@PostConstruct
	public List<CustomerDetails> findCustomer() {
		bill = service.findAll();
		custMap = new HashMap<>();
		custList = custService.findAll();

		for (CustomerDetails cust : custList) {
			custMap.put(cust.getCustCode() + " - " + cust.getCustName(), cust.getSmCode());
		}
		return custList;
	}

	@PostConstruct
	public List<Inventory> findProd() {
		bill = service.findAll();
		invMap = new HashMap<>();
		invList = invService.findAll();

		for (Inventory inv : invList) {
			invMap.put(inv.getPrdCode() + " - " + inv.getPrdName(), inv.getQty());
		}
		return invList;
	}

	public void loadSalesman() {
		smCode = custMap.get(custCode);
	}

	public void loadQuantity() {

		qty = invMap.get(prdCode);
		orderQuantity = "";
		price = "";

	}

	public void getProductPrice() {
		String[] prodCode = prdCode.split(" - ");
		productPrice = prodService.findPrice(prodCode[0]);
		Integer prodPrice = Integer.parseInt(productPrice.getPrice()) * Integer.parseInt(orderQuantity);
		setPrice(prodPrice.toString());
	}

	public void addProduct() {
		renderFlag = true;
		productList = new BillingForm();
		if (orderQuantity == "") {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("content:addProd", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Order Quantity should not be blank", "Order Quantity should not be blank"));
			return;
		}
		String[] code = prdCode.split(" - ");
		productList.setPrdCode(code[0]);
		productList.setPrdName(code[1]);
		productList.setQty(qty);
		productList.setOrderQuantity(orderQuantity);
		productList.setPrice(getPrice());
		list.add(productList);
		orderQuantity = "";
		price = "";

	}

	public void editProduct(BillingForm bill) {
		list.remove(bill);
		setOrderQuantity(bill.getOrderQuantity());
		setPrice(bill.getPrice());
		setQty(bill.getQty());
		setPrdCode(bill.getPrdCode() + " - " + bill.getPrdName());
	}

	public void deleteProduct(BillingForm billProd) {
		list.remove(billProd);
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

	public List<BillingForm> getList() {
		return list;
	}

	public void setList(List<BillingForm> list) {
		this.list = list;
	}

	public boolean isRenderFlag() {
		return renderFlag;
	}

	public void setRenderFlag(boolean renderFlag) {
		this.renderFlag = renderFlag;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<BillingForm> getListProd() {
		return listProd;
	}

	public void setListProd(List<BillingForm> listProd) {
		this.listProd = listProd;
	}

	public BillingForm getProductList() {
		return productList;
	}

	public void setProductList(BillingForm productList) {
		this.productList = productList;
	}

	public BillingDetails getBillingDetailsList() {
		return billingDetailsList;
	}

	public void setBillingDetailsList(BillingDetails billingDetailsList) {
		this.billingDetailsList = billingDetailsList;
	}

	@Override
	public String getHeader() {
		return null;
	}

	@Override
	public void delete() {

	}

	@Override
	public void setSearchPage() {

	}

}