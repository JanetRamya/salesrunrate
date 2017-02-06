package com.botree.salesrunrate.presistance;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.UserProfile;

public interface UserProfileRepo extends MongoRepository<UserProfile, String> {
	
	UserProfile findOneByUserName(String userName);

}
