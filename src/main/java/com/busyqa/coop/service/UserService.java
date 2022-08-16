package com.busyqa.coop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.busyqa.coop.jpa.User;
import com.busyqa.coop.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User user) {
    	user.setPassword(getEncodedPassword(user.getPassword()));
		return userRepo.save(user);
		
	}
    
    public User fetchUserByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}
	
	
	public User fetchUserByUsernameandPsswd(String username, String password) {
		
		return userRepo.findByUsernameAndPassword(username,password);
	}
	
	public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
	
	public List<User> listUsers() {

        List<User> users = this.userRepo.findAll();
       
        return users;
    }
	
	public User findUser(int idUser){
        return this.userRepo.findById(idUser).get();
    }
	
		
}


