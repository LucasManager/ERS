package com.apl.sha.ers.model;

import java.io.Serializable;

public class UserGroup implements Serializable{
	private int groupid;
	private String groupname;
	private String comments;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	@Override
	public String toString() {
		return "UserGroup[ID:"+groupid+",Name:"+groupname+"]";
	}
	
}
