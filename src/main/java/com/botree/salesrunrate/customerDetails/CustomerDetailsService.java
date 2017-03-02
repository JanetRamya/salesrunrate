package com.botree.salesrunrate.customerDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.CustomerDetails;

@Component
public class CustomerDetailsService implements ICustomerDetailsService {

	@Autowired
	public CustomerDetailsRepo repository;

	@Override
	public void save(String custCode, String custName, String distCode, String smCode) {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustCode(custCode);
		customerDetails.setCustName(custName);
		customerDetails.setDistCode(distCode);
		customerDetails.setSmCode(smCode);
		repository.save(customerDetails);
	}

	@Override
	public List<CustomerDetails> findAll() {
		return repository.findAll();
	}

	@Override
	public CustomerDetails findAll(String custCode) {
		String[] first = custCode.split(" - ");
		custCode = first[0];
		return repository.findByCustCode(custCode);
	}

}
