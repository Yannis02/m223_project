package ch.zli.m223.ksh19s.mw.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUserImpl;
import ch.zli.m223.ksh19s.mw.CRM.model.Injury;
import ch.zli.m223.ksh19s.mw.CRM.model.InjuryImpl;

/**
 * Repository of the injury
 * @author Yannis Lee
 *
 */
public interface InjuryRepository extends JpaRepository<InjuryImpl, Long>{
	
	/**
	 * Insert of an injury
	 * @param typeofInjury
	 * @param appUser
	 * @return savedNewInjury
	 */
	default Injury insert(String typeofInjury, AppUser appUser) {
		
		// cast to Impl
		AppUserImpl userImpl = (AppUserImpl) appUser;

		// Create new Role
		InjuryImpl newInjury = new InjuryImpl(typeofInjury, userImpl);

		// Save Role to DB
		InjuryImpl savedNewInjury = save(newInjury);

		// Update users role list
		userImpl.addInjuryToList(savedNewInjury);

		// Return new Role
		return savedNewInjury;
	}

	Optional<InjuryImpl> findInjuryByInjury(String injury); // Spring black magic

}
