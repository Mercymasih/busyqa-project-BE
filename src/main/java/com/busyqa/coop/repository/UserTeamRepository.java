package com.busyqa.coop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busyqa.coop.jpa.Team_Users;

public interface UserTeamRepository extends JpaRepository<Team_Users, Integer>{

}
