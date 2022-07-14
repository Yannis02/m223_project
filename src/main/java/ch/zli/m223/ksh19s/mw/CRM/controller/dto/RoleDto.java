package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import ch.zli.m223.ksh19s.mw.CRM.model.Role;

/**
 * Data transfer object for "role"
 * @author Yannis Lee
 *
 */
public class RoleDto {
	
	public String roleName;

	/**
	 * Constructor for RoleDto
	 * @param role
	 */
	public RoleDto(Role role) {
		roleName = role.getRole();
	}
}
