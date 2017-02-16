package com.botree.salesrunrate.distributorDetails;

import java.util.List;

import com.botree.salesrunrate.entity.DistributorDetails;

public interface IDistributorDetailsService {
	public void save(final String distCode, final String distName, final String mobile, final String email,
			final String country, final String state, final String city);

	public List<DistributorDetails> findAll();


	public DistributorDetails findAll(String distCode);

	public void delete(DistributorDetails distributorDetails);
}
