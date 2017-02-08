package com.botree.salesrunrate.distributorDetails;

import com.botree.salesrunrate.entity.DistributorDetails;

public interface IDistributorDetailsService {
	public void save(final String distCode, final String distName, final String mobile, final String email,
			final String country, final String state, final String city);

	public DistributorDetails findAll(String distCode);
}
