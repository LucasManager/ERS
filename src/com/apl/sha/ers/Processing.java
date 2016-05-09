package com.apl.sha.ers;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Vector;

import java.sql.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import com.apl.sha.ers.db.DBProcess;
import com.apl.sha.ers.exception.BookingException;
import com.apl.sha.ers.exception.DataException;
import com.apl.sha.ers.exception.ErrCode;
import com.apl.sha.ers.exception.LoginException;
import com.apl.sha.ers.exception.NoDataException;
import com.apl.sha.ers.exception.NonUniqueDataException;
import com.apl.sha.ers.model.Booking;
import com.apl.sha.ers.model.BookingCtn;
import com.apl.sha.ers.model.BookingCtnGroup;
import com.apl.sha.ers.model.BookingReference;
import com.apl.sha.ers.model.Container;
import com.apl.sha.ers.model.CtnType;
import com.apl.sha.ers.model.Depot;
import com.apl.sha.ers.model.News;
import com.apl.sha.ers.model.OneWayCtn;
import com.apl.sha.ers.model.Paging;
import com.apl.sha.ers.model.User;
import com.apl.sha.ers.model.Vessel;
import com.apl.sha.ers.model.IvoyEvoyMap;
import com.apl.sha.ers.model.BlockCodeUpdate;
import com.apl.sha.ers.model.SVCNameMap;
import com.apl.sha.ers.util.BeanUtil;
import com.apl.sha.ers.util.DateUtil;
import com.apl.sha.ers.util.FileUtil;
import com.apl.sha.ers.util.Util;

public class Processing {
	private DBProcess db;
	public DBProcess getDb() {
		return db;
	}

	public void setDb(DBProcess db) {
		this.db = db;
	}
	
	public User getUser(String username, String pwd, boolean valid) throws LoginException {
		if(username.equalsIgnoreCase("guest")) {
			pwd="guest";
		}
		User user = db.getUser(username, pwd, valid);
		return user;
	}
	
	public User getUserForAdmin(String username, User optuser) throws LoginException {
		User user = db.getUserForAdmin(username, optuser);
		return user;
	}
	
	public List getUsers(){
		return db.getUsers(0);
	}
	public List getCtnID(int blnumber){
		List k = new LinkedList();
		k = db.getCtnID(blnumber);
		return k;
	}
	public User setUser(User user,User opsUser) throws DataException {
		Date date=new Date();
		user.setUpdatetime(new Date());
		if(user.getUserid()==0) {
			user.setCreatetime(date);
			db.addUser(user);
		}else {
			db.updateUser(user);
		}
		return user;
	}
	
	public int setUser(String username, int status){
		return db.updateUser(username,new Date(),status);
	}
	
	public void setCtnNBR(String ctnnbrstr, int ctnid, User user){
		db.updateCtnNBR(ctnnbrstr,ctnid);
	}
	public void setBookingInfo(String blockcode, int blnumber, User user){
		db.updateBookingInof(blnumber, blockcode, user.getLocation());
	}
	

	public Booking getBooking(int blnumber,Map ctnTypes,User user) throws NoDataException, BookingException {
		Booking booking=db.getBooking(blnumber);
		if (booking == null) {
			throw new NoDataException();
		}
		if(user.getUsergroup().getGroupid()==2) { //if client query, check booking party
			if(!booking.getBookingparty().equalsIgnoreCase(user.getBookingParty())) {
				throw new BookingException(ErrCode.notOwnerBookingCode);
			}
		}
		if(booking.getStatus().getPassedTime()==null){
			throw new BookingException(ErrCode.unPassedBookingCode);
		}
		List list = null;
		
		list=db.getBookingCtns(booking); 
		//判断当前Booking是否已经分配过堆场：若分配过堆场，则有数据；
		if(list==null || list.size()==0)
		{
//			该订单下查找未分配堆场的箱子
			list=db.getBookingCtnsNoDepot(booking); 
		}
		
		
		Map ctns=new LinkedHashMap();
		int i = 0;
		for(Iterator it=list.iterator();it.hasNext();) {
			BookingCtn ctn=(BookingCtn)it.next();
			CtnType ctnType=(CtnType)ctnTypes.get(ctn.getCtnCode());
			ctn.setCtnType(ctnType);
			ctn.setBlnumber(booking.getBlnumber());
			if(ctn.getId()==0)
			{
				i++;
				ctn.setId(i);
			}
			ctns.put(ctn.getId(), ctn);
		}
		booking.setCtns(ctns);
		return booking;
	}
	
	/**
	 * 根据blnumber分配堆场
	 * @param blnumber 
	 * @return 
	 */
	public boolean distributionDepot(int blnumber,User user)
	{
		return db.distributionDepot(blnumber,user);
	}
	
