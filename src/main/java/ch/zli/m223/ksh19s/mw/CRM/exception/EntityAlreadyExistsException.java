package ch.zli.m223.ksh19s.mw.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for an already existing entity
 * @author Yannis Lee
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.IM_USED)
public class EntityAlreadyExistsException extends RuntimeException  {
	
	/**
	 * Constructor for EntityAlreadyExistsException
	 */
	public EntityAlreadyExistsException() {
		this(""); 
	}
	
	/**
	 * Constructor for EntityAlreadyExistsException with a messsage
	 * @param msg
	 */
	public EntityAlreadyExistsException(String msg) {
		super(msg, null, false, false);
	}
}
