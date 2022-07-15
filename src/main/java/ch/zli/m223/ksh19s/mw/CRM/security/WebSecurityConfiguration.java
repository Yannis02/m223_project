package ch.zli.m223.ksh19s.mw.CRM.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zli.m223.ksh19s.mw.CRM.data.Roles;

/**
 * Configuration for the security of the application
 * @author Yannis Lee
 *
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	UserDetailsService userDetailsService;
	BCryptPasswordEncoder bcriptPasswordEncoder;

	/**
	 * Constructor for WebSecurityConfiguration
	 * @param userDetailsService
	 * @param bcriptPasswordEncoder
	 */
	public WebSecurityConfiguration(UserDetailsService userDetailsService,
			BCryptPasswordEncoder bcriptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bcriptPasswordEncoder = bcriptPasswordEncoder;
	}

	/**
	 * Configures the password
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcriptPasswordEncoder);
	}

	/**
	 * Configures the authorities of rest and web
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		configureWeb(http);
		configureRest(http);
	}

	/**
	 * Configures the authorities of the web
	 * @param http
	 * @throws Exception
	 */
	private void configureWeb(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/").permitAll().antMatchers("/admin/**").hasAuthority(Roles.ADMIN)
				.antMatchers("/web/users").hasAuthority(Roles.ADMIN)
				.antMatchers("/web/**").hasAnyAuthority(Roles.USER, Roles.ADMIN)
				.antMatchers("/user/**").hasAnyAuthority(Roles.USER).antMatchers("/logedin").authenticated().and()
				.formLogin().permitAll() // loginpage zugänglich für jeden
				.and().logout().permitAll(); // logoutpage zugänglich für jeden
	}

	/**
	 * Configures the authorities of rest
	 * @param http
	 * @throws Exception
	 */
	private void configureRest(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/v1/users").hasAnyAuthority(Roles.ADMIN)
                .antMatchers("/api/v1/**").hasAnyAuthority(Roles.USER, Roles.ADMIN)
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }
}
