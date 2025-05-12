package com.capgemini.courseEnroll.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnrollmentNotFoundException extends RuntimeException {
	public EnrollmentNotFoundException(String message) {
		super(message);
	}
}
