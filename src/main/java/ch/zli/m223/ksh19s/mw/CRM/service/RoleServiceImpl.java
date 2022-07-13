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

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	private AppUser user;

	@Override
	public List<Role> getAllRoles() {
		return new ArrayList<>(roleRepository.findAll());
	}

	@Override
	public Role getRole(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Invalid user Id " + id);
		});
	}

	@Override
	public Role insertRole(String role) {
		if (role == null)
			throw new InvalidArgumentException("Name must not be null");
		if (roleRepository.findRoleByRole(role).isPresent()) {
			throw new EntityAlreadyExistsException("Role with name" + role + " already exists");
		}
		return roleRepository.insert(role, user);
	}

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
