package com.apl.sha.ers.exception;

public class LoginException extends Exception {
	private int status;
	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param status
	 */
	public LoginException(int status) {
		super();
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
}
