package ch.zli.m223.ksh19s.mw.CRM.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.ksh19s.mw.CRM.data.Injuries;
import ch.zli.m223.ksh19s.mw.CRM.data.Names;
import ch.zli.m223.ksh19s.mw.CRM.data.Roles;
import ch.zli.m223.ksh19s.mw.CRM.data.Teams;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.repository.InjuryRepository;
import ch.zli.m223.ksh19s.mw.CRM.repository.RoleRepository;
import ch.zli.m223.ksh19s.mw.CRM.repository.TeamRepository;
import ch.zli.m223.ksh19s.mw.CRM.repository.UserRepository;

/**
 * Initializes all the objects when starting the application
 * @author Yannis Lee
 *
 */
@Component
public class ServerInitializer implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private InjuryRepository injuryRepository;


	/**
	 * Initializes all the objects
	 */
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		
		AppUser admin = userRepository.insert(Names.ADMIN, "1234");
		roleRepository.insert(Roles.ADMIN, admin);
		
		AppUser brady = userRepository.insert(Names.TOMBRADY, "1234");
		roleRepository.insert(Roles.ADMIN, brady);
		roleRepository.insert(Roles.USER, brady);
		teamRepository.insert(Teams.BUCCANEERS, brady);
		injuryRepository.insert(Injuries.LEFTKNEECONTUSION, brady);
		injuryRepository.insert(Injuries.BROKENRIBS, brady);

		AppUser jones = userRepository.insert(Names.MACJONES, "1234");
		roleRepository.insert(Roles.USER, jones);
		teamRepository.insert(Teams.PATRIOTS, jones);
		injuryRepository.insert(Injuries.TORNACL, jones);
		injuryRepository.insert(Injuries.CONCUSSION, jones);
		injuryRepository.insert(Injuries.BROKENFINGER, jones);
		
		AppUser ramsey = userRepository.insert(Names.JALENRAMSEY, "1234");
		roleRepository.insert(Roles.USER, ramsey);
		teamRepository.insert(Teams.RAMS, ramsey);
		injuryRepository.insert(Injuries.TORNACL, ramsey);
		injuryRepository.insert(Injuries.LEFTKNEECONTUSION, ramsey);
	}
}
