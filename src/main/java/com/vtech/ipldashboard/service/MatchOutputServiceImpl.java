package com.vtech.ipldashboard.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.ipldashboard.entity.MatchOutput;
import com.vtech.ipldashboard.repository.MatchOutputRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MatchOutputServiceImpl implements MatchOutputService {
	
	@Autowired
	MatchOutputRepository matchOutputRepo;

	@Override
	public List<MatchOutput> getByTeam1OrTeam2(String teamName) {
		return matchOutputRepo.findLatestMatchesByTeam(teamName, 4);
	}

	@Override
	public List<MatchOutput> getByDate(String teamName, LocalDate date1,LocalDate date2) {
		return matchOutputRepo.getMatchesByDate(teamName, date1, date2).orElseThrow(()-> new RuntimeException("date not found"));
	}

}
