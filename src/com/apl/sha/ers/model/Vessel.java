package com.apl.sha.ers.model;

import java.io.Serializable;

public class Vessel implements Serializable {
	private String id;
	private String name ;
	private String simpleName;
	private String cname;
	private String callsign;
	private String lloyds ;
	private String svcname ;
	private String sname ;
	public String getCallsign() {
		return callsign;
	}
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String name) {
		cname = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLloyds() {
		return lloyds;
	}
	public void setLloyds(String lloyds) {
		this.lloyds = lloyds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public String getSvcname() {
		return svcname;
	}
	public void setSvcname(String svcname) {
		this.svcname = svcname;
	}
	@Override
	public String toString() {
		return id+":"+name+";"+svcname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
