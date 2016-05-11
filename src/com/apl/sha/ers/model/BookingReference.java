package com.apl.sha.ers.model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class BookingReference implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4423232466298414417L;
	
	private String blnumber;
	private String bookingparty;
	private String vesselName;
	private String voyage;
	private String packages;
	private String kindOfPackages;
	private String receiveTime;
	
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
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	
	/**
	 * 把数字的blNo 格式化为9位数
	 * @param blNo
	 * @return
	 */
	public String formatBL(String blNo)
	{
		long bl = Long.valueOf(blNo);
		DecimalFormat blFormate = new DecimalFormat("000000000");
		return blFormate.format(bl);
		
	}
	public String getKindOfPackages() {
		return kindOfPackages;
	}
	public void setKindOfPackages(String kindOfPackages) {
		this.kindOfPackages = kindOfPackages;
	}
	
}
