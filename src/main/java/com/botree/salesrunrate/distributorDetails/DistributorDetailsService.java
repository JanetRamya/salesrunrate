package com.botree.salesrunrate.distributorDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.DistributorDetails;

@Component
public class DistributorDetailsService implements IDistributorDetailsService {

	@Autowired
	private DistributorDetailsRepo repository;

	@Override
	public void save(String distCode, String distName, String mobile, String email, String country, String state,
			String city) {
		DistributorDetails distributorDetails=new DistributorDetails();
		distributorDetails.setDistCode(distCode);
		distributorDetails.setDistName(distName);
		distributorDetails.setMobile(mobile);
		distributorDetails.setEmail(email);
		distributorDetails.setCountry(country);
		distributorDetails.setState(state);
		distributorDetails.setCity(city);
		repository.save(distributorDetails);
	}

	
	@Override
	public DistributorDetails findAll(String distCode) {
		return repository.findOneByDistCode(distCode);
	}}