package com.botree.salesrunrate.salesmanDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.SalesmanDetails;

@Component
public class SalesmanDetailsService implements ISalesmanDetailsService{

	@Autowired
	private SalesmanDetailsRepo repository;

	@Override
	public void save(String smCode, String smName, String distBranch, String compName, String mobile, String email,
			String allow, String monSalary) {
		SalesmanDetails salesmanDetails=new SalesmanDetails();
		salesmanDetails.setSmCode(smCode);
		salesmanDetails.setSmName(smName);
		salesmanDetails.setDistBranch(distBranch);
		salesmanDetails.setCompName(compName);
		salesmanDetails.setMobile(mobile);
		salesmanDetails.setEmail(email);
		salesmanDetails.setAllow(allow);
		salesmanDetails.setMonSalary(monSalary);
		repository.save(salesmanDetails);
		
	}

	@Override
	public SalesmanDetails findAll(String smCode) {
		return repository.findOneBySmCode(smCode);
	}

}
