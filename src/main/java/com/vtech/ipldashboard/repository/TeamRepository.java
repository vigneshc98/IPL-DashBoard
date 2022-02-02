package com.vtech.ipldashboard.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vtech.ipldashboard.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

	Optional<Team> findByTeamName(String teamName);
}
