package com.botree.salesrunrate.salesmanTarget;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.SalesmanTarget;

@Component
public class SalesmanTargetService implements ISalesmanTargetService{
@Autowired
private SalesmanTargetRepo repository;
	
	@Override
	public void save(String smCode, String smName, Date sdate, Date edate, String prdCode, String prdName, String qty,
			String tqty) {
		SalesmanTarget salesmanTarget=new SalesmanTarget();
		salesmanTarget.setSmCode(smCode);
		salesmanTarget.setSmName(smName);
		salesmanTarget.setSdate(sdate);
		salesmanTarget.setEdate(edate);
		salesmanTarget.setPrdCode(prdCode);
		salesmanTarget.setPrdName(prdName);
		salesmanTarget.setQty(qty);
		salesmanTarget.setTqty(tqty);
		repository.save(salesmanTarget);
	}

	@Override
	public List<SalesmanTarget> findAll() {
		return repository.findAll();
	}

	@Override
	public SalesmanTarget findAll(String smName) {
		return repository.findOneBySalesman(smName);
	}

}
