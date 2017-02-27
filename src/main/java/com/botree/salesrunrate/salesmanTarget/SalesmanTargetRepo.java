package com.botree.salesrunrate.salesmanTarget;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.SalesmanTarget;

public interface SalesmanTargetRepo extends MongoRepository<SalesmanTarget, String> {

	public SalesmanTarget findOneBySmName(String smName);

}
