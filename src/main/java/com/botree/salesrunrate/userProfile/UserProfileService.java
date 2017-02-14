package com.botree.salesrunrate.userProfile;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.botree.salesrunrate.entity.UserProfile;
import com.botree.salesrunrate.userProfile.UserProfileRepo;

@Component
public class UserProfileService implements IUserProfileService {

	@Autowired
	private UserProfileRepo repository;

	@Override
	public void save(String userName, String password, String email, String mobileNo) {
		UserProfile userProfile = new UserProfile();
		userProfile.setUserName(userName);
		userProfile.setPassword(password);
		userProfile.setEmailId(email);
		userProfile.setMobileNo(mobileNo);
		userProfile.setDistCode(null);
		userProfile.setModDt(new Date());
		repository.save(userProfile);
	}

	@Override
	public UserProfile findAll(String userName) {
		return repository.findOneByUserName(userName);

	}

	@Override
	public void delete(UserProfile userProfile) {
		repository.delete(userProfile);

	}

}
