package com.apl.sha.ers.exception;

public class BookingException extends Exception {

	private int errCode;
	public BookingException() {
		super();
	}

	public BookingException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookingException(String message) {
		super(message);
	}

	public BookingException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param errCode
	 */
	public BookingException(int errCode) {
		super();
		this.errCode = errCode;
		
	}

	public int getErrCode() {
		return errCode;
	}

	@Override
	public String getMessage() {
		return (String)(ErrCode.getBookingError().get(errCode));
	}
	
}
