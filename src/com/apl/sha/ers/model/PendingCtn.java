package com.apl.sha.ers.model;

import java.io.Serializable;

public class PendingCtn implements Serializable {
	private int blnumber;
	private String loadingcode;
	private String passedtime;
	private String ctncode;
	private String intlcode;
	private int ctnqty;
	public int getBlnumber() {
		return blnumber;
	}
	public void setBlnumber(int blnumber) {
		this.blnumber = blnumber;
	}
	public int getCtnqty() {
		return ctnqty;
	}
	public void setCtnqty(int ctnqty) {
		this.ctnqty = ctnqty;
	}
	public String getPassedtime() {
		return passedtime;
	}
	public void setPassedtime(String passedtime) {
		this.passedtime = passedtime;
	}
	public String getCtncode() {
		return ctncode;
	}
	public void setCtncode(String ctncode) {
		this.ctncode = ctncode;
	}
	public String getLoadingcode() {
		return loadingcode;
	}
	public void setLoadingcode(String loadingcode) {
		this.loadingcode = loadingcode;
	}
	public String getIntlcode() {
		return intlcode;
	}
	public void setIntlcode(String intlcode) {
		this.intlcode = intlcode;
	}
}
