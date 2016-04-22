package com.apl.sha.ers.model;

import java.io.Serializable;

public class BlockCodeUpdate implements Serializable {
	private int id;
	private String svcname;
	private String portofloadingcode;
	private String block_code;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getBlock_code() {
		return block_code;
	}
	public void setBlock_code(String block_code) {
		this.block_code = block_code;
	}
	@Override
	public String toString() {
		return id+":"+svcname+";"+portofloadingcode+";"+block_code;
	}
}
