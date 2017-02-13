package com.botree.salesrunrate.distributorDetails;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.DistributorDetails;
import com.botree.salesrunrate.entity.UserProfile;
import com.botree.salesrunrate.userProfile.UserProfileRepo;

@Component
public class DistributorDetailsService implements IDistributorDetailsService {

	@Autowired
	private DistributorDetailsRepo repository;
	
	@Autowired
	private UserProfileRepo userRepo;


	@Override
	public void save(String distCode, String distName, String mobile, String email, String country, String state,
			String city) {
		DistributorDetails distributorDetails=new DistributorDetails();
		UserProfile userProfile = new UserProfile();
		distributorDetails.setDistCode(distCode);
		distributorDetails.setDistName(distName);
		distributorDetails.setMobile(mobile);
		distributorDetails.setEmail(email);
		distributorDetails.setCountry(country);
		distributorDetails.setState(state);
		distributorDetails.setCity(city);
		repository.save(distributorDetails);
		userProfile.setUserName(distCode);
		userProfile.setDistCode(distCode);
		userProfile.setMobileNo(mobile);
		userProfile.setEmailId(email);
		userProfile.setPassword("Admin@123");
		userProfile.setModDt(new Date());
		userRepo.save(userProfile);
	}

	
	@Override
	public DistributorDetails findAll(String distCode) {
		return repository.findOneByDistCode(distCode);
	}}