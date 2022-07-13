package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19s.mw.CRM.model.Team;

public interface TeamService {
	
	List<Team> getAllTeams();

	Team getTeam(Long id);

	Team insertTeam(String role);

	void deleteTeamById(Long id);

}
