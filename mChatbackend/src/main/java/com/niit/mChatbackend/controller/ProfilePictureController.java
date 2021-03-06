package com.niit.mChatbackend.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.mChatbackend.Dao.ProfilePictureDao;
import com.niit.mChatbackend.model.ProfilePicture;
import com.niit.mChatbackend.model.Error;



@Controller
public class ProfilePictureController {
	@Autowired
private ProfilePictureDao profilePictureDao;

@RequestMapping(value="/uploadprofilepic",method=RequestMethod.POST)
public ResponseEntity<?> uploadProfilePicture(@RequestParam CommonsMultipartFile image,HttpSession session){

	if(session.getAttribute("username")==null)
	{
		Error error= new Error(5,"UnAuthorized User");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401
	}
	String username=(String)session.getAttribute("username");
	ProfilePicture profilePicture=new ProfilePicture();
	profilePicture.setUsername(username);
	profilePicture.setImage(image.getBytes());
	
	try
	{
		profilePictureDao.save(profilePicture);
		System.out.println("try");
		return new ResponseEntity<ProfilePicture>(profilePicture,HttpStatus.OK);
	}
	catch(Exception e)
	{System.out.println("catch");
	
		Error error=new Error(6,"Unable to upload profile picture");
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	@RequestMapping(value="/getimage/{username}",method=RequestMethod.GET)
	public @ResponseBody byte[] getImage(@PathVariable String username,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return null;
		}
		
		else
		{
			ProfilePicture profilePicture=profilePictureDao.getProfilePic(username);
			if(profilePicture==null)
				return null;
			return profilePicture.getImage();
		}
	}
	
	
	
}