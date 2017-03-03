package com.botree.salesrunrate.distributorTarget;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.DistributorTarget;

public interface DistributorTargetRepo extends MongoRepository<DistributorTarget, String> {

public DistributorTarget findOneByDistName(String distName);
public List<DistributorTarget> findBySdateGreaterThanAndEdateLessThan(Date fromDate, Date toDate); 

}
