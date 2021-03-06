package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;

/**
 * Interface for the UserService
 * @author Yannis Lee
 *
 */
public interface UserService {

	List<AppUser> getAllUsers();

	AppUser getUser(Long id);

	AppUser insertUser(String name, String password);
	
	AppUser insertNewUser(String name, String password, String[] roleNames, String[] teamNames, String[] injuryNames);

	void deleteUserById(Long id);
}
