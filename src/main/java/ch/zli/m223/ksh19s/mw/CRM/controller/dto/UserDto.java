package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;

public class UserDto {
	public Long id;
	public String email;
	public List<String> roleList;
	public List<String> teamList;
	
	public UserDto(AppUser user) {
		id = user.getId();
		email = user.getEmail();
		roleList = new ArrayList<>();
		teamList = new ArrayList<>();
		

		for (var role : user.getRoles()) {
			roleList.add(role.getRole());
		}
		
		for (var team : user.getTeams()) {
			teamList.add(team.getTeam());
		}



	}
}
