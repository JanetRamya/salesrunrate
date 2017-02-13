package com.botree.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.UserProfile;
import com.botree.salesrunrate.userProfile.UserProfileRepo;

@Component
public class UserService implements IUserService {

	@Autowired
	private UserProfileRepo userProfile;

	@Override
	public UserProfile findUser(String userName, String password) {
		return userProfile.findOneByUserNameAndPassword(userName, password);
	}

	public UserProfile findUser(String userName) {
		
		return userProfile.findOneByUserName(userName);
	}

}
