package ch.zli.m223.ksh19s.mw.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.zli.m223.ksh19s.mw.CRM.model.Team;
import ch.zli.m223.ksh19s.mw.CRM.service.TeamService;

/**
 * Class to control the entity "team" via the web
 * @author Yannis Lee
 *
 */
@Controller
@RequestMapping("/web")
public class TeamWebController {
	@Autowired
	private TeamService teamService;

	/**
	 * Gets a list of all the teams
	 * @param model
	 * @return "teamList"
	 */
	@GetMapping("/teams")
	String getTeamList(Model model) {
		List<Team> teamList = teamService.getAllTeams();
		model.addAttribute("teams", teamList);
		return "teamList";
	}
	
}
