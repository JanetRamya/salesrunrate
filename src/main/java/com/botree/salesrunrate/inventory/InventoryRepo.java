package com.botree.salesrunrate.inventory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.Inventory;

public interface InventoryRepo extends MongoRepository<Inventory, String>{

	public Inventory findOneByPrdName(String prdName);

	 Inventory findByQty(String qty);
	
	

}
