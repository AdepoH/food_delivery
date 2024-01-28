package com.mini.deliveryapp.authservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteapp.authmodels.SignUpModel;
import com.byteapp.authmodels.UserSession;
import com.byteapp.authrepository.SignUpModelDAO;
import com.byteapp.authrepository.UserSessionDAO;

@Service
public class UserSessionServiceImpl implements UserSessionService {

	@Autowired
	private UserSessionDAO userSessionDAO;
	
	@Autowired
	private SignUpModelDAO signUpDAO;
	
	
	
	@Override
	public UserSession getUserSession(String key){
		
		Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
		if(!currentUser.isPresent())
		{
			System.out.println("Not Authorized..!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getUserSessionId(String key){
		
		Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
		if(!currentUser.isPresent())
		{
			System.out.println("Not Authorized..!!");
		}
		return currentUser.get().getId();
		
	}


	@Override
	public SignUpModel getSignUpDetails(String key) {
		
		Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signUpDAO.findById(SignUpUserId)).get();
	}

}
