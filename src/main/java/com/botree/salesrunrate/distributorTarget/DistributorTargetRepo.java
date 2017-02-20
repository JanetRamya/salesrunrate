package com.botree.salesrunrate.distributorTarget;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.DistributorTarget;

public interface DistributorTargetRepo extends MongoRepository<DistributorTarget, String> {

public DistributorTarget findOneByDistName(String distName);

}
