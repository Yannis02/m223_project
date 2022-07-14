package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import ch.zli.m223.ksh19s.mw.CRM.model.Team;

/**
 * Data transfer object for "team"
 * @author Yannis Lee
 *
 */
public class TeamDto {
	
	public String teamName;

	/**
	 * Constructor for TeamDto
	 * @param team
	 */
	public TeamDto(Team team) {
		teamName = team.getTeam();
	}
}
