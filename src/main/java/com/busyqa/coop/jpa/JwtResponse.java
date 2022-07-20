package com.busyqa.coop.jpa;

public class JwtResponse {
	
	//private User user;
	private String token;
	
	public JwtResponse() {
		super();
	}

	public JwtResponse( String token) {
		super();
		//this.user = user;
		this.token = token;
	}

	

//	public User getUser() {
//		return user;
//	}



//	public void setUser(User user) {
//		this.user = user;
//	}


	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
