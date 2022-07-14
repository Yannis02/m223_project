package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19s.mw.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19s.mw.CRM.exception.EntityAlreadyExistsException;
import ch.zli.m223.ksh19s.mw.CRM.exception.EntityNotFoundException;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.repository.UserRepository;

/**
 * Implementation of UserService
 * @author Yannis Lee
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Gets all the users
	 * @return List<AppUser>
	 */
	@Override
	public List<AppUser> getAllUsers() {
		return new ArrayList<>(userRepository.findAll());
	}

	/**
	 * Gets a user by its id
	 * @param id
	 * @return AppUser
	 */
	@Override
	public AppUser getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Invalid user Id " + id);
		});
	}

	/**
	 * Inserts a user
	 * @param name
	 * @param password
	 * @return AppUser
	 */
	@Override
	public AppUser insertUser(String name, String password) {
		if (name == null)
			throw new InvalidArgumentException("Name must not be null");
		if (userRepository.findUserByName(name).isPresent()) {
			throw new EntityAlreadyExistsException("User with name " + name + " already exists");
		}
		return userRepository.insert(name, password);
	}

	/**
	 * Deletes a user by its id
	 * @param id
	 */
	@Override
	public void deleteUserById(Long id) {
		if (id == null)
			throw new InvalidArgumentException("Id must not be null");
		if (userRepository.findById(id).isEmpty()) {
			return;
		}
		userRepository.deleteById(id);
	}

	/**
	 * Inserts a new user
	 * @param name
	 * @param password
	 * @param roleNames
	 * @param teamNames
	 * @param injuryNames
	 * @return AppUser
	 */
	@Override
	public AppUser insertNewUser(String name, String password, String[] roleNames, String[] teamNames, String[] injuryNames) {
		if (name == null)
			throw new InvalidArgumentException("Name must not be null");
		if (userRepository.findUserByName(name).isPresent()) {
			throw new EntityAlreadyExistsException("User with name " + name + " already exists");
		}
		return userRepository.insertNewUser(name, password, roleNames, teamNames, injuryNames);
	}
}
