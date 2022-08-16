package com.busyqa.coop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busyqa.coop.jpa.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

	public Team findByTeamname(String teamname);
	
	//@SuppressWarnings("unchecked")
	//public Team save(Team team);
	
}
