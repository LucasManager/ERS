package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.Date;

public class DepotCtn extends Container implements Serializable{
	private int id;
	private String depotCode;
	private int initalQty;
	private int reservedQty;
	private int pickupedQty;
	private Date initalDate;
	private Date updateTime;
	private User updateUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepotCode() {
		return depotCode;
	}
	public void setDepotCode(String depotCode) {
		this.depotCode = depotCode;
	}
	public Date getInitalDate() {
		return initalDate;
	}
	public void setInitalDate(Date initaltime) {
		this.initalDate = initaltime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updatetime) {
		this.updateTime = updatetime;
	}
	public User getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(User updateuser) {
		this.updateUser = updateuser;
	}
	public int getInitalQty() {
		return initalQty;
	}
	public void setInitalQty(int initalQty) {
		this.initalQty = initalQty;
	}
	public int getPickupedQty() {
		return pickupedQty;
	}
	public void setPickupedQty(int pickupedQty) {
		this.pickupedQty = pickupedQty;
	}
	public int getReservedQty() {
		return reservedQty;
	}
	public void setReservedQty(int reservedQty) {
		this.reservedQty = reservedQty;
	}
	
}
