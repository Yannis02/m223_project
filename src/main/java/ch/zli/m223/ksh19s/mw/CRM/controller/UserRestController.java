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

import ch.zli.m223.ksh19s.mw.CRM.controller.dto.InjuryDto;
import ch.zli.m223.ksh19s.mw.CRM.controller.dto.RoleDto;
import ch.zli.m223.ksh19s.mw.CRM.controller.dto.TeamDto;
import ch.zli.m223.ksh19s.mw.CRM.controller.dto.UserDto;
import ch.zli.m223.ksh19s.mw.CRM.controller.dto.UserInputDto;
import ch.zli.m223.ksh19s.mw.CRM.service.UserService;

/**
 * Class to control the entity "user"
 * @author Yannis Lee
 *
 */
@RestController
@RequestMapping("/api/v1")
public class UserRestController {

	@Autowired
	private UserService userService;

	/**
	 * Gets all the users
	 * @return List<UserDto>
	 */
	@GetMapping("/users")
	List<UserDto> getAllUsers() {
		return userService.getAllUsers().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
	}

	/**
	 * Gets a user
	 * @param id
	 * @return UserDto
	 */
	@GetMapping("/users/{id}")
	UserDto getUser(@PathVariable("id") Long id) {
		return new UserDto(userService.getUser(id));
	}
	
	/**
	 * Inserts a user
	 * @param userData
	 * @return UserDto
	 */
	@PostMapping("/users")
	UserDto insertUser(@RequestBody UserInputDto userData) {
		return new UserDto(userService.insertUser(userData.name, userData.password));
	}

	/**
	 * Deletes a user
	 * @param id
	 */
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}

	/**
	 * Gets roles for a user
	 * @param id
	 * @return List<RoleDto>
	 */
	@GetMapping("/users/{id}/roles")
	List<RoleDto> getRolesForUser(@PathVariable("id") Long id) {
		var user = userService.getUser(id);
		return user.getRoles().stream().map(r -> new RoleDto(r)).collect(Collectors.toList());
	}
	
	/**
	 * Gets teams for a user
	 * @param id
	 * @return List<TeamDto>
	 */
	@GetMapping("/users/{id}/teams")
	List<TeamDto> getTeamsForUser(@PathVariable("id") Long id) {
		var user = userService.getUser(id);
		return user.getTeams().stream().map(t -> new TeamDto(t)).collect(Collectors.toList());
	}
	
	/**
	 * Gets injuries for a user
	 * @param id
	 * @return List<InjuryDto>
	 */
	@GetMapping("/users/{id}/injuries")
	List<InjuryDto> getInjuriesForUser(@PathVariable("id") Long id) {
		var user = userService.getUser(id);
		return user.getInjuries().stream().map(i -> new InjuryDto(i)).collect(Collectors.toList());
	}
}
