package com.botree.salesrunrate.productDetails;

import com.botree.salesrunrate.entity.ProductDetails;

public interface IProductDetailsService {

	public void save(final String prdCode,final String prdName, final String price);

	public ProductDetails findAll(String prdCode);
}
