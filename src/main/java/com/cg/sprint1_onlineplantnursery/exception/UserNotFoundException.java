package com.cg.sprint1_onlineplantnursery.exception;

public class UserNotFoundException extends RuntimeException {

	
	private String message;

	public UserNotFoundException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