	public List<BookingReference> getBlByReferNo(String refereceNo) throws NoDataException
	{
		List<BookingReference> list = db.getBlByReferNo(refereceNo);
		if (list==null || list.size()==0)
		{
			throw new NoDataException(); 
		}
		return list;
	}
	
	
	public boolean delBooking(int blnumber, User user) {
		Date eventime=new Date();
		String bl = blnumber + "";
		
		db.setLog(user.getUserid(), "DelBookingAction", bl, eventime, "info", "", "delete booking");
		return db.delBooking(blnumber);
//		return true;
	}
	
	public void setBookingStatus(Booking booking,User user) {
		db.updateBookingStatus(booking.getStatus());
	}
	
	public List getBookings(Paging paging, int days, String vessel,String dest, User user) {
		int firstRow=paging.getFirstRow();
		int lastRow=paging.getLastRow();
//		String bookingParty=null;
		Date uploadDate=DateUtil.getDateBFToday(days);
		/*if(user.getUsergroup().getGroupid()==2) {
			bookingParty=user.getBookingParty();
		}*/		
		
		List bookings=db.getBookings(firstRow, lastRow,uploadDate,vessel,dest,user);
		if(bookings.size()>0) {
			List bkgCtns=db.getBookingCtns(bookings);
			int blnumber=0;
			Map ctns=null;
			Booking booking=null;
			int i=0;
			for(Iterator it=bkgCtns.iterator();it.hasNext();) {
				BookingCtn bkgCtn=(BookingCtn) it.next();
				if(bkgCtn.getBlnumber()!=blnumber) {
					if(booking!=null) {
						booking.setCtns(ctns);
						bookings.set(i, booking);
					}
					ctns=new TreeMap();
					blnumber=bkgCtn.getBlnumber();
					for(i=0;i<bookings.size();i++) {
						booking=(Booking)bookings.get(i);
						if(booking.getBlnumber()==blnumber) {
							break;
						}
					}
				}
				ctns.put(bkgCtn.getCtnCode(),bkgCtn);
			}
			booking.setCtns(ctns);
			bookings.set(i, booking);
		}
		return bookings;
	}
	
	public int getBookings(int days, String vessel, String dest, User user) {
		Date uploadDate=DateUtil.getDateBFToday(days);
		/*String bookingParty=null;
		if(user.getUsergroup().getGroupid()==2) {
			bookingParty=user.getBookingParty();
		}*/
		return db.getBookings(uploadDate,vessel,dest,user);
	}
	
	public List getBookingCtns(List bookings, User user) {
		if (bookings.size()>0) {
			return db.getBookingCtns(bookings);
		}
		return null;
	}
	
	public List getBookingCtnGroups(int days,String vessel, User user) {
		Date uploadDate=DateUtil.getDateBFToday(days);
		List list=db.getBookingCtnGroups(uploadDate,vessel,user);
		List rlist=new LinkedList();
		BookingCtnGroup bcg=new BookingCtnGroup();
		for(Iterator it=list.iterator();it.hasNext();) {
			BookingCtn bc=(BookingCtn)it.next();
			if(bcg.equals(bc)) {
			}else {
				if(bcg.getCtnQty()>0) {
					bcg.setBlnumbers(bcg.getBlnumbers().substring(1));
					rlist.add(BeanUtil.cloneBean(bcg));
				}
				bcg=new BookingCtnGroup();
				bcg.setDepotCode(bc.getDepotCode());
				bcg.setCtnCode(bc.getCtnCode());
				bcg.setStatus(bc.getStatus());
				bcg.setCtnQty(0);
				bcg.setBlnumbers("");
			}
			bcg.setCtnQty(bcg.getCtnQty()+bc.getCtnQty());
			bcg.setBlnumbers(bcg.getBlnumbers()+" <a href='getBookingCtn.do?blnumber="+Integer.toString(bc.getBlnumber())+"'>"+Integer.toString(bc.getBlnumber())+"</a>");
		}
		if(bcg.getCtnQty()>0) {
			bcg.setBlnumbers(bcg.getBlnumbers().substring(1));
			rlist.add(BeanUtil.cloneBean(bcg));
		}
		return rlist;
	}
	
	public void setBookingCtnsStatus(int[] ctnIDs,String ctnNbrs[], String newStatus, User user) throws DataException{
		String oldStatus="";
		Date pickupDate=null;
		if(newStatus.equals("P")) {
			oldStatus="R";
			pickupDate=new Date();
		}else if(newStatus.equals("R")) {
			oldStatus="P";
		}
		db.updateBookingCtnStatus(ctnIDs, ctnNbrs, oldStatus,newStatus, pickupDate);
	}
	
	public void setBookingCtns(Booking booking,Map newCtns, User user) throws DataException{
		db.updateBookingCtn(booking, newCtns, new Date());
	}
	
