package ch.zli.m223.ksh19s.mw.CRM.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;

import ch.zli.m223.ksh19s.mw.CRM.repository.RoleRepository;
import ch.zli.m223.ksh19s.mw.CRM.repository.UserRepository;

import ch.zli.m223.ksh19s.mw.CRM.roles.AppRoles;

@Component
public class ServerInitializer implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;


	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		AppUser brady = userRepository.insert("Tom Brady", "1234");
		roleRepository.insert(AppRoles.ADMIN, brady);
		roleRepository.insert(AppRoles.USER, brady);

		AppUser jones = userRepository.insert("Mac Jones", "1234");
		roleRepository.insert(AppRoles.USER, jones);


	}

}
