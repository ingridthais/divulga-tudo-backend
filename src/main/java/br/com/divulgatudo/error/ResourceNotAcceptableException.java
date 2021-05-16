package br.com.divulgatudo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ResourceNotAcceptableException extends RuntimeException {
	public ResourceNotAcceptableException() {
		super();
	}

	public ResourceNotAcceptableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotAcceptableException(String message) {
		super(message);
	}

	public ResourceNotAcceptableException(Throwable cause) {
		super(cause);
	}
}
