package ch.zli.m223.ksh19s.mw.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUserImpl;
import ch.zli.m223.ksh19s.mw.CRM.model.Team;
import ch.zli.m223.ksh19s.mw.CRM.model.TeamImpl;

/**
 * Repository of the team
 * @author Yannis Lee
 *
 */
public interface TeamRepository extends JpaRepository<TeamImpl, Long>{
	
	/**
	 * Inserts a team
	 * @param teamName
	 * @param appUser
	 * @return savedNewTeam
	 */
	default Team insert(String teamName, AppUser appUser) {
		
			// cast to Impl
			AppUserImpl userImpl = (AppUserImpl) appUser;

			// Create new Role
			TeamImpl newTeam = new TeamImpl(teamName, userImpl);

			// Save Role to DB
			TeamImpl savedNewTeam = save(newTeam);

			// Update users role list
			userImpl.addTeamToList(savedNewTeam);

			// Return new Role
			return savedNewTeam;
		}

		Optional<TeamImpl> findTeamByTeam(String team); // Spring black magic

}
