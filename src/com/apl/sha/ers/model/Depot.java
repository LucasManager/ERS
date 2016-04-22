package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Depot implements Serializable{
	private int id;
	private String depotcode;
	private String location;
	private String ename;
	private String cname;
	private String tel;
	private String fax;
	private String eaddress;
	private String caddress;
	private String contact;
	private String email;
	private Map containers=new HashMap();;
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDepotcode() {
		return depotcode;
	}
	public void setDepotcode(String depotcode) {
		this.depotcode = depotcode;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Map getContainers() {
		return containers;
	}
	public void setContainers(Map containers) {
		this.containers = containers;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public void setContainers(List containers) {
		for(Iterator it=containers.iterator();it.hasNext();) {
			DepotCtn depotCtn=(DepotCtn)it.next();
			this.containers.put(depotCtn.getCtnType(),depotCtn);
		}
	}
	public DepotCtn getContainer(String ctncode) {
		return (DepotCtn)containers.get(ctncode);
	}
}
