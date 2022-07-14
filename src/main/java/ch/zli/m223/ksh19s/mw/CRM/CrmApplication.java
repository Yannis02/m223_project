package ch.zli.m223.ksh19s.mw.CRM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Class to start the application
 * @author Yannis Lee
 *
 */
@SpringBootApplication
public class CrmApplication {

	/**
	 * Main to start the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	/**
	 * Returns a new encoder for the password
	 * @return new BCryptPasswordEncoder
	 */
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
