package com.busyqa.coop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busyqa.coop.jpa.Team;
import com.busyqa.coop.jpa.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username, String password);
	//public void save(User[] user);
	
}
