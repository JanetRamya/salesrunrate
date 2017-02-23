package com.botree.salesrunrate.billingDetails;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.BillingDetails;

public interface BillingDetailsRepo extends MongoRepository<BillingDetails, String>{
	

}
