package com.cg.sprint1_onlineplantnursery.exception;

public class SeedIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public SeedIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SeedIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public SeedIdNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SeedIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeedIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
