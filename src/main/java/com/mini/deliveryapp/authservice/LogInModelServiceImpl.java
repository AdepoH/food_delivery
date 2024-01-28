package com.mini.deliveryapp.authservice;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteapp.authmodels.LogInModel;
import com.byteapp.authmodels.SignUpModel;
import com.byteapp.authmodels.UserSession;
import com.byteapp.authrepository.LogInModelDAO;
import com.byteapp.authrepository.SignUpModelDAO;
import com.byteapp.authrepository.UserSessionDAO;

@Service
public class LogInModelServiceImpl implements LogInModelService {
	

	@Autowired
	private SignUpModelDAO signUpDAO;
	
	@Autowired
	private UserSessionDAO userSessionDAO;
	
	@Autowired
	private UserSessionService userLogInSession;
	
	@Autowired
	private LogInModelDAO loginDataDAO;
	
	@Override
	public String LogIn(LogInModel loginData) {
		
		Optional<SignUpModel> opt = signUpDAO.findById(loginData.getUserId());
		
		if(!opt.isPresent())
		{
			System.out.println("Invalid Login UserId");
		}
		
		SignUpModel newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<UserSession> currentUserOptional = userSessionDAO.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			System.out.println("User Already LoggedIn with this UserId");
		}
		
		if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomString.getRandomString();
			
			UserSession currentUserSession = new UserSession(newSignUp.getUserId(),key,LocalDateTime.now());
			userSessionDAO.save(currentUserSession);
			loginDataDAO.save(loginData);
			
			return currentUserSession.toString();
			
		}
		else
			return ("Invalid UserName or Password..");
			
			
		
	}

	@Override
	public String LogOut(String key){
		
		Optional<UserSession> currentUserOptional = userSessionDAO.findByUUID(key);
		if(!currentUserOptional.isPresent())
		{
			System.out.println("Invalid credentials...");
		}
		UserSession currentUserSession = userLogInSession.getUserSession(key);
		
		userSessionDAO.delete(currentUserSession);
		
		Optional<LogInModel> loginData = loginDataDAO.findById(currentUserOptional.get().getUserId());
		System.out.println(loginData);
		loginDataDAO.delete(loginData.get());
		
		
		return "Logged Out...";
	
	}

}
