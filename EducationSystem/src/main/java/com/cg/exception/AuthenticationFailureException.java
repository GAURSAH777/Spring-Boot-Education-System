package com.cg.exception;

public class AuthenticationFailureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthenticationFailureException(String msg) {
		super(msg);
	}

}
