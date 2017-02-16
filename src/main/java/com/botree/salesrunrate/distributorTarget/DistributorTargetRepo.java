package com.botree.salesrunrate.distributorTarget;

import java.util.List;

import com.botree.salesrunrate.entity.DistributorTarget;

public interface DistributorTargetRepo {

	public void save(DistributorTarget distributorTarget);

	public List<DistributorTarget> findAll();

}
