package com.apl.sha.ers.model;

import java.io.Serializable;

public class SVCNameMap implements Serializable {
	private String svcname;
	private String portofloadingcode;
	private String placeofreturn;
	public String getSvcname() {
		return svcname;
	}
	public void setSvcname(String svcname) {
		this.svcname = svcname;
	}
	public String getPortofloadingcode() {
		return portofloadingcode;
	}
	public void setPortofloadingcode(String portofloadingcode) {
		this.portofloadingcode = portofloadingcode;
	}
	public String getPlaceofreturn() {
		return placeofreturn;
	}
	public void setPlaceofreturn(String placeofreturn) {
		this.placeofreturn = placeofreturn;
	}
	public String toString() {
		return svcname+"||"+portofloadingcode+":"+placeofreturn;
	}
}
