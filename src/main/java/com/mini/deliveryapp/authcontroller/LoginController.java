package com.mini.deliveryapp.authcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteapp.authmodels.LogInModel;
import com.byteapp.authservice.LogInModelServiceImpl;

@RestController
public class LoginController {
	
	@Autowired
	private LogInModelServiceImpl loginService;
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody LogInModel loginData){
		return loginService.LogIn(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key)
	{
		return loginService.LogOut(key);
	}
	

}
