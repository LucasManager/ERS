package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.Date;

public class BookingCtn extends Container implements Serializable {
	private int id;
	private int blnumber;
	private String intlcode;
	private int ctnQty;
	private String depotCode;
	private String depotCname;
	private String status;
	private Date reserveDate;
	private Date pickupDate;
	private String ctnNbr;
	public int getBlnumber() {
		return blnumber;
	}
	public void setBlnumber(int blnumber) {
		this.blnumber = blnumber;
	}
	public int getCtnQty() {
		return ctnQty;
	}
	public void setCtnQty(int ctnQty) {
		this.ctnQty = ctnQty;
	}

	public String getDepotCode() {
		return depotCode;
	}
	public void setDepotCode(String depotCode) {
		this.depotCode = depotCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIntlcode() {
		return intlcode;
	}
	public void setIntlcode(String intlcode) {
		this.intlcode = intlcode;
	}
	
	public String getDepotCname() {
		return depotCname;
	}
	public void setDepotCname(String depotCname) {
		this.depotCname = depotCname;
	}
	public String getCtnNbr() {
		return ctnNbr;
	}
	public void setCtnNbr(String ctnNbr) {
		this.ctnNbr = ctnNbr;
	}
	@Override
	public String toString() {
		return "BookingCtn[BL Nbr:"+blnumber+",Code:"+ctnCode+",Qty:"+ctnQty+"]";
	}
	
	
}
