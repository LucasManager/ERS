package com.apl.sha.ers.model;

import java.io.Serializable;

public class BookingReference implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4423232466298414417L;
	
	private String blnumber;
	private String bookingparty;
	private String descCN;
	private String descEN;
	private String receiveTime;
	
	public String getDescCN() {
		return descCN;
	}
	public void setDescCN(String descCN) {
		this.descCN = descCN;
	}
	public String getDescEN() {
		return descEN;
	}
	public void setDescEN(String descEN) {
		this.descEN = descEN;
	}
	public String getBlnumber() {
		return blnumber;
	}
	public void setBlnumber(String blnumber) {
		this.blnumber = blnumber;
	}
	public String getBookingparty() {
		return bookingparty;
	}
	public void setBookingparty(String bookingparty) {
		this.bookingparty = bookingparty;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	
}
