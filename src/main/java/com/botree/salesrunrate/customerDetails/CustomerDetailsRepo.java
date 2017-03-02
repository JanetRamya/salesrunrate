package com.botree.salesrunrate.customerDetails;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.CustomerDetails;

public interface CustomerDetailsRepo extends MongoRepository<CustomerDetails, String> {

	public CustomerDetails findByCustCode(String custCode);
}
