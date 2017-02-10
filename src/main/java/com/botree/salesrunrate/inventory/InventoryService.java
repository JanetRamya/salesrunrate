package com.botree.salesrunrate.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.Inventory;

@Component
public class InventoryService implements IInventoryService {
	
	@Autowired
	private InventoryRepo repository;

	@Override
	public void save( String prdName,String prdCode, String qty) {
		Inventory inventory=new Inventory();
		inventory.setPrdName(prdName);
		inventory.setPrdCode(prdCode);
		inventory.setQty(qty);
		repository.save(inventory);	
		
	}

	@Override
	public Inventory findAll(String prdName) {
		return repository.findOneByPrdCode(prdName);
	}

}
