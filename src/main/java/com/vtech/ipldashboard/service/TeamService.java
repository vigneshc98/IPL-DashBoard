package com.vtech.ipldashboard.service;

import java.util.List;

import com.vtech.ipldashboard.entity.Team;

public interface TeamService {
	
	Iterable<Team> getAllTeam();

	Team findByTeamName(String teamName);
}
