package com.busyqa.coop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyqa.coop.jpa.Team;
//import com.busyqa.coop.jpa.User_Team;
import com.busyqa.coop.service.TeamService;

@RestController
@CrossOrigin("*")
public class TeamsController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
		@Autowired
		private TeamService teamService;
			
		//Creating New Team
		@PostMapping("/createteam")
		public void createTeam(@RequestBody Team team) throws Exception{
			
			logger.debug("Create Team!");
			this.teamService.saveTeam(team);
			System.out.println(team);
		}
		
		@GetMapping("/teams")
	    public List<Team> listTeam(){

	        logger.debug("List Team!");

	        List<Team> team = this.teamService.listTeam();

	        team.forEach(System.out::println);

	        return team;
	    }

}
