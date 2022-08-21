package com.busyqa.coop.controller;


import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	//Get all users
	@GetMapping("/users")
    public List<User> listUsers(){

        logger.debug("List Users!");

        List<User> users = this.service.listUsers();

        users.forEach(System.out::println);

        return users;
    }
	//Get a Single user
    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") int id){

        logger.debug("Get User: {} !", id);

        User usr= this.service.findUser(id);
        System.out.println("Selected user is" +usr);
        return usr;
    }


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
