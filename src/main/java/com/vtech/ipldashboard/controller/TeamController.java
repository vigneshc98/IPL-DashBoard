package com.vtech.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vtech.ipldashboard.entity.MatchOutput;
import com.vtech.ipldashboard.entity.Team;
import com.vtech.ipldashboard.service.MatchOutputService;
import com.vtech.ipldashboard.service.TeamService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	MatchOutputService matchOutputService;
	
	@GetMapping("/teams")
	public Iterable<Team> getAllTeam(){
		return teamService.getAllTeam();
	}
	
	@GetMapping("/teams/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = teamService.findByTeamName(teamName);
		team.setMatches(matchOutputService.getByTeam1OrTeam2(teamName));
		return team;
	}
	
	@GetMapping("/teams/{teamName}/matches")
	public List<MatchOutput> getMatchesByDate(@PathVariable String teamName, @RequestParam int year) {
		
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate endDate = LocalDate.of(year+1, 1, 1);
		
//		Team team = teamService.findByTeamName(teamName);
//		team.setMatches(matchOutputService.getByDate(teamName, startDate, endDate));
		return matchOutputService.getByDate(teamName, startDate, endDate);
	}

}
