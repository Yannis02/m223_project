package ch.zli.m223.ksh19s.mw.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUserImpl;

/**
 * Repository of the user
 * @author Yannis Lee
 *
 */
public interface UserRepository extends JpaRepository<AppUserImpl, Long> {

	/**
	 * Inserts a user
	 * @param userName
	 * @param password
	 * @return save(user)
	 */
	default AppUser insert(String userName, String password) {
		AppUserImpl user = new AppUserImpl(userName, password);
		return save(user);
	}

	/**
	 * Inserts a user, used to add a new user
	 * @param userName
	 * @param password
	 * @param roleNames
	 * @param teamNames
	 * @param injuryNames
	 * @return save(user)
	 */
	default AppUser insertNewUser(String userName, String password, String[] roleNames, String[] teamNames, String[] injuryNames) {
		AppUserImpl user = new AppUserImpl(userName, password, roleNames, teamNames, injuryNames);
		return save(user);
	}
	
	Optional<AppUserImpl> findUserByName(String name); // Spring black magic
	
}
