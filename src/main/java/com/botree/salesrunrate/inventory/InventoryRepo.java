package com.botree.salesrunrate.inventory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.Inventory;

public interface InventoryRepo extends MongoRepository<Inventory, String>{

	Inventory findOneByPrdCode(String prdName);

}
