package br.com.divulgatudo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NO_CONTENT)
public class ResourceNotContentException extends RuntimeException {
	public ResourceNotContentException() {
		super();
	}

	public ResourceNotContentException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotContentException(String message) {
		super(message);
	}

	public ResourceNotContentException(Throwable cause) {
		super(cause);
	}
}
