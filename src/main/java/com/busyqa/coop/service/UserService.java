package com.busyqa.coop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.busyqa.coop.jpa.User;
import com.busyqa.coop.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User user) {
    	user.setPassword(getEncodedPassword(user.getPassword()));
		return repo.save(user);
		
	}
    
    public User fetchUserByUsername(String username) {
		
		return repo.findByUsername(username);
	}
	
	
	public User fetchUserByUsernameandPsswd(String username, String password) {
		
		return repo.findByUsernameAndPassword(username,password);
	}
	
	public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}


