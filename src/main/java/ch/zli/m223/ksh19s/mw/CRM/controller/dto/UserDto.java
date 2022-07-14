package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;

/**
 * Data transfer object for "user"
 * @author Yannis Lee
 *
 */
public class UserDto {
	
	public Long id;
	public String name;
	public List<String> roleList;
	public List<String> teamList;
	public List<String> injuryList;
	
	/**
	 * Constructor for UserDto
	 * @param user
	 */
	public UserDto(AppUser user) {
		id = user.getId();
		name = user.getName();
		roleList = new ArrayList<>();
		teamList = new ArrayList<>();
		injuryList = new ArrayList<>();
		

		for (var role : user.getRoles()) {
			roleList.add(role.getRole());
		}
		
		for (var team : user.getTeams()) {
			teamList.add(team.getTeam());
		}
		
		for (var injury : user.getInjuries()) {
			injuryList.add(injury.getInjury());
		}



	}
}
