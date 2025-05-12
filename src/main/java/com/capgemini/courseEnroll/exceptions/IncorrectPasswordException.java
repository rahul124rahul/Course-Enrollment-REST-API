package com.capgemini.courseEnroll.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncorrectPasswordException extends RuntimeException {
	public IncorrectPasswordException(String message) {
		super(message);
	}
}
