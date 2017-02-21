package com.botree.salesrunrate.customerDetails;

import java.util.List;

import com.botree.salesrunrate.entity.CustomerDetails;

public interface ICustomerDetailsService {
	public void save(final String custCode, final String custName, final String distCode,final String smCode);

	public List<CustomerDetails> findAll();
	
	public List<CustomerDetails> findAll(String custCode);
}
