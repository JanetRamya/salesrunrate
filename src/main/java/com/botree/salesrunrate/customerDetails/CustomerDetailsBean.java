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

@Component("customerDetailsBean")
@Scope("session")

public class CustomerDetailsBean extends AbstractBean{

		private String custCode;
		private String custName;
		private String distCode;
		private String smCode;

		@Autowired
		private ICustomerDetailsService custService;

		@Autowired
		private IDistributorDetailsService distributorService;

		List<DistributorDetails> distList = new ArrayList<>();
		DistributorDetails distNameList = new DistributorDetails();
		Map<String, String> distMap = new HashMap<>();
		List<CustomerDetails> cust = new ArrayList<>();
		
	
		CustomerDetails customer=new CustomerDetails();
		List<CustomerDetails> customerDetails= new ArrayList<>();
		
		
		@PostConstruct
		public List<DistributorDetails> findDistributor()

		{
			cust = custService.findAll();
			distMap = new HashMap<>();
			distList = distributorService.findAll();

			for (DistributorDetails dist : distList) {
				distMap.put(dist.getDistCode() + " - " + dist.getDistName(), dist.getDistCode());
			}
			return distList;
		}

		public void save() {
			customer=custService.findAll(custCode);
			String[] codes=distCode.split(" - ");
			String distrCode=codes[0];
			String[] code=smCode.split(" - ");
			String salesCode=code[0];
			if(customer==null){
				custService.save(custCode, custName, distrCode,salesCode);
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
			} else {
				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("content:save", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Customer Code already exists",
						"Customer Code already exists"));
			}
			
		}

		@PostConstruct
		public void findAll() {
			customerDetails= custService.findAll();;
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
