package com.botree.salesrunrate.salesmanTarget;

import java.util.Date;
import java.util.List;

import com.botree.salesrunrate.entity.SalesmanTarget;

public interface ISalesmanTargetService {
	public void save(final String smCode, final String smName, final Date sdate, final Date edate, final String prdCode,
			final String prdName, final String qty, final String tqty);
	
	public List<SalesmanTarget> findAll();
	
	public SalesmanTarget findAll(String smName);
}
