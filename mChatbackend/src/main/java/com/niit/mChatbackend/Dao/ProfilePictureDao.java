package com.niit.mChatbackend.Dao;

import com.niit.mChatbackend.model.ProfilePicture;

public interface ProfilePictureDao 
{
	
	void save(ProfilePicture profilePicture);
	ProfilePicture getProfilePic(String username);
}
