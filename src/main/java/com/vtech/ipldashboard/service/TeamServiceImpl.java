package com.vtech.ipldashboard.service;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.ipldashboard.entity.Team;
import com.vtech.ipldashboard.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamRepository teamRepo;

	@Override
	public Team findByTeamName(String teamName) throws RuntimeException {
		return teamRepo.findByTeamName(teamName).orElseThrow(()-> new RuntimeException("Team name not found"));
	}

	@Override
	public Iterable<Team> getAllTeam() {
		return teamRepo.findAll();
	}

}
