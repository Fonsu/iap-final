package org.mule.examples.jobservice.exceptions;

import org.mule.module.apikit.exception.MuleRestException;

public class ConflictException extends MuleRestException {

	private static final long serialVersionUID = 3387516993124229969L;

	public ConflictException(String message) {
		super(message);
	}
}
