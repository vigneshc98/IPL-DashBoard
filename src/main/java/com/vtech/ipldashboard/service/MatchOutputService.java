package com.vtech.ipldashboard.service;

import java.time.LocalDate;
import java.util.List;

import com.vtech.ipldashboard.entity.MatchOutput;

public interface MatchOutputService {

	List<MatchOutput> getByTeam1OrTeam2(String teamName);
	
	List<MatchOutput> getByDate(String teamName, LocalDate date1, LocalDate date2);
	

}
