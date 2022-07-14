package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19s.mw.CRM.model.Role;

/**
 * Interface for the RoleService
 * @author Yannis Lee
 *
 */
public interface RoleService {

	List<Role> getAllRoles();

	Role getRole(Long id);

	Role insertRole(String role);

	void deleteRoleById(Long id);
}
