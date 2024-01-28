package com.mini.deliveryapp.authservice;

import com.byteapp.authmodels.SignUpModel;
import com.byteapp.authmodels.UserSession;

public interface UserSessionService {
	
	public UserSession getUserSession(String key);
	
	public Integer getUserSessionId(String key);
	
	public SignUpModel getSignUpDetails(String key);
	

}
