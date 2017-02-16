package com.botree.salesrunrate.distributorTarget;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.botree.salesrunrate.entity.DistributorTarget;

public class DistributorTargetService implements IDistributorTargetService{
	
	@Autowired
	private DistributorTargetRepo repository; 

	@Override
	public void save(String distCode, String distName, String prdCode, String prdName, String stock, String tqty) {
		DistributorTarget distributorTarget=new DistributorTarget();
		distributorTarget.setDistCode(distCode);
		distributorTarget.setDistName(distName);
		distributorTarget.setPrdCode(prdCode);
		distributorTarget.setPrdName(prdName);
		distributorTarget.setStock(stock);
		distributorTarget.settQty(tqty);
		repository.save(distributorTarget);
	}

	@Override
	public List<DistributorTarget> findAll() {
		return repository.findAll();
	}

	@Override
	public DistributorTarget findAll(String distCode) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}


