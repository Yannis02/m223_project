package ch.zli.m223.ksh19s.mw.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUserImpl;
import ch.zli.m223.ksh19s.mw.CRM.model.Injury;
import ch.zli.m223.ksh19s.mw.CRM.model.InjuryImpl;
import ch.zli.m223.ksh19s.mw.CRM.model.Team;
import ch.zli.m223.ksh19s.mw.CRM.model.TeamImpl;

public interface InjuryRepository extends JpaRepository<InjuryImpl, Long>{
	
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