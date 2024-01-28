package com.mini.deliveryapp.authservice;

import com.byteapp.authmodels.SignUpModel;

public interface SignUpModelService {
	
	public SignUpModel newSignUp(SignUpModel signUp);;
	
	public Object updateSignUp(SignUpModel signUp, String key);;

}
