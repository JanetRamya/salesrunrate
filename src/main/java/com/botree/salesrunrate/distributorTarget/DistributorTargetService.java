package com.botree.salesrunrate.distributorTarget;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.DistributorTarget;

@Component
public class DistributorTargetService implements IDistributorTargetService{
	
	@Autowired
	private DistributorTargetRepo repository; 

	@Override
	public List<DistributorTarget> findAll() {
		return repository.findAll();
	}

	
	@Override
	public DistributorTarget findAll(String distName) {
		return repository.findOneByDistName(distName);
	}


	@Override
	public void save(String distCode, String distName, Date sdate, Date edate, String prdCode, String prdName,
			String qty, String tqty) {
		DistributorTarget distributorTarget=new DistributorTarget();
		distributorTarget.setDistCode(distCode);
		distributorTarget.setDistName(distName);
		distributorTarget.setSdate(sdate);
		distributorTarget.setEdate(edate);
		distributorTarget.setPrdCode(prdCode);
		distributorTarget.setPrdName(prdName);
		distributorTarget.setQty(qty);
		distributorTarget.setTqty(tqty);
		repository.save(distributorTarget);
		
	}
	}


