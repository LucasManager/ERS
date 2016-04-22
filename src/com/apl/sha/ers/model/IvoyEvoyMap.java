package com.apl.sha.ers.model;

import java.io.Serializable;

public class IvoyEvoyMap implements Serializable {
	private int v_id;
	private String vslcd;
	private String internal_voyid;
	private String external_voyid;
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getVslcd() {
		return vslcd;
	}
	public void setVslcd(String vslcd) {
		this.vslcd = vslcd;
	}
	public String getInternal_voyid() {
		return internal_voyid;
	}
	public void setInternal_voyid(String internal_voyid) {
		this.internal_voyid = internal_voyid;
	}
	public String getExternal_voyid() {
		return external_voyid;
	}
	public void setExternal_voyid(String external_voyid) {
		this.external_voyid = external_voyid;
	}
	@Override
	public String toString() {
		return v_id+":"+vslcd+";"+internal_voyid+";"+external_voyid;
	}
}
