package com.busyqa.coop.jpa;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




/*
 * POJO class User
 */
@Entity
@Table(name="USER")
public class User implements UserDetails,Serializable {
	
	

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USER", unique=true, nullable=false)
	private int id_user;
	
	
	@Column(name="FIRST_NAME", nullable=false, length=45)
	private String first_name;
	
	
	@Column(name="LAST_NAME", nullable=false, length=45)
	private String last_name;
	
	/* Username should be unique*/
	@Column(name="USERNAME", nullable=false, unique=true, length=45)
	private String username;
	
	
	@Column(name="PASSWORD", nullable=false, length=200)
	private String password;
	
	
	@Column(name="EMAIL", nullable=false, length=45)
	private String email;
	
	
	@Column(name="PHONE", nullable=false, length=45)
	private String phone;
	
	@Column(name="ROLE",nullable=false, length=45)
	private String role;
	

	
	public User() {
		
	}
	

	public User(int id_user, String first_name, String last_name, String username, String password, String email,
		String phone, String role) {
	super();
	this.id_user = id_user;
	this.first_name = first_name;
	this.last_name = last_name;
	this.username = username;
	this.password = password;
	this.email = email;
	this.phone = phone;
	this.role = role;
}



	public int getId_user() {
		return id_user;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

    @Override
    public String toString() {
        return "User [id_user=" + id_user + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
                + username + ", password=" + password + ", email="+ email +", phone="+ phone + ", role="+ role+"]";
    }

    //get User Authorities
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		String role=getRole();{
			authorities.add(new SimpleGrantedAuthority("Role" +role));
		}
		return authorities;
	}


	


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	
}