	public void setBookingCtnType(Booking booking,User user) {
		db.updateBookingCtnType(booking, new Date());
	}
	
	public void getBookingOrder(String template, String dest,int blnumber, String returnLink, Map ctnTypes, User user) throws NoDataException, BookingException {
		if(user.getUsergroup().getGroupid()==2) { //if client query, check booking party
			Booking booking=db.getBooking(blnumber);
			if(booking==null) {
				throw new NoDataException();
			}else if(!booking.getBookingparty().equalsIgnoreCase(user.getBookingParty())) {
				throw new BookingException(ErrCode.notOwnerBookingCode);
			}
		}
		db.getBookingOrder(template,dest, blnumber, returnLink);
		if(FileUtil.fileLength(dest)<=1024) {
			throw new NoDataException();
		}
	}
	public int checkBabyBooking(String blnumber){
		return db.checkBabyBooking(blnumber);
	}
	public void GetCtnRelease(String template, String dest,int blnumber, String cuser, User user) throws NoDataException, BookingException {
		String dusername;
		dusername = user.getUsername();
		Booking booking=db.getBooking(blnumber);
		if(user.getUsergroup().getGroupid()==3 || user.getUsergroup().getGroupid()==2) { //if client query, check booking party
			if(booking==null) {
				throw new NoDataException();
			}
			else if(!db.checkBookingDepot(blnumber, user.getUsername())) {
				throw new BookingException(ErrCode.notOwnerBookingCode);
			}
		}
		else {
			if(booking==null) {
				throw new NoDataException();
			}
			if(user.getUsergroup().getGroupid()==1) {
					dusername = "%";
			}
		}
		
		db.getCtnRelease(template,dest, blnumber, cuser, dusername);
		if(FileUtil.fileLength(dest)<=1024) {
			throw new NoDataException();
		}
	}

	public void GetCtnReleasev2(String template, String dest,int PrintID, String cuser) throws NoDataException{
		String templatetmp; 
		if ( db.checklengthofvlname(PrintID) > 18){
			templatetmp = template+"\\C_R_ORDER_v3.jasper";
			db.getCtnReleasev2(templatetmp,dest, PrintID, cuser);
		}
		else{
			templatetmp = template+"\\C_R_ORDER_v2.jasper";
			db.getCtnReleasev2(templatetmp,dest, PrintID, cuser);
		}
		
		if(FileUtil.fileLength(dest)<=1024) {
			throw new NoDataException();
		}
	}
	
	public Depot getDepot(String depotcode,Map ctnTypes, User user) throws NoDataException {
		Depot depot=db.getDepot(depotcode, user.getLocation());
		if (depot == null) {
			throw new NoDataException();
		}
		List list=db.getDepotCtns(depot);
		depot.setContainers(this.arrangeContainer(list, ctnTypes));
		return depot;
	}
	
	public void setDepot(Depot depot,User user) throws DataException{
		if(depot.getId()==0) {
			db.addDepot(depot);
		}else {
			db.updateDepot(depot);
		}
	}
	
	public void setDepotCtns(Depot depot,User user) throws DataException{
		db.updateDepotCtn(depot, new Date(), user);
	}
	
	public int setOverdueCtn(String vessel, String voyage, User user) {
		return db.updateVesselCtnStatus(vessel, voyage, user.getLocation());
	}
	public int setCtnStatusforAmend(int blnumber,User user) {
		int updateresult;
		updateresult = db.updateCtnStatusToR(blnumber, user.getLocation());
		updateresult = updateresult + db.updateCtnStatusToP(blnumber, user.getLocation());
		return updateresult;
	}
	public Map getDepots(String location) throws DataException {
		List list=db.getDepots(location);
//		List list=db.getDepotCtns(depot);
//		depot.setContainers(this.arrangeContainer(list, ctnTypes));
		Map map;
		try {
			map = Util.convertToMap(list, "depotcode", Depot.class);
		} catch (Exception e) {
			throw new DataException();
		}
		return map;
	}
	
	public Map getDepots(Booking booking,Map depots) {
		Map ctns=booking.getCtns();
		Map map=new TreeMap();
		for(Iterator it=ctns.entrySet().iterator();it.hasNext();) {
			BookingCtn bkgCtn=(BookingCtn)((Entry)it.next()).getValue();
			String depotCode = bkgCtn.getDepotCode();
			if(depotCode!=null && (!depotCode.equals("")))
			{
				map.put(bkgCtn.getDepotCode(),depots.get(bkgCtn.getDepotCode()));
			}
		}
		return map;
	}
	
	public List getDepotsCtns(User user) throws DataException {
		List list=db.getDepotsCtns(user.getLocation());
		return list;
	}
	
