package com.botree.salesrunrate.inventory;

import java.util.List;

import com.botree.salesrunrate.entity.Inventory;


public interface IInventoryService {

	public void save(String prdCode,String prdName, String qty);

	public Inventory findAll(String prdName);
	
	public List<Inventory> findAll();

}
