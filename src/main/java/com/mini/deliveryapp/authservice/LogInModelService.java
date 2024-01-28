package com.mini.deliveryapp.authservice;

import com.byteapp.authmodels.LogInModel;

public interface LogInModelService {
	
	public String LogIn(LogInModel login) ;
	
	public String LogOut(String key) ;

}
