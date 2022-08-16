package com.busyqa.coop.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TEAM_USERS")
public class Team_Users implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TEAM_USER", unique=true, nullable=false)
	private int id_team_user;
	
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JsonIgnore
    @JoinColumn(name="ID_TEAM", nullable=false)
	private Team team;
	
	@ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="ID_USER", nullable=false)
	private User user= new User();

	public Team_Users() {
		super();
	}

	public Team_Users(int id_team_user, Team team, User user) {
		super();
		this.id_team_user = id_team_user;
		this.team = team;
		this.user = user;
	}

	public int getId_team_user() {
		return id_team_user;
	}

	public void setId_team_user(int id_team_user) {
		this.id_team_user = id_team_user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
	
}
