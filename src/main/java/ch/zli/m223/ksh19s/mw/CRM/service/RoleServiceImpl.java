package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19s.mw.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19s.mw.CRM.exception.EntityAlreadyExistsException;
import ch.zli.m223.ksh19s.mw.CRM.exception.EntityNotFoundException;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.model.Role;
import ch.zli.m223.ksh19s.mw.CRM.repository.RoleRepository;

/**
 * Implementation of the RoleService
 * @author Yannis Lee
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	private AppUser user;

	/**
	 * Gets all the roles
	 * @return List<Role>
	 */
	@Override
	public List<Role> getAllRoles() {
		return new ArrayList<>(roleRepository.findAll());
	}

	/**
	 * Gets a role
	 * @param id
	 * @return Role
	 */
	@Override
	public Role getRole(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Invalid user Id " + id);
		});
	}

	/**
	 * Inserts a role
	 * @param role
	 * @return Role
	 */
	@Override
	public Role insertRole(String role) {
		if (role == null)
			throw new InvalidArgumentException("Name must not be null");
		if (roleRepository.findRoleByRole(role).isPresent()) {
			throw new EntityAlreadyExistsException("Role with name" + role + " already exists");
		}
		return roleRepository.insert(role, user);
	}

	/**
	 * Deletes a role by its id
	 * @param id
	 */
	@Override
	public void deleteRoleById(Long id) {
		if (id == null)
			throw new InvalidArgumentException("Id must not be null");
		if (roleRepository.findById(id).isEmpty()) {
			return;
		}
		roleRepository.deleteById(id);
	}
}
