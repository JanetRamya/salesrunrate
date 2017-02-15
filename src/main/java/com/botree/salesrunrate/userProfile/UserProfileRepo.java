package com.botree.salesrunrate.userProfile;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.botree.salesrunrate.entity.UserProfile;

public interface UserProfileRepo extends MongoRepository<UserProfile, String> {

	public UserProfile findOneByUserName(String userName);

	public UserProfile findOneByUserNameAndPassword(String userName, String password);

}
