package com.apl.sha.ers.model;

import java.io.Serializable;

public class OneWayCtn extends Container implements Serializable {
	private int id;
	private String location;
	private String dest;
	private String depotCode;
	private int ctns;
	private Boolean status;
	private String oremark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCtnCode() {
		return ctnCode;
	}
	public void setCtnCode(String ctnCode) {
		this.ctnCode = ctnCode;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getDepotCode() {
		return depotCode;
	}
	public void setDepotCode(String depotCode) {
		this.depotCode = depotCode;
	}
	public int getCtns() {
		return ctns;
	}
	public void setCtns(int ctns) {
		this.ctns = ctns;
	}

	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getOremark() {
		return oremark;
	}
	public void setOremark(String oremark) {
		this.oremark = oremark;
	}
	public String toString() {
		return "OneWayCtn[Loc:"+location+",CtnCode:"+ctnCode+",Dest:"+dest+"]";
	}
	
}
