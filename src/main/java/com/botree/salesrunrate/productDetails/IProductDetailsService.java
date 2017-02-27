package com.botree.salesrunrate.productDetails;

import java.util.List;

import com.botree.salesrunrate.entity.ProductDetails;

public interface IProductDetailsService {

	public void save(final String prdCode, final String prdName, final String price);

	public List<ProductDetails> findAll();
	
	public ProductDetails findAll(String prdCode);
	
	public ProductDetails findProdName(String prdCode);
	
	public ProductDetails findPrice(String prodCod);


}
