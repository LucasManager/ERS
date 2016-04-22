package com.apl.sha.ers.model;

import java.io.Serializable;

public class Priv implements Serializable{
	private int privid;
	private String priv;
	private String param;
	private String comments;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getPriv() {
		return priv;
	}
	public void setPriv(String priv) {
		this.priv = priv;
	}
	public int getPrivid() {
		return privid;
	}
	public void setPrivid(int privid) {
		this.privid = privid;
	}
	@Override
	public String toString() {
		return this.priv;
	}
	
}
