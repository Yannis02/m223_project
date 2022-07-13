package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import ch.zli.m223.ksh19s.mw.CRM.model.Role;

public class RoleDto {
	public String roleName;

	public RoleDto(Role role) {
		roleName = role.getRole();
	}
}
