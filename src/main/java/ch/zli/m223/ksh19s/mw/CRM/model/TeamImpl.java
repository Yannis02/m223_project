package ch.zli.m223.ksh19s.mw.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="Team")
public class TeamImpl implements Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String team;
	
	@ManyToOne
	private AppUserImpl appUser;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getTeam() {
		return team;
	}

	protected TeamImpl() {/*for JPA only*/}
	
	public TeamImpl(String team, AppUserImpl appUser) {
		this.team = team;
		this.appUser = appUser;
	}
}
