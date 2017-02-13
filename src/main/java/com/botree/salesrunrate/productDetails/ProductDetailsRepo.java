package com.botree.salesrunrate.productDetails;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.botree.salesrunrate.entity.ProductDetails;

public interface ProductDetailsRepo extends MongoRepository<ProductDetails, String> {

	ProductDetails findOneByPrdCode(String prdCode);
	
	

}
