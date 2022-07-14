package ch.zli.m223.ksh19s.mw.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for an invalid argument
 * @author Yannis Lee
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {
	
	/**
	 * Constructor for InvalidArgumentException
	 */
	public InvalidArgumentException() { 
		this(""); 
	}
	
	/**
	 * Constructor for InvalidArgumentException with a message
	 * @param msg
	 */
	public InvalidArgumentException(String msg) {
		super(msg, null, false, false);
	}
}
