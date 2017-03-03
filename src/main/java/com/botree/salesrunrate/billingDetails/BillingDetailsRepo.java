
package com.botree.salesrunrate.billingDetails;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.BillingDetails;

public interface BillingDetailsRepo extends MongoRepository<BillingDetails, String> {
	public List<BillingDetails> findByDistrCode(String distrCode);

}