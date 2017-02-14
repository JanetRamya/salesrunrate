package com.botree.salesrunrate.salesmanDetails;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.botree.salesrunrate.entity.SalesmanDetails;

public interface SalesmanDetailsRepo extends MongoRepository<SalesmanDetails, String> {

	SalesmanDetails findOneBySmCode(String smCode);

}
