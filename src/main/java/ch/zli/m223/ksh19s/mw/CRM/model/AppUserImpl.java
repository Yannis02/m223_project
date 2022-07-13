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

	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TeamImpl> teams;


	private String passwordHash;

	protected AppUserImpl() {
		/* for JPA only */
		roles = new ArrayList<>();
		teams = new ArrayList<>();

	}

	public AppUserImpl(String name, String password) {
		this();
		this.name = name;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.passwordHash = encoder.encode(password);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getEmail() {
		return name;
	}

	@Override
	public List<Role> getRoles() {
		return new ArrayList<>(roles);
	}

	public void addRoleToList(RoleImpl newRole) {
		roles.add(newRole);
	}
	
	@Override
	public List<Team> getTeams() {
		return new ArrayList<>(teams);
	}

	public void addTeamToList(TeamImpl newTeam) {
		teams.add(newTeam);
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return passwordHash;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}