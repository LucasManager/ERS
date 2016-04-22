package com.apl.sha.ers.model;

import java.io.Serializable;


public abstract class Container implements Serializable{
	protected CtnType ctnType;
	protected String ctnCode;
	public CtnType getCtnType() {
		return ctnType;
	}
	public void setCtnType(CtnType ctnType) {
		this.ctnType = ctnType;
	}
	public String getCtnCode() {
		return ctnCode;
	}
	public void setCtnCode(String ctnCode) {
		this.ctnCode = ctnCode;
	}
	
}
