package com.botree.salesrunrate.billingDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.BillingDetails;

@Component
public class BillingDetailsService implements IBillingDetailsService {
	@Autowired
	public BillingDetailsRepo repository;

	@Override
	public void save(String custCode, String custName, String smCode, String prdCode, String prdName, String qty,
			String orderQuantity, String price) {
		BillingDetails billingDetails = new BillingDetails();
		billingDetails.setCustCode(custCode);
		billingDetails.setSmCode(smCode);
		billingDetails.setPrdCode(prdCode);
		billingDetails.setQty(qty);
		billingDetails.setOrderQuantity(orderQuantity);
		billingDetails.setPrice(price);
		repository.save(billingDetails);

	}

	@Override
	public List<BillingDetails> findAll() {
		return repository.findAll();
	}

	@Override
	public List<BillingDetails> findAll(String distrCode) {
		return repository.findByOrderQuantity(distrCode);
	}

}