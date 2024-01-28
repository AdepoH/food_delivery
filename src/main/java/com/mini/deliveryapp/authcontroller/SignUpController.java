package com.mini.deliveryapp.authcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteapp.authmodels.SignUpModel;
import com.byteapp.authservice.SignUpModelService;

@RestController
public class SignUpController {
	
	@Autowired
	private SignUpModelService signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUpModel> createNewSignUpHandler(@RequestBody SignUpModel newSignUp){
		
		SignUpModel newSignedUp =signUpService.newSignUp(newSignUp);
		return new ResponseEntity<SignUpModel>(newSignedUp,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUpModel> updateSignUpDetailsHandler(@RequestBody SignUpModel signUp, @RequestParam String key)
	{
		SignUpModel newUpdatedSignUp = (SignUpModel) signUpService.updateSignUp(signUp,key);
		
		return new ResponseEntity<SignUpModel>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}

}
