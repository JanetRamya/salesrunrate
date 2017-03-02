package com.botree.salesrunrate.billingDetails;

import java.util.List;

import com.botree.salesrunrate.entity.BillingDetails;

public interface IBillingDetailsService {

	public void save(final String custCode, final String custName, final String smCode, final String prdCode,
			final String prdName, final String qty, final String orderQuantity, final String price);

	public List<BillingDetails> findAll();
	public List<BillingDetails> findAll(String distrCode);

}