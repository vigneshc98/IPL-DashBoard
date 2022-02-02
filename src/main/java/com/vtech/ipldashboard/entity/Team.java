package com.vtech.ipldashboard.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String teamName;
    private long totalMatches;
    private long totalWins;
    
    @Transient
    private List<MatchOutput> matches;
    
    public Team(String teamName, long totalMatches) {
    	this.teamName = teamName;
    	this.totalMatches= totalMatches;
    }

}
