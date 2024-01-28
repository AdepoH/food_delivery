package com.mini.deliveryapp.authservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteapp.authmodels.SignUpModel;
import com.byteapp.authrepository.SignUpModelDAO;


@Service
public class SignUpModelServiceImpl implements SignUpModelService {


	@Autowired
	private SignUpModelDAO signUpDAO;
	
	@Autowired
	private UserSessionService userLoginSession;
	
	
	
	
	@Override
	public SignUpModel newSignUp(SignUpModel signUp) {
		
		Optional<SignUpModel> opt = signUpDAO.findByUserName(signUp.getUserName());
		if(opt.isPresent())
		{
			System.out.println("User Already Exists..!!");
		}
		
		return signUpDAO.save(signUp);
	}

	
	@Override
	public SignUpModel updateSignUp(SignUpModel signUp, String key){
		
		SignUpModel signUpDetails = userLoginSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			System.out.println("User not LoggedIn...!! Try To Login first..");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpDAO.save(signUp);
			return signUp;
			}
		else
			System.out.println("UserId not found..!!");
		return signUpDetails;
	}

}
