package com.botree.salesrunrate.productDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.ProductDetails;

@Component
public class ProductDetailsService implements IProductDetailsService {

	@Autowired
	private ProductDetailsRepo repository;

	@Override
	public void save(String prdCode, String prdName, String price) {
		ProductDetails productDetails = new ProductDetails();
		productDetails.setPrdCode(prdCode);
		productDetails.setPrdName(prdName);
		productDetails.setPrice(price);
		repository.save(productDetails);  

	}

	@Override
	public ProductDetails findAll(String prdCode) {
		return repository.findOneByPrdCode(prdCode);
	}


}
