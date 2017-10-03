package com.niit.mChatbackend.Dao;

import com.niit.mChatbackend.model.User;

/*import com.niit.model.User;
*/

public interface UserDao {

	void registerUser(User user);

User validateUsername(String username);

User validateEmail(String email);

User login(User user);

void update(User user);

User getUserByUsername(String username);
}