	public List getPendingCtn(User user, Date begDate, Date endDate) throws NoDataException {
		List list=db.getPendingCtn(user.getLocation(), begDate, endDate);
		
		if (list == null || list.size() == 0) {
			throw new NoDataException();
		}
		
		return list;
	}
	
	public List getBookingDesc(int blnumber){
		List list=db.getBookingDesc(blnumber);
		return list;
	}
	public String getBookingPReason(int p_id){
		return db.getBookingPReason(p_id);
	}
	public Map getNewses(User user) {
		List list=db.getNewses(user,false);
		Map map=null;
		try {
			map = Util.convertToMap(list, "id", News.class);
		} catch (Exception e) {
		}
		return map;
	}
	
	public List getNewses() {
		List list=db.getNewses();
		return list;
	}
	
	public void setNews(News news,User user) {
		news.setUpdateTime(new Date());
		news.setUpdateUser(user.getUserid());
		db.addNews(news);
	}
	
	public void delNews(int id) {
		db.deleteNews(id);
	}
	
	public Map getBulletins(User user) {
		List list=db.getNewses(user,true);
		Map map=null;
		try {
			map = Util.convertToMap(list, "id", News.class);
		} catch (Exception e) {
		}
		return map;
	}
	
	public List getLogs(Date begDate,Date endDate,String type,String function,int userID,User user) {
		List list=db.getLogs(begDate, endDate, type, function, userID);
		return list;
	}
	
	public void purgeFolder(String folderPath) {
		FileUtil.delExpiredFiles(folderPath, 30, ".html");
	}
	
	public Map getCtnTypes() {
		Map map=null;
		List list=db.getCtnTypes();
		try {
			map = Util.convertToMap(list, "intlCode", CtnType.class);
		} catch (Exception e) {
		}
		return map;
	}
	
	public List getVessels() {
		return db.getVessels();
	}
	public Vector getCtnList(String Location,String vslCD,String DepotCode,Date begDate,Date endDate) {
		return db.getCtnList(Location,vslCD,DepotCode,begDate,endDate);
	}
	public void setVessel(Vessel vessl, User user) {
		if(db.updateVessel(vessl)==0) {
			db.addVessel(vessl);
		}
	}
	public int setVslVoyByBlnumber(int blnumber, String vslcd, String voyid, User user) {
		return db.updateVslVoyByBlnumber(blnumber, vslcd, voyid);
	}
	public int checkVessel(String vslcd) {
		return db.checkVessel(vslcd);
	}
	public List getOneWayCtns(OneWayCtn owc,User user) {
		return db.getOneWayCtns(owc);
	}
	
	public List getIvoyEvoyMap() {
		return db.getIvoyEvoyMap();
	}
	
	public List getSVCNameMap() {
		return db.getSVCNameMap();
	}
	
	public List getBlockCodeUpdate() {
		return db.getBlockCodeUpdate();
	}
	
	public void setIvoyEvoyMap(IvoyEvoyMap iem, int vdel_flag, User user){
		if(vdel_flag==1) {
			db.disableIvoyEvoyMap(iem.getV_id());
		}else {
			db.updateIvoyEvoyMap(iem);
		}		
	}
	
	public void setBlockCodeUpdate(BlockCodeUpdate bcu, int bdel_flag, User user){
		if(bdel_flag==1) {
			db.disableBlockCodeUpdate(bcu.getId());
		}else {
			db.updateBlockCodeUpdate(bcu);
		}	
	}
	public void setSVCNameMap(SVCNameMap stp, int bdel_flag, User user){
		if(bdel_flag==1) {
			db.disableSVCNameMap(stp);
		}else {
			db.updateSVCNameMap(stp);
		}		
		
	}
	
	public void setOneWayCtns(OneWayCtn owc, User user) throws NonUniqueDataException {
		if(owc.getId()==0) {
			db.addOneWayCtn(owc);
		}else {
			db.updateOneWayCtn(owc);
		}
	}
	
	private Map arrangeContainer(List ctns, Map ctnTypes) {
		Map map=new TreeMap();
		for(Iterator it=ctns.iterator();it.hasNext();) {
			Container ctn=(Container)it.next();
			CtnType ctnType=(CtnType)ctnTypes.get(ctn.getCtnCode());
			ctn.setCtnType(ctnType);
			map.put(ctn.getCtnCode(), ctn);
		}
		return map;
	}
	
	public String getBookingSVCName(int blnumber) {
		return db.checkHotStow(blnumber);
	}
	
//	public static void main(String[] args) {
//		try {
//			JasperCompileManager.compileReportToFile("C:/apache-tomcat-6.0.44/webapps/ERS/report/bookingOrder.jrxml", 
//			        "C:/apache-tomcat-6.0.44/bookingOrder.jasper");
//		} catch (JRException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
}
