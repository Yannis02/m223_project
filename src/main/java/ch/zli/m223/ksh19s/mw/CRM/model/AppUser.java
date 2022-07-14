package ch.zli.m223.ksh19s.mw.CRM.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Interface for the AppUser
 * @author Yannis Lee
 *
 */
public interface AppUser extends UserDetails {
	
	public Long getId();
	
	public String getName();
	
	public String getEmail();

	public List<Role> getRoles();

	public List<Team> getTeams();
	
	public List<Injury> getInjuries();
}
