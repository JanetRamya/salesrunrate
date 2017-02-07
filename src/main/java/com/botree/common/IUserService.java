package com.botree.common;



import com.botree.salesrunrate.entity.UserProfile;

public interface IUserService {
	UserProfile findUser(String userName,String password);

}
