package com.botree.salesrunrate.salesmanDetails;

import com.botree.salesrunrate.entity.SalesmanDetails;

public interface ISalesmanDetailsService {
	
	public void save(final String smCode,final String smName,final String distBranch,final String compName,final String mobile,final String email,final String allow,final String monSalary);

	public SalesmanDetails findAll(String smCode);

}
