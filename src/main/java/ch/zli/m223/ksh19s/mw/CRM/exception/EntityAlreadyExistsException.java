package ch.zli.m223.ksh19s.mw.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.IM_USED)
public class EntityAlreadyExistsException extends RuntimeException  {
	public EntityAlreadyExistsException() { this(""); }
	public EntityAlreadyExistsException(String msg) {
		super(msg, null, false, false);
	}
}
