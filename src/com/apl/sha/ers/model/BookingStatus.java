package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.Date;

public class BookingStatus implements Serializable{
		private int id;
		private int blnumber;
		private Date receiveTime;
		private Date createTime;
		private Date uploadTime;
		private Date passedTime;
		private Date sendRacTime;
		private String remark;
		private String sremark;
		public int getBlnumber() {
			return blnumber;
		}
		public void setBlnumber(int blnumber) {
			this.blnumber = blnumber;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getPassedTime() {
			return passedTime;
		}
		public void setPassedTime(Date passedTime) {
			this.passedTime = passedTime;
		}
		public Date getReceiveTime() {
			return receiveTime;
		}
		public void setReceiveTime(Date receiveTime) {
			this.receiveTime = receiveTime;
		}
		public Date getSendRacTime() {
			return sendRacTime;
		}
		public void setSendRacTime(Date sendRacTime) {
			this.sendRacTime = sendRacTime;
		}
		public Date getUploadTime() {
			return uploadTime;
		}
		public void setUploadTime(Date uploadTime) {
			this.uploadTime = uploadTime;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getSremark() {
			return sremark;
		}
		public void setSremark(String sremark) {
			this.sremark = sremark;
		}
}
