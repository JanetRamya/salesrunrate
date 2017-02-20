package com.botree.salesrunrate.distributorTarget;

import java.util.List;

import com.botree.salesrunrate.entity.DistributorTarget;

public interface IDistributorTargetService {

	public void save(final String distCode, final String distName,final String sdate,final String edate, final String prdCode, final String prdName,
			final String stock, final String tqty);

	public List<DistributorTarget> findAll();
	public DistributorTarget findAll(String distName);


}
