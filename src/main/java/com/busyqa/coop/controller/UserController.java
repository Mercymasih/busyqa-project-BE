package com.busyqa.coop.controller;


import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyqa.coop.jpa.User;
import com.busyqa.coop.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService service;

	//Creating New User
	@PostMapping("/signup")
	public User createUser(@RequestBody User user) throws Exception{
		String tempusername= user.getUsername();
		
		if(tempusername != null && !"".equals(tempusername)) {
			User userObj = service.fetchUserByUsername(tempusername);
			if(userObj !=null) {
				throw new Exception("User with "+ tempusername +" "+"already exists");
			}
		}
		logger.debug("Create User!");
		User userobj = null;
		userobj= service.saveUser(user);
		return userobj;
	}
	
	//Logging in with username and password
	
	@PostMapping("/login")
	public Principal user (Principal user) {
		System.out.println("User is" +user);
		if(user != null){
			return user;
		}
		else {
			throw new BadCredentialsException("Invalid Credentials!!");
		}
		
	}


}
