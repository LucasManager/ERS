package com.apl.sha.ers.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrCode {
	/**
	 * ErrorCode for Booking unPassed
	 */
	public static int unPassedBookingCode=1;
	public static int notOwnerBookingCode=2;
	
	private static Map bookingError;		
	
	public static Map getBookingError() {
		if(bookingError==null) {
			bookingError=new HashMap();
			bookingError.put(1, "UnPassed");
			bookingError.put(2, "Not owner of the booking");
		}
		return bookingError;
	}
}
