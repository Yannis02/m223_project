package ch.zli.m223.ksh19s.mw.CRM.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19s.mw.CRM.repository.UserRepository;

/**
 * Checks for a username
 * @author Yannis Lee
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Loads a user by his username
	 * @return user
	 */
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userRepository.findUserByName(name).orElseThrow(() -> {
			throw new UsernameNotFoundException(name);
		});
	}
}
