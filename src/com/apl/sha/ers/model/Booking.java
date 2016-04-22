package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author dzhou
 * 
 */
public class Booking implements Serializable{
	private Long id;
	private int blnumber;
	private String blockcode;
	private String referenceno;
	private String bookingparty;
	private String accountcode;
	private String shippercode;
	private String shipper;
	private String shippername;
	private String consigneecode;
	private String consignee;
	private String consigneename;
	private String notifypartycode;
	private String notifypartyname;
	private String alsonotifypartycode;
	private String alsonotifypartyname1;
	private String alsonotifypartyname2;
	private String commodity;
	private String descriptionofgoods;
	private String marks;
	private String placeofreceiptcode;
	private String placeofreceipt;
	private String portofloadingcode;
	private String portofloading;
	private String portofdischargecode;
	private String portofdischarge;
	private String placeofdeliverycode;
	private String placeofdelivery;
	private String vslvoyid;
	private String vesselname;
	private String voyage;
	private Date onboarddate;
	private String cargomodel;
	private String shippingmodel;
	private boolean seawaybill;
	private boolean expressbill;
	private boolean showoceanfreight;
	private String prepaidcollect;
	private String tradeterm;
	private int packages;
	private String kindofpackages;
	private String descriptionofpackages;
	private double grossweight;
	private double measurement;
	private String packagesofcartons;
	private String kindofcartons;
	private Date messageconfirmdate;
	private boolean bookingupload;
	private boolean readyupload;
	private String tempdefine;
	private String settemp;
	private String maxtemp;
	private String mintemp;
	private String airrate;
	private BookingStatus status;
	private Map ctns;
	public String getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}
	public String getAirrate() {
		return airrate;
	}
	public void setAirrate(String airrate) {
		this.airrate = airrate;
	}
	public String getAlsonotifypartycode() {
		return alsonotifypartycode;
	}
	public void setAlsonotifypartycode(String alsonotifypartycode) {
		this.alsonotifypartycode = alsonotifypartycode;
	}
	public String getAlsonotifypartyname1() {
		return alsonotifypartyname1;
	}
	public void setAlsonotifypartyname1(String alsonotifypartyname1) {
		this.alsonotifypartyname1 = alsonotifypartyname1;
	}
	public String getAlsonotifypartyname2() {
		return alsonotifypartyname2;
	}
	public void setAlsonotifypartyname2(String alsonotifypartyname2) {
		this.alsonotifypartyname2 = alsonotifypartyname2;
	}
	public int getBlnumber() {
		return blnumber;
	}
	public void setBlnumber(int blnumber) {
		this.blnumber = blnumber;
	}
	public String getBlockcode() {
		return blockcode;
	}
	public void setBlockcode(String blockcode) {
		this.blockcode = blockcode;
	}
	public boolean isBookingupload() {
		return bookingupload;
	}
	public void setBookingupload(boolean bookingupload) {
		this.bookingupload = bookingupload;
	}
	public String getCargomodel() {
		return cargomodel;
	}
	public void setCargomodel(String cargomodel) {
		this.cargomodel = cargomodel;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigneecode() {
		return consigneecode;
	}
	public void setConsigneecode(String consigneecode) {
		this.consigneecode = consigneecode;
	}
	public String getConsigneename() {
		return consigneename;
	}
	public void setConsigneename(String consigneename) {
		this.consigneename = consigneename;
	}
	public String getDescriptionofgoods() {
		return descriptionofgoods;
	}
	public void setDescriptionofgoods(String descriptionofgoods) {
		this.descriptionofgoods = descriptionofgoods;
	}
	public String getDescriptionofpackages() {
		return descriptionofpackages;
	}
	public void setDescriptionofpackages(String descriptionofpackages) {
		this.descriptionofpackages = descriptionofpackages;
	}
	public boolean isExpressbill() {
		return expressbill;
	}
	public void setExpressbill(boolean expressbill) {
		this.expressbill = expressbill;
	}
	public double getGrossweight() {
		return grossweight;
	}
	public void setGrossweight(double grossweight) {
		this.grossweight = grossweight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKindofcartons() {
		return kindofcartons;
	}
	public void setKindofcartons(String kindofcartons) {
		this.kindofcartons = kindofcartons;
	}
	public String getKindofpackages() {
		return kindofpackages;
	}
	public void setKindofpackages(String kindofpackages) {
		this.kindofpackages = kindofpackages;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getMaxtemp() {
		return maxtemp;
	}
	public void setMaxtemp(String maxtemp) {
		this.maxtemp = maxtemp;
	}
	public double getMeasurement() {
		return measurement;
	}
	public void setMeasurement(double measurement) {
		this.measurement = measurement;
	}
	public Date getMessageconfirmdate() {
		return messageconfirmdate;
	}
	public void setMessageconfirmdate(Date messageconfirmdate) {
		this.messageconfirmdate = messageconfirmdate;
	}
	public String getMintemp() {
		return mintemp;
	}
	public void setMintemp(String mintemp) {
		this.mintemp = mintemp;
	}
	public String getNotifypartycode() {
		return notifypartycode;
	}
	public void setNotifypartycode(String notifypartycode) {
		this.notifypartycode = notifypartycode;
	}
	public String getNotifypartyname() {
		return notifypartyname;
	}
	public void setNotifypartyname(String notifypartyname) {
		this.notifypartyname = notifypartyname;
	}
	public Date getOnboarddate() {
		return onboarddate;
	}
	public void setOnboarddate(Date onboarddate) {
		this.onboarddate = onboarddate;
	}
	public int getPackages() {
		return packages;
	}
	public void setPackages(int packages) {
		this.packages = packages;
	}
	public String getPackagesofcartons() {
		return packagesofcartons;
	}
	public void setPackagesofcartons(String packagesofcartons) {
		this.packagesofcartons = packagesofcartons;
	}
	public String getPlaceofdelivery() {
		return placeofdelivery;
	}
	public void setPlaceofdelivery(String placeofdelivery) {
		this.placeofdelivery = placeofdelivery;
	}
	public String getPlaceofdeliverycode() {
		return placeofdeliverycode;
	}
	public void setPlaceofdeliverycode(String placeofdeliverycode) {
		this.placeofdeliverycode = placeofdeliverycode;
	}
	public String getPlaceofreceipt() {
		return placeofreceipt;
	}
	public void setPlaceofreceipt(String placeofreceipt) {
		this.placeofreceipt = placeofreceipt;
	}
	public String getPlaceofreceiptcode() {
		return placeofreceiptcode;
	}
	public void setPlaceofreceiptcode(String placeofreceiptcode) {
		this.placeofreceiptcode = placeofreceiptcode;
	}
	public String getPortofdischarge() {
		return portofdischarge;
	}
	public void setPortofdischarge(String portofdischarge) {
		this.portofdischarge = portofdischarge;
	}
	public String getPortofdischargecode() {
		return portofdischargecode;
	}
	public void setPortofdischargecode(String portofdischargecode) {
		this.portofdischargecode = portofdischargecode;
	}
	public String getPortofloading() {
		return portofloading;
	}
	public void setPortofloading(String portofloading) {
		this.portofloading = portofloading;
	}
	public String getPortofloadingcode() {
		return portofloadingcode;
	}
	public void setPortofloadingcode(String portofloadingcode) {
		this.portofloadingcode = portofloadingcode;
	}
	public String getPrepaidcollect() {
		return prepaidcollect;
	}
	public void setPrepaidcollect(String prepaidcollect) {
		this.prepaidcollect = prepaidcollect;
	}
	public boolean isReadyupload() {
		return readyupload;
	}
	public void setReadyupload(boolean readyupload) {
		this.readyupload = readyupload;
	}
	public String getReferenceno() {
		return referenceno;
	}
	public void setReferenceno(String referenceno) {
		this.referenceno = referenceno;
	}
	public boolean isSeawaybill() {
		return seawaybill;
	}
	public void setSeawaybill(boolean seawaybill) {
		this.seawaybill = seawaybill;
	}
	public String getSettemp() {
		return settemp;
	}
	public void setSettemp(String settemp) {
		this.settemp = settemp;
	}
	public String getShipper() {
		return shipper;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public String getShippercode() {
		return shippercode;
	}
	public void setShippercode(String shippercode) {
		this.shippercode = shippercode;
	}
	public String getShippername() {
		return shippername;
	}
	public void setShippername(String shippername) {
		this.shippername = shippername;
	}
	public String getShippingmodel() {
		return shippingmodel;
	}
	public void setShippingmodel(String shippingmodel) {
		this.shippingmodel = shippingmodel;
	}
	public boolean isShowoceanfreight() {
		return showoceanfreight;
	}
	public void setShowoceanfreight(boolean showoceanfreight) {
		this.showoceanfreight = showoceanfreight;
	}
	public String getTempdefine() {
		return tempdefine;
	}
	public void setTempdefine(String tempdefine) {
		this.tempdefine = tempdefine;
	}
	public String getTradeterm() {
		return tradeterm;
	}
	public void setTradeterm(String tradeterm) {
		this.tradeterm = tradeterm;
	}
	public String getVesselname() {
		return vesselname;
	}
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public String getVslvoyid() {
		return vslvoyid;
	}
	public void setVslvoyid(String vslvoyid) {
		this.vslvoyid = vslvoyid;
	}
	public String getBookingparty() {
		return bookingparty;
	}
	public void setBookingparty(String bookingparty) {
		this.bookingparty = bookingparty;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public Map getCtns() {
		return ctns;
	}
	public void setCtns(Map ctns) {
		this.ctns = ctns;
	}
	@Override
	public String toString() {
		return "Booking[BL Nbr:"+blnumber+",BKG Party:"+bookingparty+"]";
	}
	
	
}
