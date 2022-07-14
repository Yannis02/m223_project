package ch.zli.m223.ksh19s.mw.CRM.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Implementation of the AppUser
 * @author Yannis Lee
 *
 */
@Entity(name = "AppUser")
@SuppressWarnings("serial")
public class AppUserImpl implements AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RoleImpl> roles;

	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
	private List<TeamImpl> teams;
	
	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
	private List<InjuryImpl> injuries;

	private String passwordHash;

	/**
	 * Protected constructor for AppUserImpl
	 */
	protected AppUserImpl() {
		/* for JPA only */
		roles = new ArrayList<>();
		teams = new ArrayList<>();
		injuries = new ArrayList<>();
	}

	/**
	 * Constructor for AppUserImpl
	 * @param name
	 * @param password
	 */
	public AppUserImpl(String name, String password) {
		this();
		this.name = name;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.passwordHash = encoder.encode(password);
	}
	
	/**
	 * Constructor for AppUserImpl used to save a new user
	 * @param name
	 * @param password
	 * @param roleNames
	 * @param teamNames
	 * @param injuryNames
	 */
	public AppUserImpl(String name, String password, String [] roleNames, String[] teamNames, String[] injuryNames ) {
		this();
		this.name = name;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.passwordHash = encoder.encode(password);
		setRoles(roleNames);
		setTeams(teamNames);
		setInjuries(injuryNames);
		
	}

	/**
	 * Gets the id
	 * @return id
	 */
	@Override
	public Long getId() {
		return id;
	}
	
	/**
	 * Gets the name
	 * @return name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets the roles
	 * @return new ArrayList<>(roles)
	 */
	@Override
	public List<Role> getRoles() {
		return new ArrayList<>(roles);
	}

	/**
	 * Adds roles to the list
	 * @param newRole
	 */
	public void addRoleToList(RoleImpl newRole) {
		roles.add(newRole);
	}
	
	/**
	 * Gets all the teams
	 * @return ArrayList<>(teams)
	 */
	@Override
	public List<Team> getTeams() {
		return new ArrayList<>(teams);
	}

	/**
	 * Adds teams to the list
	 * @param newTeam
	 */
	public void addTeamToList(TeamImpl newTeam) {
		teams.add(newTeam);
	}
	
	/**
	 * Gets the injuries
	 * @return ArrayList<>(injuries)
	 */
	@Override
	public List<Injury> getInjuries() {
		return new ArrayList<>(injuries);
	}

	/**
	 * Adds injuries to the list
	 * @param newInjury
	 */
	public void addInjuryToList(InjuryImpl newInjury) {
		injuries.add(newInjury);
	}

	/**
	 * Gets the authoritites
	 * @return Collection<?
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	/**
	 * Gets the password
	 * @return passwordHash
	 */
	@Override
	public String getPassword() {
		return passwordHash;
	}

	/**
	 * Checks whether account is expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Checks whether account is locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks whether credentials are expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks whether the account is expired
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	/**
	 * Sets the roles
	 * @param roleNames
	 */
	public void setRoles(String[] roleNames) {
		this.roles = new ArrayList<>();
		for(String role : roleNames) {
			addRoleToList(new RoleImpl(role, this));
		}
	}
	
	/**
	 * Sets the teams
	 * @param teamNames
	 */
	public void setTeams(String[] teamNames) {
		this.teams = new ArrayList<>();
		for(String team : teamNames) {
			addTeamToList(new TeamImpl(team, this));
		}
	}
	
	/**
	 * Sets the injuries
	 * @param injuryNames
	 */
	public void setInjuries(String[] injuryNames) {
		this.injuries = new ArrayList<>();
		for(String injury : injuryNames) {
			addInjuryToList(new InjuryImpl(injury, this));
		}
	}

	/**
	 * Gets the username
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the email
	 */
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return name;
	}
}