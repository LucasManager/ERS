package com.apl.sha.ers.model;

import java.io.Serializable;

public class CtnType implements Serializable{
	private String ctncode;
	private String intlCode;
	private int aplsize;
	private String apltype;
	private int aplheight;
	public int getAplheight() {
		return aplheight;
	}
	public void setAplheight(int aplheight) {
		this.aplheight = aplheight;
	}
	public int getAplsize() {
		return aplsize;
	}
	public void setAplsize(int aplsize) {
		this.aplsize = aplsize;
	}
	public String getApltype() {
		return apltype;
	}
	public void setApltype(String apltype) {
		this.apltype = apltype;
	}
	public String getCtncode() {
		return ctncode;
	}
	public void setCtncode(String intlcode) {
		this.ctncode = intlcode;
	}
	public String getIntlCode() {
		return intlCode;
	}
	public void setIntlCode(String intlCode) {
		this.intlCode = intlCode;
	}
	@Override
	public String toString() {
		return apltype+","+aplsize+","+aplheight;
	}
}
