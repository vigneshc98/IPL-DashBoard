package com.vtech.ipldashboard.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vtech.ipldashboard.entity.MatchOutput;

public interface MatchOutputRepository extends CrudRepository<MatchOutput, Long> {

	Optional<List<MatchOutput>> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable page);
	
	@Query("select m from MatchOutput m where (m.team1 = :teamName or m.team2 = :teamName) and m.date between :dateStart and :dateEnd order by m.date desc")
	Optional<List<MatchOutput>> getMatchesByDate(@Param("teamName") String teamName, @Param("dateStart") LocalDate date1, @Param("dateEnd") LocalDate date2);
	
//	Optional<List<MatchOutput>> getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
//			String teamName1, LocalDate date1, LocalDate date2,
//			String teamName2, LocalDate date3, LocalDate date4
//			);
	
	default List<MatchOutput> findLatestMatchesByTeam(String teamName, int count){
		return getByTeam1OrTeam2OrderByDateDesc( teamName,  teamName, PageRequest.of(0, count)).orElseThrow(()-> new RuntimeException("Error loading matches"));
	}
}
