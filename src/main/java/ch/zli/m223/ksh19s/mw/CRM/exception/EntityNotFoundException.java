package ch.zli.m223.ksh19s.mw.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for an entity that was not found
 * @author Yannis Lee
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
	
	/**
	 * Constructor for EntityNotFoundException
	 */
	public EntityNotFoundException() { 
		this(""); 
	}
	
	/**
	 * Constructor for EntityNotFoundException with a message
	 * @param msg
	 */
	public EntityNotFoundException(String msg) {
		super(msg, null, false, false);
	}
}
