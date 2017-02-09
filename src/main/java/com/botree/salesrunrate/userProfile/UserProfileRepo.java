package com.botree.salesrunrate.userProfile;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.UserProfile;

public interface UserProfileRepo extends MongoRepository<UserProfile, String> {
	
	UserProfile findOneByUserName(String userName);
	
	UserProfile findOneByUserNameAndPassword(String userName,String password);

}
