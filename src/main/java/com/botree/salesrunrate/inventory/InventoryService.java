package com.botree.salesrunrate.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.Inventory;

@Component
public class InventoryService implements IInventoryService {
	
	@Autowired
	private InventoryRepo repository;

	@Override
	public void save(String prdCode, String prdName, String qty) {
		Inventory inventory=new Inventory();
		inventory.setPrdCode(prdCode);
		inventory.setPrdName(prdName);
		inventory.setQty(qty);
		repository.save(inventory);	
		
	}

	@Override
	public Inventory findAll(String prdName) {
		return repository.findOneByPrdName(prdName);
	}

	@Override
	public List<Inventory> findAll() {
		return repository.findAll();
	}

	@Override
	public Inventory findQuantity(String qty) {
		// TODO Auto-generated method stub
		return repository.findByQty(qty);
	}


}
