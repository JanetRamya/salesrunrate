package com.botree.salesrunrate.distributorDetails;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.botree.salesrunrate.entity.DistributorDetails;

public interface DistributorDetailsRepo extends MongoRepository<DistributorDetails, String> {
	
	DistributorDetails findOneByDistCode(String distCode);
}
