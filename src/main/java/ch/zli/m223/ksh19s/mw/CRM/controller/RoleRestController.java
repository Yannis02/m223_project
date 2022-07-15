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

import ch.zli.m223.ksh19s.mw.CRM.controller.dto.RoleDto;
import ch.zli.m223.ksh19s.mw.CRM.controller.dto.RoleInputDto;
import ch.zli.m223.ksh19s.mw.CRM.service.RoleService;

/**
 * Class to control the entity "role"
 * @author Yannis Lee
 *
 */
@RestController
@RequestMapping("/api/v1")
public class RoleRestController {

	@Autowired
	private RoleService roleService;

	/**
	 * Gets all roles
	 * @return List<RoleDto>
	 */
	@GetMapping("/roles")
	List<RoleDto> getAllRoles() {
		return roleService.getAllRoles().stream().map(role -> new RoleDto(role)).collect(Collectors.toList());
	}

	/**
	 * Gets a role
	 * @param id
	 * @return RoleDto
	 */
	@GetMapping("/roles/{id}")
	RoleDto getRole(@PathVariable("id") Long id) {
		return new RoleDto(roleService.getRole(id));
	}

	/**
	 * Inserts a role
	 * @param roleData
	 * @return RoleDto
	 */
	@PostMapping("/roles")
	RoleDto insertRole(@RequestBody RoleInputDto roleData) {
		return new RoleDto(roleService.insertRole(roleData.name));
	}

	/**
	 * Deletes a role
	 * @param id
	 */
	@DeleteMapping("/roles/{id}")
	void deleteRole(@PathVariable("id") Long id) {
		roleService.deleteRoleById(id);
	}

}
