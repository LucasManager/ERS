package com.apl.sha.ers.model;

public class BookingCtnGroup extends BookingCtn {
	private String blnumbers;

	public String getBlnumbers() {
		return blnumbers;
	}

	public void setBlnumbers(String blnumbers) {
		this.blnumbers = blnumbers;
	}
	public BookingCtnGroup() {
//		setCtnQty(0);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BookingCtn))
			return false;
		BookingCtn bc = (BookingCtn) obj;
		if(this.getDepotCode()==null) {
			return false;
		}
		if (getDepotCode().equalsIgnoreCase(bc.getDepotCode())
				&& this.getCtnCode().equalsIgnoreCase(bc.getCtnCode())
				&& this.getStatus().equalsIgnoreCase(bc.getStatus())) {
			return true;
		}
		return false;
	}
}
