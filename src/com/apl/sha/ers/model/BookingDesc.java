package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.Date;

public class BookingDesc implements Serializable{
		private int blnumber;
		private String sdesc;
		private String comments;
		private String p_reasons;
		public int getBlnumber() {
			return blnumber;
		}
		public void setBlnumber(int blnumber) {
			this.blnumber = blnumber;
		}
		
		public String getSdesc() {
			return sdesc;
		}
		public void setSdesc(String sdesc) {
			this.sdesc = sdesc;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public String getP_reasons() {
			return p_reasons;
		}
		public void setP_reasons(String p_reasons) {
			this.p_reasons = p_reasons;
		}
}
