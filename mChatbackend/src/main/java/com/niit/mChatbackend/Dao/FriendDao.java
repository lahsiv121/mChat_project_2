package com.niit.mChatbackend.Dao;

import java.util.List;

import com.niit.mChatbackend.model.Friend;
import com.niit.mChatbackend.model.User;

public interface FriendDao 

{

	List<User> getListOfSuggestedUsers(String username);

	void addFriendRequest(String username, String toId);

	List<Friend> getPendingRequests(String username);

	void updatePendingRequest(Friend pendingRequest);

	List<Friend> listOfFriends(String username);

}
