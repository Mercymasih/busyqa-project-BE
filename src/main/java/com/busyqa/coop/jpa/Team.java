package com.busyqa.coop.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TEAM")
public class Team implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TEAM", unique=true, nullable=false)
	private int id_team;
	
	@Column(name="TEAM_NAME", nullable=false ,length=45)
	private String teamname;
	
	//@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name="DATE_OF_CREATION", nullable=false, updatable=false)
	private Date date_of_creation= new Date();
	
	@Transient
    private int id_user;
	
	@Column(name="USERS", nullable=false)
	@OneToMany(mappedBy="team",cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JsonIgnore
	//@JsonManagedReference
    private List<Team_Users> team_users;
    
	
	
	public Team() {
		super();
	}

	public Team(int id_team,String teamname, Date date_of_creation,List<Team_Users> team_users) {
		super();
		this.id_team = id_team;
		this.teamname = teamname;
		this.date_of_creation = date_of_creation;
		this.team_users = team_users;
	}
	
	public int getId_team() {
		return id_team;
	}

	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String team_name) {
		this.teamname = team_name;
	}
	public Date getDate_of_creation() {
		return date_of_creation;
	}
	public void setDate_of_creation(Date date_of_creation) {
		this.date_of_creation = date_of_creation;
	}
	public List<Team_Users> getTeam_users() {
		return team_users;
	}
	public void setTeam_users(List<Team_Users> team_users) {
		this.team_users= team_users;
	}

	public Team_Users addTeamUsers(Team_Users teamUsers) {
        getTeam_users().add(teamUsers);
        teamUsers.setTeam(this);

        return teamUsers;
    }
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	@Override
	public String toString() {
		return "Team [id_team=" + id_team + ", teamname=" + teamname + ", date_of_creation=" + date_of_creation
				+ ", team_users=" + team_users + "]";
	}

}
