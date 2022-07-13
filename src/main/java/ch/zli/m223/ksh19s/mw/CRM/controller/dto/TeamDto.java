package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import ch.zli.m223.ksh19s.mw.CRM.model.Team;

public class TeamDto {
	public String teamName;

	public TeamDto(Team team) {
		teamName = team.getTeam();
	}
}
