package ch.zli.m223.ksh19s.mw.CRM.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Injury")
public class InjuryImpl implements Injury {

	private String injury;

	@ManyToOne
	private AppUserImpl appUser;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private long date;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getInjury() {
		// TODO Auto-generated method stub
		return injury;
	}

	protected InjuryImpl() {
		/* for JPA only */
	}

	public InjuryImpl(String injury, AppUserImpl appUser) {
		this.injury = injury;
		this.appUser = appUser;
		this.date = new Date().getTime();
	}

	@Override
	public Date getDate() {
		return new Date(date);
	}

}
