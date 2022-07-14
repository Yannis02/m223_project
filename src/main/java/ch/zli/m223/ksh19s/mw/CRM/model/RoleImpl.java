package ch.zli.m223.ksh19s.mw.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Implementation for the Role
 * @author Yannis Lee
 *
 */
@Entity(name="Role")
public class RoleImpl implements Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String role;
	
	@ManyToOne
	private AppUserImpl appUser;

	/**
	 * Gets the id
	 * @return id
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Gets the role
	 * @return role
	 */
	@Override
	public String getRole() {
		return role;
	}

	/**
	 * Protected constructor for RoleImpl
	 */
	protected RoleImpl() {/*for JPA only*/}
	
	/**
	 * Constructor for RoleImpl
	 * @param role
	 * @param appUser
	 */
	public RoleImpl(String role, AppUserImpl appUser) {
		this.role = role;
		this.appUser = appUser;
	}
}
