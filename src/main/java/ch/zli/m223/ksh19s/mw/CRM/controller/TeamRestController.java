package ch.zli.m223.ksh19s.mw.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19s.mw.CRM.controller.dto.TeamDto;
import ch.zli.m223.ksh19s.mw.CRM.controller.dto.TeamInputDto;
import ch.zli.m223.ksh19s.mw.CRM.service.TeamService;

@RestController
@RequestMapping("/api/v1")
public class TeamRestController {

	@Autowired
	private TeamService teamService;

	@GetMapping("/teams")
	List<TeamDto> getAllTeams() {
		return teamService.getAllTeams().stream().map(team -> new TeamDto(team)).collect(Collectors.toList());
	}

	@GetMapping("/teams/{id}")
	TeamDto getTeam(@PathVariable("id") Long id) {
		return new TeamDto(teamService.getTeam(id));
	}

	@PostMapping("/teams")
	TeamDto insertTeam(@RequestBody TeamInputDto teamData) {
		return new TeamDto(teamService.insertTeam(teamData.name));
	}

	@DeleteMapping("/teams/{id}")
	void deleteTeam(@PathVariable("id") Long id) {
		teamService.deleteTeamById(id);
	}

}
