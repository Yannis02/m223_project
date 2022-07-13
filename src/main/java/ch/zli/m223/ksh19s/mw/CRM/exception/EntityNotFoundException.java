package ch.zli.m223.ksh19s.mw.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException() { this(""); }
	public EntityNotFoundException(String msg) {
		super(msg, null, false, false);
	}
}
