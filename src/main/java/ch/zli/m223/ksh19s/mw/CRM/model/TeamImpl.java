package ch.zli.m223.ksh19s.mw.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Implementation for the team
 * @author Yannis Lee
 *
 */
@Entity(name="Team")
public class TeamImpl implements Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String team;
	
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
	 * Gets the team
	 * @return team
	 */
	@Override
	public String getTeam() {
		return team;
	}

	/**
	 * Protected constructor for TeamImpl
	 */
	protected TeamImpl() {/*for JPA only*/}
	
	/**
	 * Constructor for TeamImpl
	 * @param team
	 * @param appUser
	 */
	public TeamImpl(String team, AppUserImpl appUser) {
		this.team = team;
		this.appUser = appUser;
	}
}
