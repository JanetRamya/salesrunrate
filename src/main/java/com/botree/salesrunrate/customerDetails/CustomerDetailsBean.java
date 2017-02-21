package com.botree.salesrunrate.customerDetails;

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
import com.botree.salesrunrate.distributorDetails.IDistributorDetailsService;
import com.botree.salesrunrate.entity.CustomerDetails;
import com.botree.salesrunrate.entity.DistributorDetails;
import com.botree.salesrunrate.entity.SalesmanDetails;
import com.botree.salesrunrate.salesmanDetails.ISalesmanDetailsService;

@Component("customerDetailsBean")
@Scope("session")

public class CustomerDetailsBean extends AbstractBean{

		private String custCode;
		private String custName;
		private String distCode;
		private String smCode;
		
	@Autowired
	private ICustomerDetailsService service;
		@Autowired
		private IDistributorDetailsService distributorService;

		@Autowired
		private ISalesmanDetailsService salesmanService;
		
		List<DistributorDetails> distList = new ArrayList<>();
		DistributorDetails distNameList = new DistributorDetails();
		Map<String, String> distMap = new HashMap<>();
		List<CustomerDetails> cust = new ArrayList<>();
		
		List<SalesmanDetails> salesList = new ArrayList<>();
		SalesmanDetails salesNameList = new SalesmanDetails();
		Map<String, String> salesMap = new HashMap<>();
		
		
		List<CustomerDetails> customer=new ArrayList<>();
		List<CustomerDetails> customerDetails= new ArrayList<>();
		
		
		@PostConstruct
		public List<DistributorDetails> findDistributor()

		{
			customer = service.findAll();
			distMap = new HashMap<>();
			distList = distributorService.findAll();

			for (DistributorDetails dist : distList) {
				distMap.put(dist.getDistCode() + " - " + dist.getDistName(), dist.getDistCode());
			}
			return distList;
		}

		@PostConstruct
		public List<SalesmanDetails> findSalesman()

		{
			customer = service.findAll();
			salesMap = new HashMap<>();
			salesList = salesmanService.findAll();

			for (SalesmanDetails sale : salesList) {
				salesMap.put(sale.getSmCode()+ " - " + sale.getSmName(), sale.getSmCode());
			}
			return salesList;
		}
		

		public List<SalesmanDetails> getSalesList() {
			return salesList;
		}

		public void setSalesList(List<SalesmanDetails> salesList) {
			this.salesList = salesList;
		}

		public SalesmanDetails getSalesNameList() {
			return salesNameList;
		}

		public void setSalesNameList(SalesmanDetails salesNameList) {
			this.salesNameList = salesNameList;
		}

		public Map<String, String> getSalesMap() {
			return salesMap;
		}

		public void setSalesMap(Map<String, String> salesMap) {
			this.salesMap = salesMap;
		}

		public void save() {
		customer=service.findAll(custCode);
			String[] codes=distCode.split(" - ");
			String distrCode=codes[0];
			String[] code=smCode.split(" - ");
			String salesCode=code[0];
			if(customer==null){
				service.save(custCode, custName, distrCode,salesCode);
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
			} else {
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("content:save", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Customer Code already exists",
						"Customer Code already exists"));
			}
			
		}

		public List<DistributorDetails> getDistList() {
			return distList;
		}

		public void setDistList(List<DistributorDetails> distList) {
			this.distList = distList;
		}

		public DistributorDetails getDistNameList() {
			return distNameList;
		}

		public void setDistNameList(DistributorDetails distNameList) {
			this.distNameList = distNameList;
		}

		public Map<String, String> getDistMap() {
			return distMap;
		}

		public void setDistMap(Map<String, String> distMap) {
			this.distMap = distMap;
		}
	public String getCustCode() {
			return custCode;
		}

		public void setCustCode(String custCode) {
			this.custCode = custCode;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		
	public String getDistCode() {
			return distCode;
		}

		public void setDistCode(String distCode) {
			this.distCode = distCode;
		}

		public String getSmCode() {
			return smCode;
		}

		public void setSmCode(String smCode) {
			this.smCode = smCode;
		}

	public List<CustomerDetails> getCustomerDetails() {
			return customerDetails;
		}

		public void setCustomerDetails(List<CustomerDetails> customerDetails) {
			this.customerDetails = customerDetails;
		}


	public List<CustomerDetails> getCust() {
			return cust;
		}

		public void setCust(List<CustomerDetails> cust) {
			this.cust = cust;
		}

		

	public List<CustomerDetails> getCustomer() {
			return customer;
		}

		public void setCustomer(List<CustomerDetails> customer) {
			this.customer = customer;
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
