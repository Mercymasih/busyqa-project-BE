package com.busyqa.coop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyqa.coop.jpa.JwtRequest;
import com.busyqa.coop.jpa.JwtResponse;
import com.busyqa.coop.jpa.User;
//import com.busyqa.coop.jpa.JwtResponse;
import com.busyqa.coop.security.JwtUtils;
import com.busyqa.coop.service.MyUserDetailsService;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;
	
	//Generate Token
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			
			authenticate(
					jwtRequest.getUsername(),
					jwtRequest.getPassword());
			
		}catch(UsernameNotFoundException e){
			
			e.printStackTrace();
			throw new Exception("User not found");
			
		}
		
		//User authenticated
		final UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		final String token=this.jwtUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	private void authenticate(String username, String password) throws Exception {
		
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch (DisabledException e){
			
			throw new Exception("User Disabled" +e.getMessage());
			
		}catch(BadCredentialsException e) {
			
			throw new Exception("Invalid Credentials"+e.getMessage());
		}
		
	}
	
	@GetMapping("current-user")
	public User getCurrentUser(Principal principal) {
		
		return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
		
	}
}
