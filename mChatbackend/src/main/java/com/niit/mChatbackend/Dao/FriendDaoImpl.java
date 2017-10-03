package com.niit.mChatbackend.Dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mChatbackend.model.Friend;
import com.niit.mChatbackend.model.User;

@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	public List<User> getListOfSuggestedUsers(String username) {
		Session session=sessionFactory.getCurrentSession();
		String queryString="select * from user1 where username in (select username from user1 where username!=? and username not in (select fromId from friend where toId=? and status!='D' union select toId from friend where fromId=? and status!='D'))";
		SQLQuery query=session.createSQLQuery(queryString);
		query.setString(0, username);
		query.setString(1, username);
		query.setString(2, username);
		query.addEntity(User.class);
		List<User> suggestedUsers=query.list();
		return suggestedUsers;
	}

	public void addFriendRequest(String username,String toId){
		Session session=sessionFactory.getCurrentSession();
		Friend friend= new Friend();
		// friend request is from "username to "toId"
		friend.setFromId(username);
		friend.setToId(toId);
		friend.setStatus('p');
		session.save(friend);
	}
	
	
	public List<Friend> getPendingRequests(String username){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status='p'");
		query.setString(0,username);
		return query.list();
	}
	
	public void updatePendingRequest(Friend pendingRequest){
		Session session=sessionFactory.getCurrentSession();
		if(pendingRequest.getStatus()=='D')
			session.delete(pendingRequest); //delete from friend where id=?
		else
		session.update(pendingRequest);//status 'A' update friend set status='A' where id=?
	}
	
	public List<Friend> listOfFriends(String username){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where (fromId=? or toId=?) and status=?");
		query.setString(0, username);
		query.setString(1, username);
		query.setCharacter(2, 'A');
		return query.list();
		
	}

	
}
