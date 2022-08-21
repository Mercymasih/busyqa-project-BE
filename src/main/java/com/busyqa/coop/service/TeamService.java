package com.busyqa.coop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.busyqa.coop.jpa.Team;
import com.busyqa.coop.jpa.Team_Users;
import com.busyqa.coop.jpa.User;
import com.busyqa.coop.repository.TeamRepository;
import com.busyqa.coop.repository.UserRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@Transactional(propagation=Propagation.REQUIRED)
    public void saveTeam(Team team) throws Exception{
       
		/*if(!(user.getRole().equalsIgnoreCase("Admin"))){
			
			throw new Exception("User "+ user +" doesn't have permission to create Team");
		}*/
        //this.validateTeam(team);
        /*
         * Create the Team
         */
        List<User> users= new ArrayList<>();
        
	        users.forEach((userObj) -> {
	        	
	        	User userobj = userService.findUser(team.getId_user());
	        	System.out.println("Selected user is" +userobj);
            /* Create new TeamUsers */
	        	Team_Users teamusers = this.createTeamUsers(team, userobj);
	        	System.out.println("Team users are" +userobj);
	        
            team.setTeam_users(new ArrayList<>());
            team.addTeamUsers(teamusers); /* Add new User to the Team*/
            
            this.teamRepo.save(team);
	        });
        
    }
	
	
	private Team_Users createTeamUsers(Team team,User user) {

		Team_Users team_users = new Team_Users();

		team_users.setTeam(team);
		team_users.setUser(user);

        return team_users;
    }
//	private void validateTeam(Team team) throws Exception {
//		
//		//String tempteamname= team.getTeamname();
//		
//		Team teamObj = teamRepo.findByTeamname(team.getTeamname());
//		
////			if(teamObj !=null) {
////				throw new Exception("Team "+ teamObj +" "+"already exists");
////			}
//	}
		
	public List<Team> listTeam() {

        List<Team> team = this.teamRepo.findAll();
       
        return team;
    }

}
