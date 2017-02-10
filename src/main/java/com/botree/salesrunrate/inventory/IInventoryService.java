package com.botree.salesrunrate.inventory;

import com.botree.salesrunrate.entity.Inventory;

public interface IInventoryService {

	public void save(String prdName,String prdCode, String qty);

	public Inventory findAll(String prdName);

}
