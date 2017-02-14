package com.botree.salesrunrate.userProfile;

import com.botree.salesrunrate.entity.UserProfile;

public interface IUserProfileService {

	public void save(final String userName, final String password, final String email, final String mobileNo);

	UserProfile findAll(String userName);

	public void delete(UserProfile userProfile);

}
