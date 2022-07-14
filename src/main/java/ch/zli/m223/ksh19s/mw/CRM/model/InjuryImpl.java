package ch.zli.m223.ksh19s.mw.CRM.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Implementation for the injury
 * @author Yannis Lee
 *
 */
@Entity(name = "Injury")
public class InjuryImpl implements Injury {

	private String injury;

	@ManyToOne
	private AppUserImpl appUser;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private long date;

	/**
	 * Gets the id
	 * @return id
	 */
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/**
	 * Gets the injury
	 * @return injury
	 */
	@Override
	public String getInjury() {
		// TODO Auto-generated method stub
		return injury;
	}

	/**
	 * Protected constructor for InjuryImpl
	 */
	protected InjuryImpl() {
		/* for JPA only */
	}

	/**
	 * Constructor for InjuryImpl
	 * @param injury
	 * @param appUser
	 */
	public InjuryImpl(String injury, AppUserImpl appUser) {
		this.injury = injury;
		this.appUser = appUser;
		this.date = new Date().getTime();
	}

	/**
	 * Gets the date
	 * @return new Date(date)
	 */
	@Override
	public Date getDate() {
		return new Date(date);
	}
}
