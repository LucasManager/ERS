package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int userid;
	private String firstname;
	private String lastname;
	private String username;
	private String pwd;
	private String title;
	private UserGroup usergroup;
	private String email;
	private int issys;
	private int status;
	private Date createtime;
	private Date updatetime;
	private Privs privs;
	private String locale;
	private String location;
	private String bookingParty;
	private String depot;
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int isdel) {
		this.status = isdel;
	}
	public int getIssys() {
		return issys;
	}
	public void setIssys(int issys) {
		this.issys = issys;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public UserGroup getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(UserGroup usergroup) {
		this.usergroup = usergroup;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Privs getPrivs() {
		return privs;
	}
	public void setPrivs(Privs privs) {
		this.privs = privs;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBookingParty() {
		return bookingParty;
	}
	public void setBookingParty(String bookingParty) {
		this.bookingParty = bookingParty;
	}
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	@Override
	public String toString() {
		
		return "User[ID:"+this.userid+",Name:"+this.username+",Group:"+this.usergroup+"]";
	}
	
}
