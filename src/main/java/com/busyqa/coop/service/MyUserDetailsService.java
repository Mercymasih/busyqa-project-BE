package com.busyqa.coop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.busyqa.coop.jpa.MyUserDetails;
import com.busyqa.coop.jpa.User;
import com.busyqa.coop.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=userRepository.findByUsername(username);
		return new MyUserDetails(user);
	}

}
