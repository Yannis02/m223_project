package ch.zli.m223.ksh19s.mw.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="Injury")
public class InjuryImpl implements Injury{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String injury;
	
	@ManyToOne
	private AppUserImpl appUser;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getInjury() {
		return injury;
	}

	protected InjuryImpl() {/*for JPA only*/}
	
	public InjuryImpl(String injury, AppUserImpl appUser) {
		this.injury = injury;
		this.appUser = appUser;
	}

}
