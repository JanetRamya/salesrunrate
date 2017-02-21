package com.botree.salesrunrate.distributorTarget;

import java.util.Date;
import java.util.List;

import com.botree.salesrunrate.entity.DistributorTarget;

public interface IDistributorTargetService {

	public List<DistributorTarget> findAll();

	public DistributorTarget findAll(String distName);

	public void save(final String distCode, final String distName,final Date sdate,final Date edate,
			final String prdCode, final String prdName, final String qty,final  String tqty);

}
