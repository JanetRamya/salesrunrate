package com.botree.salesrunrate.distributorTarget;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.botree.salesrunrate.entity.DistributorTarget;

public class DistributorTargetService implements IDistributorTargetService{
	
	@Autowired
	private DistributorTargetRepo repository; 

	@Override
	public List<DistributorTarget> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(String distCode, String distName, String sdate, String edate, String prdCode, String prdName,
			String stock, String tqty) {
		DistributorTarget distributorTarget=new DistributorTarget();
		distributorTarget.setDistCode(distCode);
		distributorTarget.setDistName(distName);
		distributorTarget.setSdate(sdate);
		distributorTarget.setEdate(edate);
		distributorTarget.setPrdCode(prdCode);
		distributorTarget.setPrdName(prdName);
		distributorTarget.setStock(stock);
		distributorTarget.settQty(tqty);
		repository.save(distributorTarget);
	
	}

	@Override
	public DistributorTarget findAll(String distName) {
		// TODO Auto-generated method stub
		return repository.findOneByDistName(distName);
	}
	}


