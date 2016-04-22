package com.apl.sha.ers.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultReader;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.apl.sha.ers.exception.DataException;
import com.apl.sha.ers.exception.LoginException;
import com.apl.sha.ers.exception.NonUniqueDataException;
import com.apl.sha.ers.model.*;
import com.apl.sha.ers.util.BizUtil;
import com.apl.sha.ers.util.Util;

public class DBProcess {
	/*
	 * private static DBProcess dbProcess=new DBProcess();
	 * 
	 * private DBProcess() { }
	 * 
	 * public synchronized static DBProcess getInstance() { return dbProcess; }
	 */
	/*
	 * private static DataSource dataSource;
	 * 
	 * private static Connection getConnection() { Connection conn = null; try {
	 * conn = dataSource.getConnection(); conn.setAutoCommit(false); } catch
	 * (SQLException sqle) { sqle.printStackTrace(); } return conn; }
	 */

	private static JdbcTemplate jdbc;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public User getUser(String username, String pwd, boolean valid) throws LoginException {
		String sql = "SELECT a.userid, a.firstname, a.lastname, a.username, a.pwd, a.title,\n"
				+ "a.email, a.Issys,a.status, a.createtime, a.updatetime, b.groupid AS usergroupid,\n"
				+ "b.groupname AS usergroupname, b.comments AS usergroupcomments, c.location, c.locale,\n"
				+ "c.bookingparty, c.depot \n"
				+ " FROM users a, Usergroups b, user_profiles c\n"
				+ "WHERE a.usergroupid=b.groupid and a.userid=c.userid\n"
				+ "and a.username=? ";
		Object[] params = new Object[] { username};
		SqlRowSet rs = jdbc.queryForRowSet(sql, params);
		User user = null;
		UserGroup usergroup;
		while (rs.next()) {
			user = new User();
			usergroup = new UserGroup();
			user = (User) ORMapperFactory.mapping(rs, rs.getRow(), user);
			usergroup = (UserGroup) ORMapperFactory.mappingUserGroup(rs, rs
					.getRow(), usergroup);
			user.setUsergroup(usergroup);
			user.setPrivs(getUserPrivs(user)); // set privs
		}
		if(user==null) {
			throw new LoginException(-1);
		}
		if(!valid) {
			return user;
		}
		if(user.getStatus()!=0) {
			throw new LoginException(user.getStatus());
		}
		if(!user.getPwd().equals(pwd)) {
			throw new LoginException(-2);
		}
		return user;
		/*
		 * String sql="select * from users where username=? and pwd=?"; Object[]
		 * params=new Object[] {username,pwd}; RowMapperResultReader rmr=new
		 * RowMapperResultReader(new UserRowMapper()); List list=
		 * jdbc.query(sql, params,rmr); if(list.size()<=0) { return null; }
		 * return (User)list.get(0);
		 */
	}

	public User getUserForAdmin(String username, User optuser) throws LoginException {
		String sql = "SELECT a.userid, a.firstname, a.lastname, a.username, a.pwd, a.title,\n"
				+ "a.email, a.Issys,a.status, a.createtime, a.updatetime, b.groupid AS usergroupid,\n"
				+ "b.groupname AS usergroupname, b.comments AS usergroupcomments, c.location, c.locale,\n"
				+ "c.bookingparty, c.depot \n"
				+ " FROM users a, Usergroups b, user_profiles c\n"
				+ "WHERE a.usergroupid=b.groupid and a.userid=c.userid\n"
				+ "and a.username=? and c.location=? ";
		Object[] params = new Object[] { username, optuser.getLocation()};
		SqlRowSet rs = jdbc.queryForRowSet(sql, params);
		User user = null;
		UserGroup usergroup;
		while (rs.next()) {
			user = new User();
			usergroup = new UserGroup();
			user = (User) ORMapperFactory.mapping(rs, rs.getRow(), user);
			usergroup = (UserGroup) ORMapperFactory.mappingUserGroup(rs, rs
					.getRow(), usergroup);
			user.setUsergroup(usergroup);
			user.setPrivs(getUserPrivs(user)); // set privs
		}
		if(user==null) {
			throw new LoginException(-1);
		}

		return user;
	}
	
	public List getUsers(int status) {
		String sql="SELECT a.userid, a.firstname, a.lastname, a.username, a.pwd, a.title,\n"
			+ "a.email, a.Issys,a.status, a.createtime, a.updatetime, b.groupid AS usergroupid,\n"
			+ "b.groupname AS usergroupname, b.comments as usergroupcomments, c.location, c.locale,\n"
			+ "c.bookingparty, c.depot \n"
			+ " FROM users a, Usergroups b, user_profiles c\n"
			+ "WHERE a.usergroupid=b.groupid and a.userid=c.userid\n"
			+ "and a.status=?\n"
			+ " Order by a.username\n";
		Object[] params = new Object[] { status };
		SqlRowSet rs = jdbc.queryForRowSet(sql, params);
		User user = null;
		UserGroup usergroup;
		List list=new LinkedList();
		while (rs.next()) {
			user = new User();
			usergroup = new UserGroup();
			user = (User) ORMapperFactory.mapping(rs, rs.getRow(), user);
			usergroup = (UserGroup) ORMapperFactory.mappingUserGroup(rs, rs
					.getRow(), usergroup);
			user.setUsergroup(usergroup);
			list.add(user);
		}
		return list;
	}
	
	public List getCtnID(int blnumber) {
		String sql=" select to_char(id) as ctnid  from ctn_dist where blnumber=? ";
		Object[] params = new Object[] { blnumber };
		SqlRowSet rs = jdbc.queryForRowSet(sql, params);
		List list=new LinkedList();
		String ctnid;
		while (rs.next()) {
			System.out.println(rs.getString("ctnid"));
			ctnid = rs.getString("ctnid");
			
			list.add(ctnid);
		}
		System.out.print(list);
		return list;
	}
	
	
	public void updateUser(User user) {
		String sql = "";
		if(user.getPwd().equalsIgnoreCase("*#apluser657")){
			sql="UPDATE USERS\n" +
				"   SET FIRSTNAME = ?, LASTNAME = ?,\n" + 
				"       USERNAME = ?, \n" + 
				"       USERGROUPID = ?, EMAIL = ?, \n" + 
				"       status = ?, UPDATETIME = ?\n" + 
				" WHERE USERID = ?";
			Object[] params2 = new Object[] {user.getFirstname(),user.getLastname(),user.getUsername(),user.getUsergroup().getGroupid(),user.getEmail(),user.getStatus(),
					user.getUpdatetime(),user.getUserid()};
			jdbc.update(sql, params2);
		}else{
			sql=
				"UPDATE USERS\n" +
				"   SET FIRSTNAME = ?, LASTNAME = ?,\n" + 
				"       USERNAME = ?, PWD = ?,\n" + 
				"       USERGROUPID = ?, EMAIL = ?, \n" + 
				"       status = ?, UPDATETIME = ?\n" + 
				" WHERE USERID = ?";
			Object[] params2 = new Object[] {user.getFirstname(),user.getLastname(),user.getUsername(),user.getPwd(),user.getUsergroup().getGroupid(),user.getEmail(),user.getStatus(),
					user.getUpdatetime(),user.getUserid()};
			jdbc.update(sql, params2);
		}
		
		sql=

			"UPDATE USER_PROFILES\n" +
			"   SET LOCATION = ?, LOCALE = ?, BOOKINGPARTY=?, DEPOT=? \n" + 
			" WHERE USERID = ?";
		Object[] params = new Object[] {user.getLocation(),user.getLocale(),user.getBookingParty(), user.getDepot(), user.getUserid()};
		int[] paramTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR ,
				Types.INTEGER };
		jdbc.update(sql, params,paramTypes);
	}
	
	public int updateUser(String username, Date updateTime, int status) {
		String sql=
			"UPDATE USERS\n" +
			"   SET status = ?, UPDATETIME = ?\n" + 
			" WHERE USERNAME = ?";
		Object[] params = new Object[] {status, updateTime, username};
		return jdbc.update(sql, params);
	}
	
	public void addUser(User user) {
		int userid=jdbc.queryForInt("SELECT MAX(USERID)+1 FROM USERS");
		String sql=
			"INSERT INTO USERS\n" +
			"  (USERID, FIRSTNAME, LASTNAME, USERNAME, PWD, TITLE, USERGROUPID, EMAIL,\n" + 
			"   STATUS, CREATETIME, UPDATETIME)\n" + 
			"VALUES\n" + 
			"  (?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {userid,user.getFirstname(),user.getLastname(),user.getUsername(),user.getPwd(),
				user.getTitle(), user.getUsergroup().getGroupid(),user.getEmail(),user.getStatus(),user.getUpdatetime(),
				user.getUpdatetime()};
		jdbc.update(sql, params);
		sql=
			"INSERT INTO USER_PROFILES\n" +
			"  (USERID, LOCATION, LOCALE, BOOKINGPARTY, DEPOT)\n" + 
			"VALUES\n" + 
			"  (?,?,?,?,?)\n" + 
			"";
		params = new Object[] {userid,user.getLocation(),user.getLocale(),user.getBookingParty(), user.getDepot()};
		int[] paramTypes = new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR 
				 };
		jdbc.update(sql, params,paramTypes);
	}
	
	private Privs getUserPrivs(User user) {
		String sql = 
				"SELECT b.privid as privid,b.priv ,a.param, b.comments FROM (\n"
				+ "  SELECT GPID, PRIVID, PARAM,  0 AS isuser FROM GROUP_PRIVS\n"
				+ "  WHERE groupid=?\n"
				+ "  UNION ALL\n"
				+ "  SELECT UPID, PRIvID, PARAM, 1 AS isuser FROM USER_PRIVS\n"
				+ "  WHERE userid=?\n"
				+ ") a JOIN PRIVS b ON a.privid=b.privid\n"
				+ "ORDER BY a.isuser";
		Object[] params = new Object[] { user.getUsergroup().getGroupid(),
				user.getUserid() };
		RowMapperResultReader rmr = new RowMapperResultReader(
				new RowMapperImpl(Priv.class));
		List list = jdbc.query(sql, params, rmr);
		Privs privs = new Privs(list);
		return privs;
	}

	/*
	 * public Map getUsers(Long empgroupid) { String sql= "SELECT a.userid,
	 * a.firstname, a.lastname, a.username, a.pwd, a.title,\n" + "a.email,
	 * a.Issys,a.Isdel, a.createtime, a.updatetime, b.groupid AS usergroupid,\n" +
	 * "b.groupname AS usergroupname, b.comments AS usergroupcomments, c.groupid
	 * AS empgroupid,\n" + "c.group_name AS empgroupname, c.comments AS
	 * empgroupcomments, c.p_groupid, c.loc, c.loc1 as loc_bak \n"+ " FROM USERS
	 * a\n" + " JOIN Usergroups b ON a.Usergroupid=b.groupid\n" + " JOIN (SELECT
	 * groupid, group_name, comments, p_groupid, loc, loc1 " + " FROM empgroups
	 * START WITH groupid=? CONNECT BY PRIOR groupid=p_groupid) c\n" + " ON
	 * a.empgroupid=c.groupid\n" + " Where a.isdel=0 "; Object[] params=new
	 * Object[] {empgroupid}; SqlRowSet rs = jdbc.queryForRowSet(sql, params);
	 * Map map=new HashMap(); while (rs.next()) { User user = new User();
	 * EmpGroup empgroup = new EmpGroup(); UserGroup usergroup = new
	 * UserGroup(); user = (User) ORMapperFactory.mapping(rs, rs.getRow(),
	 * user); empgroup = (EmpGroup) ORMapperFactory.mappingEmpGroup(rs, rs
	 * .getRow(), empgroup); usergroup = (UserGroup)
	 * ORMapperFactory.mappingUserGroup(rs, rs .getRow(), usergroup);
	 * user.setEmpgroup(empgroup); user.setUsergroup(usergroup);
	 * user.setPrivs(getUserPrivs(user)); // set privs map.put(user.getUserid(),
	 * user); } return map; }
	 */

	public Booking getBooking(int blnumber) {
		String sql = 
			"SELECT r1.ID, r1.blnumber, \n " +
			"       DECODE (r1.hot_stow, \n " +
			"               'Y', NVL (b1.block_code, r1.blockcode), \n " +
			"               r1.blockcode \n " +
			"              ) AS blockcode, \n " +
			"       r1.referenceno, r1.bookingparty, r1.accountcode, r1.shippercode, \n " +
			"       r1.shipper, r1.shippername, r1.consigneecode, r1.consignee, \n " +
			"       r1.consigneename, r1.notifypartycode, r1.notifypartyname, \n " +
			"       r1.alsonotifypartycode, r1.alsonotifypartyname1, \n " +
			"       r1.alsonotifypartyname2, r1.commodity, r1.descriptionofgoods, r1.marks, \n " +
			"       r1.placeofreceiptcode, r1.placeofreceipt, r1.portofloadingcode, \n " +
			"       r1.portofloading, r1.portofdischargecode, r1.portofdischarge, \n " +
			"       r1.placeofdeliverycode, r1.placeofdelivery, r1.vslvoyid, r1.vesselname, \n " +
			"       r1.voyage, r1.onboarddate, r1.cargomodel, r1.shippingmodel, \n " +
			"       r1.seawaybill, r1.expressbill, r1.showoceanfreight, r1.prepaidcollect, \n " +
			"       r1.tradeterm, r1.PACKAGES, r1.kindofpackages, r1.descriptionofpackages, \n " +
			"       r1.grossweight, r1.measurement, r1.packagesofcartons, r1.kindofcartons, \n " +
			"       r1.messageconfirmdate, r1.bookingupload, r1.readyupload, r1.tempdefine, \n " +
			"       r1.settemp, r1.maxtemp, r1.mintemp, r1.airrate \n " +
			"  FROM (SELECT b.ID, b.blnumber, b.blockcode, b.referenceno, b.bookingparty, \n " +
			"               b.accountcode, b.shippercode, b.shipper, b.shippername, \n " +
			"               b.consigneecode, b.consignee, b.consigneename, \n " +
			"               b.notifypartycode, b.notifypartyname, b.alsonotifypartycode, \n " +
			"               b.alsonotifypartyname1, b.alsonotifypartyname2, b.commodity, \n " +
			"               b.descriptionofgoods, b.marks, b.placeofreceiptcode, \n " +
			"               b.placeofreceipt, b.portofloadingcode, b.portofloading, \n " +
			"               b.portofdischargecode, b.portofdischarge, \n " +
			"               b.placeofdeliverycode, b.placeofdelivery, \n " +
			"               NVL (m.rvslvoyid, b.vslvoyid) AS vslvoyid, \n " +
			"               v.NAME AS vesselname, b.voyage, b.onboarddate, b.cargomodel, \n " +
			"               b.shippingmodel, b.seawaybill, b.expressbill, \n " +
			"               b.showoceanfreight, b.prepaidcollect, b.tradeterm, b.PACKAGES, \n " +
			"               b.kindofpackages, b.descriptionofpackages, b.grossweight, \n " +
			"               b.measurement, b.packagesofcartons, b.kindofcartons, \n " +
			"               b.messageconfirmdate, b.bookingupload, b.readyupload, \n " +
			"               b.tempdefine, b.settemp, b.maxtemp, b.mintemp, b.airrate, \n " +
			"               b.hot_stow, v.svcname \n " +
			"          FROM (SELECT v.vslcd || ' ' || v.external_voyid AS rvslvoyid, \n " +
			"                       v.vslcd || ' ' || v.internal_voyid AS vslvoyid \n " +
			"                  FROM vslcd_ivoy_evoy v \n " +
			"                 WHERE v.status = 'Y') m, \n " +
			"               vessel v, \n " +
			"               booking b \n " +
			"         WHERE b.blnumber = ? \n " +
			"           AND b.vslvoyid = m.vslvoyid(+) \n " +
			"           AND SUBSTR (b.vslvoyid, 1, 3) = v.ID(+)) r1, \n " +
			"       (SELECT svcname, portofloadingcode, block_code \n " +
			"          FROM block_code_update \n " +
			"         WHERE block_code_update.status = 'Y') b1 \n " +
			" WHERE r1.svcname = b1.svcname(+) AND r1.portofloadingcode = b1.portofloadingcode(+)";
//		System.out.print(sql);
		Object[] params = new Object[] { blnumber };
		Booking booking=null;
		try {
			booking = (Booking) jdbc.queryForObject(sql, params,
					new RowMapperImpl(Booking.class));
		} catch (IncorrectResultSizeDataAccessException e) {
		}
		if(booking!=null) {
			sql="SELECT ID, BLNUMBER, RECEIVETIME, CREATETIME, UPLOADTIME, PASSEDTIME,\n" +
				"       SENDRACTIME, REMARK, sremark\n" + 
				"  FROM BOOKINGSTATUS\n" +
				"  WHERE blnumber=? ";
			params=new Object[] {booking.getBlnumber()};
			booking.setStatus((BookingStatus)jdbc.queryForObject(sql, params, new RowMapperImpl(BookingStatus.class)));
		}
		return booking;
	}
	
	public boolean delBooking(int blnumber) {
		Object[] params = new Object[] {blnumber};
		String sql="DELETE BOOKINGSTATUS WHERE blnumber=?";
		if(jdbc.update(sql, params)<=0) {
			return false;
		}
		sql="DELETE CONTAINER WHERE blnumber=?";
		jdbc.update(sql, params);
		sql="DELETE CTN_DIST WHERE blnumber=?";
		jdbc.update(sql, params);
		sql="DELETE BOOKING WHERE blnumber=?";
		jdbc.update(sql, params);
		return true;
	}
	
	public void updateBookingStatus(BookingStatus status) {
		String sql=

			"UPDATE BOOKINGSTATUS\n" +
			"   SET REMARK =?, sremark =?\n" + 
			" WHERE blnumber = ?";
		Object[] params = new Object[] {status.getRemark(),status.getSremark(), status.getBlnumber()};
		jdbc.update(sql, params);
	}
	public void updateCtnNBR(String ctnnbrstr, int ctnid) {
		String sql="update ctn_dist set ctn_dist.ctnnbr = substr(?, 1, 12) where ctn_dist.id=?";
		Object[] params = new Object[] {ctnnbrstr, ctnid};
		jdbc.update(sql, params);
	}
	
	public List getBookings(int firstRow,int lastRow,Date uploadDate, String vessel,String dest, User user) {
		Object[] params = new Object[] { uploadDate,user.getLocation(), lastRow,firstRow };
		String whereClause="";
		if(!vessel.equalsIgnoreCase("allVsl")) {
			whereClause=whereClause+"AND substr(a.vslvoyid,1,3)=?\n";
			params=Util.addElement(params, vessel,1 );
		}
		if(dest.length()==3) {
			whereClause="AND a.placeofdeliverycode=?\n"+whereClause;
			params=Util.addElement(params, dest,1 );
		}
		if(user.getBookingParty()!=null) {
			whereClause="AND a.bookingParty=?\n"+whereClause;
			params=Util.addElement(params, user.getBookingParty(), 1);
		}
		String sql =
/*			" SELECT * FROM (\n" +
			" SELECT ROWNUM AS rn, a.*\n" + 
			"  FROM\n" + 
			" (SELECT blnumber, DECODE (a.hot_stow,'Y', DECODE (u.vslvoyid, NULL, a.blockcode, u.block_code), a.blockcode) AS blockcode, a.vesselname, a.voyage, a.receivetime, a.uploadtime, a.passedtime \n" +
			" FROM (SELECT c.vslcd || ' ' || c.voyage AS vslvoyid, c.portofloadingcode, c.block_code FROM block_code_update c WHERE c.status = 'Y') u, bookingall a, port b \n" +
			" WHERE a.uploadTime>=?\n" + whereClause +
			" and b.location=? and a.vslvoyid = u.vslvoyid(+) AND a.portofloadingcode = u.portofloadingcode(+) AND a.portofloadingcode=b.portcode\n" +
			" ORDER BY a.uploadtime DESC) a\n" + 
			" WHERE ROWNUM<=?\n" + 
			" )\n" + 
			" WHERE  Rn>=?";*/
			"SELECT * \n " +
			"  FROM (SELECT ROWNUM AS rn, a.* \n " +
			"          FROM (SELECT   r1.blnumber, \n " +
			"                         DECODE (r1.hot_stow, \n " +
			"                                 'Y', NVL (b1.block_code, r1.blockcode), \n " +
			"                                 r1.blockcode \n " +
			"                                ) AS blockcode, \n " +
			"                         r1.vesselname, r1.voyage, r1.receivetime, \n " +
			"                         r1.uploadtime, r1.passedtime \n " +
			"                    FROM (SELECT a.blnumber, a.blockcode, a.vesselname, \n " +
			"                                 a.voyage, a.receivetime, a.uploadtime, \n " +
			"                                 a.passedtime, a.portofloadingcode, \n " +
			"                                 a.hot_stow, v.svcname \n " +
			"                            FROM bookingall a, port b, vessel v \n " +
			"                           WHERE a.uploadtime >= ? \n " + whereClause +
			"                             AND b.LOCATION = ? \n " +
			"                             AND a.portofloadingcode = b.portcode \n " +
			"                             AND SUBSTR (a.vslvoyid, 1, 3) = v.ID(+)) r1, \n " +
			"                         (SELECT svcname, portofloadingcode, block_code \n " +
			"                            FROM block_code_update \n " +
			"                           WHERE block_code_update.status = 'Y') b1 \n " +
			"                   WHERE r1.svcname = b1.svcname(+) \n " +
			"                         AND r1.portofloadingcode = b1.portofloadingcode(+) \n " +
			"                ORDER BY r1.uploadtime DESC) a \n " +
			"         WHERE ROWNUM <= ?) \n " +
			" WHERE rn >= ?";
		List list=null;
		list=jdbc.query(sql,params,new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Booking booking=new Booking();
				booking.setBlnumber(rs.getInt("blnumber"));
				booking.setBlockcode(rs.getString("blockcode"));
				booking.setVesselname(rs.getString("vesselname"));
				booking.setVoyage(rs.getString("voyage"));
				BookingStatus bookingStatus=new BookingStatus();
				bookingStatus.setReceiveTime(rs.getTimestamp("receivetime"));
				bookingStatus.setUploadTime(rs.getTimestamp("uploadtime"));
				bookingStatus.setPassedTime(rs.getTimestamp("passedtime"));
				booking.setStatus(bookingStatus);
				return booking;
				}
			}
		);
		return list;
	}
	public int checkVessel(String vslcd){
		String sql =
			"SELECT count(1) from vessel where vessel.id = ? ";
		Object[] params=new Object[] {vslcd};
		int[] argTypes=new int[] {Types.VARCHAR};
		return jdbc.queryForInt(sql, params, argTypes);
	}
	public int getBookings(Date uploadDate, String vessel,String dest, User user) {
		Object[] params = new Object[] {uploadDate,user.getLocation()};
		String whereClause="";
		if(!vessel.equalsIgnoreCase("allVsl")) {
			whereClause=whereClause+"AND substr(vslvoyid,1,3)=?\n";
			params=Util.addElement(params, vessel,2 );
		}
		if(dest.length()==3) {
			whereClause="AND a.placeofdeliverycode=?\n"+whereClause;
			params=Util.addElement(params, dest,2 );
		}
		if(user.getBookingParty()!=null) {
			whereClause="AND a.bookingParty=?\n"+whereClause;
			params=Util.addElement(params, user.getBookingParty(), 2);
		}
		String sql =
			"SELECT count(1)\n" +
			"FROM bookingall a, port b\n" +
			"WHERE a.uploadTime>=?\n" +
			"AND a.portofloadingcode=b.portcode and b.location=?\n" 
			+whereClause;
		return jdbc.queryForInt(sql, params);
	}
	
	public void getBookingOrder(String template,String dest,int blnumber,String returnLink) {
		Map params=new HashMap();
		params.put("blnumber", blnumber);
		params.put("SUBREPORT_DIR", template+"\\");
		params.put("returnLink", returnLink);
		Connection conn=null;
		try {
			conn=jdbc.getDataSource().getConnection();
		} catch (SQLException e) {
		}
		try {
			JasperRunManager.runReportToHtmlFile(template+"\\bookingOrder.jasper", dest, params, conn);
		} catch (JRException e) {
			e.printStackTrace();
		}
		try {
			conn.commit();
		} catch (SQLException e) {
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public void getCtnRelease(String template,String dest,int blnumber,String cuser, String dusername) {
		Map params=new HashMap();
		params.put("blnumber", blnumber);
		params.put("SUBREPORT_DIR", template+"\\");
		params.put("cuser", cuser);
		params.put("dusername", dusername);
		//System.out.println(dusername);
		Connection conn=null;
		try {
			conn=jdbc.getDataSource().getConnection();
		} catch (SQLException e) {
		}
		try {
			JasperRunManager.runReportToHtmlFile(template+"\\C_R_ORDER.jasper", dest, params, conn);
		} catch (JRException e) {
			e.printStackTrace();
		}
		try {
			conn.commit();
		} catch (SQLException e) {
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public void getCtnReleasev2(String template,String dest,int PrintID,String cuser) {
		Map params=new HashMap();
		params.put("ctnid", PrintID);
		params.put("SUBREPORT_DIR", template+"\\");
		params.put("cuser", cuser);
		//System.out.println(dusername);
		Connection conn=null;
		try {
			conn=jdbc.getDataSource().getConnection();
		} catch (SQLException e) {
		}
		try {
			JasperRunManager.runReportToHtmlFile(template, dest, params, conn);
		} catch (JRException e) {
			e.printStackTrace();
		}
		try {
			conn.commit();
		} catch (SQLException e) {
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}	
	/**
	 * 已分配箱子
	 * @param booking
	 * @return
	 */
	public List getBookingCtns(Booking booking) {
		//use for container table
		/*String sql=
			"SELECT ID, BLNUMBER, CTNQTY, CTNCODE, CTNSTATUS, MASTERBLNUMBER, CTNSOC,\n" +
			"       DEPOTCODE, STATUS, RESERVEDATE, PICKUPDATE\n" + 
			"  FROM CONTAINER\n" + 
			"WHERE blnumber=?";*/
		String sql=
			"SELECT a.ID, a.BLNUMBER, a.CTNCODE, a.INTLCODE, a.CTNQTY, a.DEPOTCODE,\n" +
			"b.cname AS depotCname, a.STATUS,\n" + 
			"a.RESERVEDATE, a.PICKUPDATE, a.CTNNBR\n" + 
			"FROM CTN_DIST a, depot b\n" + 
			"Where a.depotcode = b.depotcode\n" + 
			"AND blnumber=?\n" +
			"Order by a.depotcode,a.ctncode, a.status";
		Object[] params = new Object[] {booking.getBlnumber()};
		List list=jdbc.query(sql,params,new RowMapperImpl(BookingCtn.class));
		return list;
	}
	
	/**
	 * 查找该订单下未分配堆场的箱子
	 * @param booking
	 * @return
	 */
	public List getBookingCtnsNoDepot(Booking booking) {
		//use for container table
		/*String sql=
			"SELECT ID, BLNUMBER, CTNQTY, CTNCODE, CTNSTATUS, MASTERBLNUMBER, CTNSOC,\n" +
			"       DEPOTCODE, STATUS, RESERVEDATE, PICKUPDATE\n" + 
			"  FROM CONTAINER\n" + 
			"WHERE blnumber=?";*/
		//String sql="select t.ctncode,count(t.ctncode) as numbers from container t where t.blnumber =? group by t.ctncode";
		String sql="select t.ctncode,sum(t.ctnqty) as numbers from container t where t.blnumber =? group by t.ctncode";
		Object[] params = new Object[] {booking.getBlnumber()};
		List list=jdbc.query(sql,params,new RowMapperImpl(BookingCtnNoDepot.class));
		List relist = new ArrayList();
		for (Object object : list) {
			BookingCtnNoDepot ctnNoDepot = (BookingCtnNoDepot) object;
			//no display 0 ctn number
			if(ctnNoDepot!=null && ctnNoDepot.getNumbers()!=0)
			{
				relist.add(ctnNoDepot);
			}
		}
		return relist;
	}
	
	/**
	 * allocation depot by blnumber;
	 * @param blnumber
	 * @return
	 */
	public boolean distributionDepot(int blnumber,User user)
	{
		String bookSql = null;
		String  prodsql = null;
		Object[] params = new Object[] {blnumber};
		//get HSN booking 
		bookSql = "select p.location as location from booking b,port p where b.portofloadingcode = p.portcode and (p.location = 'HSN' or p.location='TSI') and b.blnumber = ?";
		List queryForList = jdbc.queryForList(bookSql, params);
		//it is HSN booking
		if(queryForList!=null && queryForList.size()!=0)
		{
			Map object = (Map) queryForList.get(0);
			String location = (String) object.get("location");
			if("HSN".equals(location))
			{
				prodsql = "{call alloc_ctn_qty_hsn_byblnumber(?)}";
			}else {
				prodsql = "{call alloc_ctn_qty_tsi_byblnumber(?)}";
			}
			
		}else {
			prodsql = "{call alloc_ctn_qty_byblnumber(?)}";
		}
		boolean result = false;
		Connection conn = null;
		CallableStatement prepareCall=null;
		try {
			DataSource dataSource = jdbc.getDataSource();
			conn = dataSource.getConnection();
			prepareCall = conn.prepareCall(prodsql);
			prepareCall.setInt(1, blnumber);
			prepareCall.execute();
			result = true;
			setLog(user.getUserid(), "DistributionDepotAction", blnumber+";distribution result:"+result+";", new Date(), "info", "", "distribution depot");
		} catch (Exception e) {
			result = false;
			setLog(user.getUserid(), "DistributionDepotAction", blnumber+";distribution result:"+result+" errorMessage:"+e.getMessage()+";", new Date(), "info", "", "distribution depot");
		}finally{
			try {
				if (null != prepareCall) {
					prepareCall.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return result;
	}
	

	public List getBookingCtns(List bookings) {
		String whereClause="";
		Object[] params = new Object[] {} ;
		for (Iterator it=bookings.iterator();it.hasNext();) {
			whereClause=whereClause+"?,";
			params=Util.addElement(params, ((Booking)it.next()).getBlnumber(),0);
		}
		for (int i=0;i<bookings.size();i++) {
			params=Util.addElement(params,params[i] ,bookings.size()+i);
		}
		whereClause=whereClause.substring(0, whereClause.length()-1);
		whereClause=" Where a.blnumber IN("+whereClause+")\n";
		String sql=
			"SELECT a.blnumber, a.ctncode, a.ctnqty, b.cname AS depotCname FROM container a\n" +
			"LEFT JOIN (\n" + 
			"   SELECT a.blnumber, a.ctncode, max(sys_connect_by_path(cname,',')) AS cname\n" + 
			"FROM(\n" + 
			"SELECT a.blnumber, a.ctncode, a.cname\n" + 
			"       , (row_number() over(order by a.blnumber, a.ctncode, a.cname desc ) + dense_rank() over(order by a.blnumber, a.ctncode)) rn,\n" + 
			"       MAX(a.cname) over(PARTITION BY a.blnumber, a.ctncode) qs\n" + 
			"FROM(\n" + 
			"  SELECT a.blnumber, a.ctncode, b.cname\n" + 
			"  FROM ctn_dist a JOIN depot b ON a.depotcode=b.depotcode"+
			whereClause+
			"  GROUP BY a.blnumber, a.ctncode,  b.cname\n" + 
			") a\n" + 
			") a\n" + 
			" start with cname = qs\n" + 
			" connect by rn-1 = prior rn\n" + 
			" group by a.blnumber, a.ctncode\n" + 
			") b ON a.blnumber=b.blnumber AND a.ctncode=b.ctncode\n" + 
			whereClause+
			" Order by a.blnumber, a.ctncode \n";
			/*"SELECT a.blnumber, a.ctncode, sum(a.ctnqty) AS ctnqty, max(sys_connect_by_path(depotcode,' ')) AS depotcode\n" +
			"FROM(\n" + 
			"SELECT a.blnumber, a.ctncode, a.depotcode, a.ctnqty\n" + 
			"       , (row_number() over(order by a.blnumber, a.ctncode, a.ctnqty,a.depotcode desc) + dense_rank() over(order by blnumber)) rn,\n" + 
			"       MAX(a.depotcode) over(PARTITION BY a.blnumber) qs\n" + 
			"FROM(\n" + 
			"  SELECT a.blnumber, a.ctncode, a.depotcode, SUM(a.ctnqty) AS ctnqty\n" + 
			"  FROM ctn_dist a\n" + 
			whereClause + 
			"  GROUP BY a.blnumber, a.ctncode, a.depotcode\n" + 
			") a\n" + 
			") a\n" + 
			" start with depotcode = qs\n" + 
			" connect by rn-1 = prior rn\n" + 
			" group by a.blnumber, a.ctncode\n" +
			" order by a.blnumber, a.ctncode\n";*/
		List list=jdbc.query(sql,params,new RowMapperImpl(BookingCtn.class));
		return list;
	}
	
	public List getBookingCtnGroups(Date uploadDate,String vessel,User user) {
		//use for container table
		Object[] params = new Object[] { uploadDate,user.getLocation() };
		String whereClause="";
		if(!vessel.equalsIgnoreCase("allVsl")) {
			whereClause="AND substr(b.vslvoyid,1,3)=?\n"+whereClause;
			params=Util.addElement(params, vessel,2 );
		}
		if(user.getBookingParty()!=null) {
			whereClause="AND b.bookingParty=?\n"+whereClause;
			params=Util.addElement(params, user.getBookingParty(), 2);
		}
		String sql=
			" SELECT a.depotcode, a.ctncode, a.status, a.blnumber ,\n" +
			" ctnqty FROM ctn_dist a, bookingall b, port c\n" + 
			" WHERE a.blnumber = b.blnumber AND b.portofloadingcode=c.portcode\n"+
			"      AND b.uploadtime>=?\n" +
			"	   AND b.portofloadingcode=?\n" +
			whereClause+
			" ORDER BY depotcode, ctncode, status";
		List list=jdbc.query(sql,params,new RowMapperImpl(BookingCtn.class));
		return list;
	}
	
	public void updateBookingCtnStatus(int[] ctnIDs, String[] ctnNbrs, String oldStatus,String newStatus,Date date) {
		String sql=
			"UPDATE  CTN_DIST SET STATUS=?, PICKUPDATE=nvl(pickupdate,?), CTNNBR=?\n" +
			" WHERE ID=?";
		int[] paramTypes = new int[] { Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.INTEGER};
		for(int i=0;i<ctnIDs.length;i++) {
			Object[] params = new Object[] {newStatus,date,ctnNbrs[i],ctnIDs[i]};
			jdbc.update(sql, params,paramTypes);	
		}
	}
	
	public int updateVesselCtnStatus(String vessel, String voyage, String location) {
		String sql=
			"UPDATE ctn_dist a SET a.status=?\n" +
			"WHERE EXISTS(SELECT 1 FROM bookingall b\n" + 
			" WHERE a.blnumber=b.blnumber\n" + 
			"   AND b.uploadtime>sysdate-?\n" +
			"   AND b.uploadtime<sysdate-?\n" + 
			"   AND substr(b.vslvoyid,1,3)=?\n" + 
			"   AND b.portofloadingcode IN (\n" +
            "       SELECT p.portcode \n" +
            "         FROM port p \n" +
            "        WHERE p.LOCATION=?) \n" +
			"   AND a.status=?)";
		
		String sql_voyage=
			"UPDATE ctn_dist a SET a.status=?\n" +
			"WHERE EXISTS(SELECT 1 FROM bookingall b\n" + 
			" WHERE a.blnumber=b.blnumber\n" + 
			"   AND b.uploadtime>sysdate-?\n" +
			"   AND b.uploadtime<sysdate-?\n" + 
			"   AND b.vslvoyid =?\n" + 
			"   AND b.portofloadingcode IN (\n" +
            "       SELECT p.portcode \n" +
            "         FROM port p \n" +
            "        WHERE p.LOCATION=?) \n" +
			"   AND a.status=?)";		
		
		int[] paramTypes = new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER,Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		Object[] params=new Object[] {"C",230,0,vessel,location,'R'};
		Object[] params_voyage=new Object[] {"C",230,0,vessel+" "+voyage,location,'R'};
		if(voyage.trim().equalsIgnoreCase("")){
			return jdbc.update(sql, params,paramTypes);	
		}else{
			return jdbc.update(sql_voyage, params_voyage,paramTypes);	
		}
		
	}
	public int updateCtnStatusToR(int blnumber, String location) {
		String sql=
			"UPDATE ctn_dist a SET a.status=?\n" +
			"WHERE EXISTS(SELECT 1 FROM bookingall b\n" + 
			" WHERE a.blnumber=b.blnumber\n" + 
			"   AND b.uploadtime>sysdate-?\n" +
			"   AND b.uploadtime<sysdate-?\n" + 
			"   AND a.blnumber=?\n" + 
			"   AND b.portofloadingcode IN (\n" +
            "       SELECT p.portcode \n" +
            "         FROM port p \n" +
            "        WHERE p.LOCATION=?) \n" +
			"   and a.pickupdate is null \n" +
			"   AND a.status=?)";
		int[] paramTypes = new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER,Types.INTEGER, Types.VARCHAR, Types.VARCHAR};
		Object[] params=new Object[] {"R",30,0,blnumber,location,'C'};
		return jdbc.update(sql, params,paramTypes);
	}	
	
	public int updateBookingInof(int blnumber, String blockcode, String userlocation) {
		String sql=
			"update booking set blockcode = ? where blnumber = ? and portofloadingcode in (select portcode from port where location = ?)";
		int[] paramTypes = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
		Object[] params=new Object[] {blockcode, blnumber, userlocation};
		int i = jdbc.update(sql, params,paramTypes);
		return i;	
	}	
	
	public int updateCtnStatusToP(int blnumber, String location) {
		String sql=
			"UPDATE ctn_dist a SET a.status=?\n" +
			"WHERE EXISTS(SELECT 1 FROM bookingall b\n" + 
			" WHERE a.blnumber=b.blnumber\n" + 
			"   AND b.uploadtime>sysdate-?\n" +
			"   AND b.uploadtime<sysdate-?\n" + 
			"   AND a.blnumber=?\n" + 
			"   AND b.portofloadingcode IN (\n" +
            "       SELECT p.portcode \n" +
            "         FROM port p \n" +
            "        WHERE p.LOCATION=?) \n" +
			"   and a.pickupdate is not null \n" +
			"   AND a.status=?)";
		int[] paramTypes = new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER,Types.INTEGER, Types.VARCHAR, Types.VARCHAR};
		Object[] params=new Object[] {"P",30,0,blnumber,location,'C'};
		return jdbc.update(sql, params,paramTypes);	
	}	
	public void updateBookingCtn(Booking booking, Map newCtns, Date date) {
		Map oldCtns=booking.getCtns();
		String sql=
			"DELETE  CTN_DIST\n" +
			" WHERE ID=? ";
		for(Iterator it=oldCtns.keySet().iterator();it.hasNext();) {
			int key=(Integer)it.next();
			BookingCtn ctn=(BookingCtn)oldCtns.get(key);
			if(ctn.getStatus().equals("R")) {
				Object[] params = new Object[] {ctn.getId()};
				jdbc.update(sql, params);
			}
		}
		sql=
			"INSERT INTO CTN_DIST\n" +
			"  (ID, BLNUMBER, CTNCODE, INTLCODE, CTNQTY, DEPOTCODE, STATUS, RESERVEDATE)\n" + 
			"VALUES\n" +
			"	(SEQ_CTN_DIST_ID.NEXTVAL,?,?,?,?,?,?,?)";
		for(Iterator it=newCtns.keySet().iterator();it.hasNext();) {
			BookingCtn ctn=(BookingCtn)newCtns.get(it.next());
			for(int i=0;i<ctn.getCtnQty();i++) {
				Object[] params = new Object[] {booking.getBlnumber(),ctn.getCtnCode(),ctn.getIntlcode(),
						1,ctn.getDepotCode(),"R",date};
				jdbc.update(sql, params);
			}
		}
	}
	
	public void updateBookingCtnType(Booking booking, Date date) {
		Map ctns=booking.getCtns();
		//no deal C or P
		String sql=
			"DELETE  CTN_DIST\n" +
			" WHERE blnumber=? and status='R'\n";
		Object[] params=new Object[] {booking.getBlnumber()};
		jdbc.update(sql, params);
		sql="DELETE CONTAINER WHERE blnumber=?";
		jdbc.update(sql, params);
		sql=
			"INSERT INTO CONTAINER\n" +
			"  (ID, BLNUMBER, CTNQTY, CTNCODE, CTNSTATUS, MASTERBLNUMBER, CTNSOC,\n" + 
			"   INTLCODE)\n" + 
			"VALUES\n" + 
			"  (SEQ_CONTAINER.NEXTVAL, ?, ?, ?, 'F', NULL,\n" + 
			"   'N', ?)";
		String sql2=
			"INSERT INTO CTN_DIST\n" +
			"  (ID, BLNUMBER, CTNCODE, INTLCODE, CTNQTY, DEPOTCODE, STATUS, RESERVEDATE)\n" + 
			"VALUES\n" +
			"	(SEQ_CTN_DIST_ID.NEXTVAL,?,?,?,?,?,?,?)";
		Object[] params2=new Object[] {};

		for(Iterator it=ctns.keySet().iterator();it.hasNext();) {
			BookingCtn ctn=(BookingCtn) ctns.get(it.next());
			params=new Object[] {booking.getBlnumber(),ctn.getCtnQty(),ctn.getCtnCode(),ctn.getIntlcode()};
			jdbc.update(sql, params);
			//查找指定箱形在指定区域的库存量，根据此库存量来进行分堆场操作
			List list=jdbc.query(
					"SELECT a.DEPOTCODE, CTNCODE, INITALQTY,RESERVEDQTY,PICKUPEDQTY\n" +
					"  FROM ONLINE_STORAGE a, depot b, port c\n" + 
					"  WHERE a.depotcode=b.depotcode and b.location=c.location and b.isdel=0 AND c.portcode=?\n" + 
					"  AND a.ctncode=? Order by INITALQTY-RESERVEDQTY-PICKUPEDQTY DESC",
					new Object[] {booking.getPortofloadingcode(),ctn.getCtnCode()},
					new RowMapperImpl(DepotCtn.class));
			//已分堆场  不为预定状态的箱子
			int remainQty=jdbc.queryForInt("select sum(ctnqty) from ctn_dist where blnumber=? and ctncode=? and status<>'R'",
					new Object[] {booking.getBlnumber(),ctn.getCtnCode()});
			//对剩余箱子进行分堆场
			List alctedCtns=BizUtil.alctDepotCtns(list, ctn.getCtnQty()-remainQty);
			for (Iterator it2=alctedCtns.iterator();it2.hasNext();) {
				BookingCtn alctedCtn=(BookingCtn) it2.next();
				params2=new Object[] {booking.getBlnumber(),ctn.getCtnCode(),ctn.getIntlcode(),1,alctedCtn.getDepotCode(),"R",date};
				for(int i=0;i<alctedCtn.getCtnQty();i++) {
					jdbc.update(sql2, params2);
				}
			}
		}
	}
	
	public Depot getDepot(String depotCode, String location) {
		String sql="SELECT ID, DEPOTCODE, LOCATION, ENAME, CNAME, TEL,FAX, EADDRESS, CADDRESS\n" +
				", CONTACT, EMAIL FROM DEPOT\n" +
				" Where depotcode=? and location =? and isdel=0";
		Object[] params = new Object[] {depotCode, location};
		Depot depot=null;
		try{
			depot=(Depot)jdbc.queryForObject(sql,params,new RowMapperImpl(Depot.class));
		}catch (IncorrectResultSizeDataAccessException e) {
		}
		return depot;
	}
	
	public void updateDepot(Depot depot) {
		String sql=
			"UPDATE DEPOT\n" +
			"   SET ENAME = ?, CNAME = ?, TEL = ?, FAX=?, EADDRESS = ?,\n" + 
			"       CADDRESS = ?, CONTACT = ?, EMAIL = ?\n" + 
			" WHERE ID = ?";
		Object[] params = new Object[] {depot.getEname(),depot.getCname(),depot.getTel(),depot.getFax(),depot.getEaddress(),
				depot.getCaddress(), depot.getContact(),depot.getEmail(), depot.getId()};
		jdbc.update(sql, params);
	}
	
	public void addDepot(Depot depot) throws DataException{
		String sql="SELECT MAX(ID) FROM DEPOT";
		int maxID=0;
		try{
			maxID=jdbc.queryForInt(sql);
		}catch(IncorrectResultSizeDataAccessException e) {
		}
		maxID++;
		sql=
			"INSERT INTO DEPOT\n" +
			"  (ID, DEPOTCODE, LOCATION, ENAME, CNAME, TEL, EADDRESS, CADDRESS, CONTACT,\n" + 
			"   EMAIL)\n" + 
			"VALUES\n" + 
			"  (?, ?, ?, ?, ?, ?, ?,\n" + 
			"   ?, ?, ?)";
		Object[] params = new Object[] {maxID,depot.getDepotcode(),depot.getLocation(),depot.getEname(),depot.getCname(),depot.getTel(),depot.getEaddress(),
				depot.getCaddress(), depot.getContact(),depot.getEmail()};
		try{
			jdbc.update(sql, params);
		}catch(DataIntegrityViolationException e) {
			throw new NonUniqueDataException();
		}
	}
	
	public List getDepotCtns(Depot depot) {
		String sql=
			"SELECT ID,  CTNCODE, INITALDATE, UPDATETIME, UPDATEUSER, INITALQTY,\n" +
			"       RESERVEDQTY, PICKUPEDQTY\n" + 
			"  FROM ONLINE_STORAGE" +
			"  Where DepotCode=? ";
		Object[] params = new Object[] {depot.getDepotcode()};
		List list=jdbc.query(sql,params,new RowMapperImpl(DepotCtn.class));
		return list;
	}
	
	public void updateDepotCtn(Depot depot, Date updatetime, User user) {
		Map updateDepotCtns=new TreeMap();
		Map addDepotCtns=new TreeMap();
		Map depotCtns=depot.getContainers();
		for(Iterator it=depotCtns.keySet().iterator();it.hasNext();) {
			String key=(String) it.next();
			DepotCtn ctn=(DepotCtn) depotCtns.get(key);
			if(ctn.getId()==0) {
				addDepotCtns.put(key, ctn);
			}else {
				updateDepotCtns.put(key, ctn);
			}
		}
		String sql=
			"UPDATE INVENTORY\n" +
			"   SET VOLUME = ?, INITALDATE = ?,\n" + 
			"       UPDATETIME = ?, UPDATEUSER = ?\n" + 
			" WHERE ID = ?";
		BatchPreparedStatementSetter setter = new DepotCtnUpdateBatchSetter(updateDepotCtns,updatetime,user.getUserid());
        jdbc.batchUpdate(sql, setter);
        sql=
        	"INSERT INTO INVENTORY\n" +
        	"  (ID, DEPOTCODE, CTNCODE, VOLUME, INITALDATE, UPDATETIME, UPDATEUSER)\n" + 
        	"VALUES\n" + 
        	"  (SEQ_INVENTORY_ID.nextval, ?, ?, ?, ?, ?, ?)";
        setter=new DepotCtnAddBatchSetter(addDepotCtns,depot.getDepotcode(),updatetime,user.getUserid());
        jdbc.batchUpdate(sql, setter);
        //Update ctn Status from Pickuped to Completed(P->C)
        sql=
        	"UPDATE CTN_DIST\n" +
        	"SET STATUS=?\n" +
        	"WHERE DEPOTCODE=? AND CTNCODE=? AND STATUS=? AND PICKUPDATE<?";
        setter=new BookingCtnStatusUpdateBatchSetter(depotCtns,depot.getDepotcode(),"C","P");
        jdbc.batchUpdate(sql, setter);
	}
	
	public List getDepots(String location) {
		
		String sql="SELECT ID, DEPOTCODE, LOCATION, ENAME, CNAME, TEL, EADDRESS, CADDRESS\n" +
				", CONTACT, EMAIL FROM DEPOT\n" +
				" Where ISDEL=0\n";
		Object[] params=null;
		if(location!=null&&!location.equalsIgnoreCase("")) {
			sql=sql+"and location=?";
			params = new Object[] {location};
		}
		List list=null;
		list=jdbc.query(sql,params,new RowMapperImpl(Depot.class));
		return list;
	}
	
	public List getDepotsCtns(String location) {
		String sql=
			"SELECT b.depotcode, CTNCODE, INITALDATE, UPDATETIME, UPDATEUSER, INITALQTY,\n" +
			"RESERVEDQTY, PICKUPEDQTY\n" + 
			"FROM ONLINE_STORAGE a, depot b\n" + 
			"Where a.depotcode=b.depotcode and b.ISDEL=0 \n" +
			"and b.LOCATION=?\n" +
			"ORDER BY ctncode, b.depotcode";
		Object[] params = new Object[] {location};
		List list=jdbc.query(sql,params,new RowMapperImpl(DepotCtn.class));
		return list;
	}
	
	public List getPendingCtn(String location, Date begDate,Date endDate) {
		String sql=
			"select b.blnumber,\n" + 
			"       upper(b.portofloadingcode) as LoadingCode,\n" + 
			"       to_char(s.passedtime,'yyyy-mm-dd hh24:mi') as passedtime,\n" + 
			"       c.ctncode,\n" + 
			"       c.intlcode,\n" + 
			"       c.ctnqty\n" + 
			"  from booking b, bookingstatus s, container c, port p\n" + 
			" WHERE b.blnumber = s.blnumber\n" + 
			"   AND b.blnumber = c.blnumber\n" + 
			"   AND upper(b.portofloadingcode) = p.portcode\n" + 
			"   AND P.LOCATION = ?\n" + 
			"   AND S.PASSEDTIME >= ?\n" + 
			"   AND S.PASSEDTIME < ? + 1\n" + 
			"   AND c.ctnqty > 0\n" + 
			"   AND NOT EXISTS\n" + 
			" (SELECT 1 FROM ctn_dist WHERE ctn_dist.blnumber = B.blnumber)\n" + 
			" order by s.passedtime desc, b.blnumber, c.ctncode";
		Object[] params = new Object[] {location, begDate, endDate};
		List list=jdbc.query(sql,params,new RowMapperImpl(PendingCtn.class));
		return list;
	}
	
	public List getCtnTypes() {
		String sql="SELECT INTLCODE, CTNCODE, APLSIZE, APLTYPE, APLHEIGHT FROM CTNTYPE ";
		List list=jdbc.query(sql,new RowMapperImpl(CtnType.class));
		return list;
	}
	public List getBookingDesc(int blnumber) {
		String sql=" select blnumber,\n" +
					"       nvl(sdesc, 'No Status') as sdesc,\n" +
					"       nvl(comments, 'No Comments') as comments,\n" +
					"       nvl(p_reasons, 'No Pending Reasons') as p_reasons\n" +
					"  from bookingstatus_desc\n" +
					" where blnumber = ?";
		Object[] params = new Object[] {blnumber};
		List list=jdbc.query(sql,params,new RowMapperImpl(BookingDesc.class));
		return list;
	}
	public List getVessels() {
		String sql="SELECT ID, NAME, SIMPLENAME, CNAME, CALLSIGN, LLOYDS, SVCNAME, upper(name) || ' (' || UPPER(ID) || ')' as sname \n" +
				"FROM VESSEL\n" +
				"Order by name ";
		List list=jdbc.query(sql,new RowMapperImpl(Vessel.class));
		return list;
	}
	public Vector getCtnList(String Location,String vslCD,String DepotCode,Date begDate,Date endDate) {
		Vector vec = new Vector();
		Object[] params = new Object[] {Location,begDate,endDate};
		String sql="SELECT d.status, \n" +
                   "SUBSTR(b.vslvoyid, 1, 3) AS vslcd,  \n" +
                   "SUBSTR(b.vslvoyid, 5, 3) AS voy,   \n" +
                   "d.blnumber,   \n" +
                   " b.blockcode,   \n" +
                   "  b.placeofdeliverycode,   \n" +
                   "   SUBSTR(d.ctncode, 4, 4) AS cntr_size,   \n" +
                   "    SUBSTR(d.ctncode, 1, 3) AS cntr_type,   \n" +
                   "    d.ctnqty,   \n" +
                   "     d.depotcode,   \n" +
                   "    s.uploadtime,   \n" +
                   "    d.pickupdate,   \n" +
                   "   d.ctnnbr,   \n" +
                   "     s.remark,   \n" +
                   "     s.sremark as fixed_remark   \n" +
                   " FROM ctn_dist d,   \n" +
                   "    bookingstatus s,   \n" +
                   "      booking b   \n" +
                   " WHERE b.portofloadingcode in (SELECT p.portcode FROM port p WHERE p.LOCATION=?)  \n";
		String whereclause = "" ;
		if(!vslCD.equalsIgnoreCase("allVsl")) {
			whereclause=whereclause+" and substr(B.VSLVOYID,1,3)=?\n";
			params=Util.addElement(params, vslCD,1 );
			if(!DepotCode.equalsIgnoreCase("All")) {
				whereclause=whereclause+"  and D.DEPOTCODE=?   \n";
				params=Util.addElement(params, DepotCode,2 );
			}
		}
		else{
			if(!DepotCode.equalsIgnoreCase("All")) {
				whereclause=whereclause+"  and D.DEPOTCODE=?   \n";
				params=Util.addElement(params, DepotCode,1 );
			}
		}
		
		sql = sql + whereclause + 
		     "  and s.uploadtime between ? and ?  \n" +
             "  and d.blnumber = s.blnumber   \n" +
             " AND d.blnumber = b.blnumber order by blnumber, uploadtime, status "; 
        SqlRowSet rs = jdbc.queryForRowSet(sql,params);
        int ccount = rs.getMetaData().getColumnCount();
        Vector veccol = new Vector();
		for (int i = 0; i < ccount; i++) {
			veccol.add(rs.getMetaData().getColumnName(i+1));
		}
		vec.add(veccol); //get column name
		while (rs.next()) {
			Vector vectmp = new Vector();
			for (int i = 0; i < ccount; i++) {
				vectmp.add(rs.getString(i + 1));
			}
			vec.add(vectmp); // get result
		}
		//SqlRowSet rs = jdbc.queryForRowSet(sql);
		return vec;
	}
	public int updateVessel(Vessel vessel) {
		String sql=
			"UPDATE VESSEL\n" +
			"   SET NAME = ?, SIMPLENAME = ?, CNAME = ?,\n" + 
			"       CALLSIGN = ?, LLOYDS = ?, SVCNAME = ?\n" + 
			" WHERE ID = ?";
		Object[] params=new Object[] {vessel.getName(),vessel.getSimpleName(),
				vessel.getCname(),vessel.getCallsign(),vessel.getLloyds(),vessel.getSvcname(),vessel.getId()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		return jdbc.update(sql, params, argTypes);
	}
	
	public int updateVslVoyByBlnumber(int blnumber, String vslcd, String voyid) {
		String sql=
			"UPDATE Booking\n" +
			"   SET vslvoyid = ?, vesselname = (select vessel.name from vessel where vessel.id = ?) \n" + 
			" WHERE blnumber = ?";
		Object[] params=new Object[] {vslcd + " " + voyid, vslcd, blnumber};
		int[] argTypes=new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER };
		return jdbc.update(sql, params, argTypes);
	}
	
	public int checklengthofvlname(int PrintID) {
		int vl;
		String sql=	"select length(nvl(trim(v.name), ' ')) as vlnamelength\n" +
		"  from booking b, ctn_dist c, vessel v \n" +
		" where c.id = ? \n" +
		"   and c.blnumber = b.blnumber \n" +
		"   and substr(b.vslvoyid, 1, 3) = v.id(+)";
//" select length(trim(b.vesselname)) as vlnamelength from booking b, ctn_dist c \n" +
//"  where c.id=? and c.blnumber = b.blnumber";
		Object[] params=new Object[] {PrintID};
		int[] argTypes=new int[] {Types.INTEGER};
		vl = jdbc.queryForInt(sql, params, argTypes);
		return vl;
	}
	
	public void addVessel(Vessel vessel) {
		String sql=
			"INSERT INTO VESSEL\n" +
			"  (ID, NAME, SIMPLENAME, CNAME, CALLSIGN, LLOYDS, SVCNAME, CREATEDATE)\n" + 
			"VALUES\n" + 
			"  (?,?,?,?,?,?,?,sysdate)";
		Object[] params=new Object[] {vessel.getId(),vessel.getName(),vessel.getSimpleName(),
				vessel.getCname(),vessel.getCallsign(),vessel.getLloyds(),vessel.getSvcname()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		jdbc.update(sql, params, argTypes);
	}
	
	public List getOneWayCtns(OneWayCtn owc) {
		String whereClause="";
		Object[] params=new Object[] {owc.getLocation()};
		if(!owc.getCtnCode().equalsIgnoreCase("all")) {
			whereClause=whereClause+" AND ctncode=?\n";
			params=Util.addElement(params, owc.getCtnCode());
		}
		if(owc.getStatus()!=null) {
			whereClause=whereClause+" AND status=?\n";
			params=Util.addElement(params, owc.getStatus()?1:0);
		}
		String sql="SELECT ID, LOCATION, ctncode, dest, depotcode, ctns, status, oremark \n" +
		"	FROM onewayctn\n" +
		"	WHERE location=?\n"+ 
		whereClause+
		"	ORDER BY ctncode,dest\n";
		return jdbc.query(sql,params,new RowMapperImpl(OneWayCtn.class));
	}
	
	public void updateOneWayCtn(OneWayCtn owc) {
		String sql=
			"UPDATE onewayctn\n" +
			"   SET LOCATION = ?,\n" + 
			"       CTNCODE = ?,\n" + 
			"       DEST = ?,\n" + 
			"       DEPOTCODE = ?,\n" + 
			"       CTNS = ?\n," +
			"       STATUS = ?,\n" +
			"       OREMARK = ?\n" +
			" WHERE ID = ?";
		Object[] params=new Object[] {owc.getLocation(),owc.getCtnCode(),
				owc.getDest(),owc.getDepotCode(),owc.getCtns(),
				owc.getStatus()?1:0, 
				owc.getOremark(),
				owc.getId()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.INTEGER, Types.VARCHAR, Types.INTEGER};
		jdbc.update(sql, params, argTypes);
	}
	
	public void addOneWayCtn(OneWayCtn owc) throws NonUniqueDataException {
		String sql=
			"INSERT INTO onewayctn\n" +
			"  (ID, LOCATION, CTNCODE, DEST, DEPOTCODE, CTNS)\n" + 
			"VALUES\n" + 
			"  (seq_onewayctn.nextval, ?, ?, ?, ?, ?)";
		Object[] params=new Object[] {owc.getLocation(),owc.getCtnCode(),
				owc.getDest(),owc.getDepotCode(),owc.getCtns()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		try {
			jdbc.update(sql, params, argTypes);
		} catch (DataIntegrityViolationException e) {
			throw new NonUniqueDataException();
		}
	}
	
	public List getNewses(User user,boolean isMandatory) {
		String sql=
			"SELECT ID, GROUPID, USERID, LOCATION, BRIEF, CONTENT, ISMANDATORY, BEGDATE,\n" +
			"       ENDDATE, UPDATETIME, UPDATEUSER, ISDEL\n" + 
			"  FROM NEWS\n" + 
			"  WHERE isdel=0 AND ROWNUM<=5\n" + 
			"  AND begdate<=sysdate AND enddate>=SYSDATE\n" + 
			"    AND (userid=? OR groupid=? OR GROUPID=0)\n" +
			"  AND (location=? OR location is null)\n" +
			"  AND ismandatory=?\n" + 
			"  ORDER BY updatetime DESC";
		Object[] params=new Object[] {user.getUserid(),user.getUsergroup().getGroupid(),user.getLocation(), isMandatory};
//		int[] argTypes=new int[] {Types.INTEGER,Types.INTEGER,Types.VARCHAR,
//				Types.INTEGER};
		List list=jdbc.query(sql,params,new RowMapperImpl(News.class));
		return list;
	}
	
	public List getNewses() {
		String sql=
			"SELECT a.ID, a.GROUPID, a.USERID, a.LOCATION, a.BRIEF, a.CONTENT, a.ISMANDATORY, a.BEGDATE,\n" +
			"       a.ENDDATE, a.UPDATETIME, a.UPDATEUSER, a.ISDEL, b.firstname||b.lastname AS userFullName, c.groupname\n" + 
			"  FROM NEWS a\n" + 
			"  LEFT JOIN users b ON a.userid=b.userid\n" + 
			"  LEFT JOIN Usergroups c ON a.groupid=c.groupid\n" + 
			"  WHERE isdel=0 AND enddate>=SYSDATE\n" + 
			"  ORDER BY updatetime DESC";
		List list=jdbc.query(sql,new RowMapperImpl(News.class));
		return list;
	}
	
	public void deleteNews(int id) {
		String sql=
			"UPDATE news\n" +
			"   SET ISDEL = 1\n" + 
			" WHERE ID = ?";
		jdbc.update(sql, new Object[] {id});
	}
	
	public void addNews(News news) {
		int newID=1;
		try{
			newID=jdbc.queryForInt("select max(ID)+1 from news");
		}catch(IncorrectResultSizeDataAccessException e) {
		}
		String sql=
			"INSERT INTO news\n" +
			"  (ID, GROUPID, USERID, LOCATION, BRIEF, CONTENT, ISMANDATORY, BEGDATE, ENDDATE, UPDATETIME, UPDATEUSER, ISDEL)\n" + 
			"VALUES\n" + 
			"  (?,?,?,?,?,?,?,?,?,?,?,0)";
		Object[] params=new Object[] {newID,news.getGroupid(),news.getUserid(),news.getLocation(),
				news.getBrief(),news.getContent(),news.getIsMandatory(),news.getBegDate(),
				news.getEndDate(),news.getUpdateTime(),news.getUpdateUser()};
		jdbc.update(sql, params);
	}
	
	public List getLogs(Date begDate,Date endDate,String type,String function, int userID) {
		String sql=
			"SELECT a.ID, a.USERID, b.Username, a.IPADDRESS, a.FUNCTION,\n" +
			" a.TYPE, a.EVENTIME, a.EVENT, a.COMMENTS\n" + 
			"  FROM LOG a JOIN users b ON a.userid=b.userid\n" +
			" WHERE a.eventime>? and a.eventime<?\n";
		Object[] params=new Object[] {begDate,endDate};
		if(type!=null&&!type.equalsIgnoreCase("all")) {
			sql=sql+" and type=?\n";
			params=Util.addElement(params, type,params.length);
		}
		if(function!=null&&!function.equalsIgnoreCase("all")) {
			sql=sql+" and function=?\n";
			params=Util.addElement(params, function,params.length);
		}
		if(userID!=0) {
			sql=sql+" and b.userid=?\n";
			params=Util.addElement(params, userID,params.length);
		}
		sql=sql+" Order by a.eventime desc\n";
		List list=jdbc.query(sql,params,new RowMapperImpl(Log.class));
		return list;
	}
	
	public void setLog(int userID, String function, String event, Date date, String type, String ipAddress,String comments) {
		String sql=
			"INSERT INTO LOG\n" +
			"  (ID, USERID, IPADDRESS, FUNCTION, TYPE, EVENTIME, EVENT,comments)\n" + 
			"VALUES\n" + 
			"  (SEQ_LOG_ID.nextval, ?, ?, ?, ?, ?, ?,?)";
		Object[] params = new Object[] {userID,ipAddress,function,type,date,event,comments};
		jdbc.update(sql, params);
	}
	
	public void setJdbc(JdbcTemplate jdbcTemplate) {
		jdbc = jdbcTemplate;
	}
	private class DepotCtnUpdateBatchSetter implements BatchPreparedStatementSetter {
		private int batchSize;
		
		private Collection depotCtns;

		private java.util.Date updatetime;
		private int userid;
		
		public DepotCtnUpdateBatchSetter(List depotCtns,java.util.Date updatetime,int userid) {
			this.batchSize = depotCtns.size();
			this.depotCtns = depotCtns;
			this.updatetime = updatetime;
			this.userid = userid;
		}
		public DepotCtnUpdateBatchSetter(Map depotCtns,java.util.Date updatetime,int userid) {
			this.batchSize = depotCtns.size();
			this.depotCtns = depotCtns.values();
			this.updatetime = updatetime;
			this.userid = userid;
		}
		public int getBatchSize() {
			return batchSize;
		}

		public void setValues(PreparedStatement ps, int i) throws SQLException {
			DepotCtn ctn=(DepotCtn) depotCtns.toArray()[i];
			ps.setInt(1,ctn.getInitalQty());
	        ps.setDate(2, new java.sql.Date(ctn.getInitalDate().getTime()));
	        ps.setTimestamp(3, new Timestamp(updatetime.getTime()));
	        ps.setInt(4, userid);
	        ps.setInt(5,ctn.getId());
		}
	}
	private class DepotCtnAddBatchSetter implements BatchPreparedStatementSetter {
		private int batchSize;
		
		private Collection depotCtns;

		private Timestamp updatetime;
		private int userid;
		private String depotcode;
		public DepotCtnAddBatchSetter(Map depotCtns,String depotcode,java.util.Date updatetime,int userid ) {
			this.batchSize = depotCtns.size();
			this.depotCtns = depotCtns.values();
			this.depotcode=depotcode;
			this.updatetime = new Timestamp(updatetime.getTime());
			this.userid = userid;
		}
		public int getBatchSize() {
			return batchSize;
		}

		public void setValues(PreparedStatement ps, int i) throws SQLException {
			DepotCtn ctn=(DepotCtn) depotCtns.toArray()[i];
			ps.setString(1, depotcode);
			ps.setString(2,ctn.getCtnCode());
			ps.setInt(3,ctn.getInitalQty());
	        ps.setDate(4, new java.sql.Date(ctn.getInitalDate().getTime()));
	        ps.setTimestamp(5, updatetime);
	        ps.setInt(6, userid);
		}
	}
	private class BookingCtnStatusUpdateBatchSetter implements BatchPreparedStatementSetter {
		private int batchSize;
		
		private Collection depotCtns;

		private String depotcode;
		private String status;
		private String oldStatus;
		public BookingCtnStatusUpdateBatchSetter(Map depotCtns,String depotcode,String status,String oldStatus) {
			this.batchSize = depotCtns.size();
			this.depotCtns = depotCtns.values();
			this.depotcode = depotcode;
			this.status = status;
			this.oldStatus = oldStatus;
		}
		public int getBatchSize() {
			return batchSize;
		}

		public void setValues(PreparedStatement ps, int i) throws SQLException {
			DepotCtn ctn=(DepotCtn) depotCtns.toArray()[i];
			ps.setString(1, status);
			ps.setString(2, depotcode);
			ps.setString(3,ctn.getCtnCode());
			ps.setString(4, oldStatus);
			ps.setDate(5, new java.sql.Date(ctn.getInitalDate().getTime()));
		}
	}
	public boolean checkBookingDepot(int blnumber,String dusername) {
	    int checkno = 0;
		String sql = "SELECT count(b.cname) as num\n"
			+ "       FROM CTN_DIST a, depot b\n"
			+ "       Where a.depotcode=b.depotcode\n"
			+ "       AND a.blnumber=?\n"
			+ "       and b.depotcode = (SELECT p.depot FROM users u, user_profiles p WHERE u.username=? and u.userid=p.userid) ";
	    Object[] params = new Object[] {blnumber, dusername};
	    try {
		   checkno = jdbc.queryForInt(sql, params);
	    } catch (IncorrectResultSizeDataAccessException e) {
	    }
        if (checkno > 0){
		    return true;
	    }
        else{
    	    return false;
        }
	}
	
	public int checkBabyBooking(String blnumber) {
	    int checkno = 0;
		String sql = "select count(*) from booking_baby where blnumber_baby = ?";
	    Object[] params = new Object[] {blnumber};
	    try {
		   checkno = jdbc.queryForInt(sql, params);
	    } catch (IncorrectResultSizeDataAccessException e) {
	    }
        return checkno;
	}
	
	public String checkHotStow(int blnumber) {
	    String checkHS = "nofound";
	    SqlRowSet rs;
	    
	    String sql = "SELECT v.svcname as svcname\n"
			+ "       FROM booking b, vessel v\n"
			+ "       WHERE b.blnumber = ?\n"
			+ "       AND b.hot_stow = 'Y'\n"
			+ "       AND SUBSTR (b.vslvoyid, 1, 3) = v.ID(+)";
	    Object[] params = new Object[] {blnumber};
	    try {
	    	rs = jdbc.queryForRowSet(sql, params);
	    	while (rs.next()){
	    		checkHS = rs.getString(1);
	    	}
	    	
	    } catch (IncorrectResultSizeDataAccessException e) {
	    }

	    return checkHS;
	}
	
	public String getBookingPReason(int p_id) {
	    String pReason = "";
	    SqlRowSet rs;
	    
	    String sql = "select comments from t_ref_pending_reason where id = ? ";
	    Object[] params = new Object[] {p_id};
	    try {
	    	rs = jdbc.queryForRowSet(sql, params);
	    	while (rs.next()){
	    		pReason = rs.getString(1);
	    	}
	    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    return pReason;
	}
	
	public List getBlockCodeUpdate() {
		String whereClause="WHERE status = 'Y'";
		String sql="SELECT id, svcname, portofloadingcode, block_code \n" +
		"	FROM block_code_update\n" +
		whereClause+
		"	ORDER BY svcname\n";
		return jdbc.query(sql,new RowMapperImpl(BlockCodeUpdate.class));
	}
	
	public List getSVCNameMap() {
		String sql="select svcname, portofloadingcode, placeofreturn \n" +
		"	from mapstp WHERE status = 'Y'\n" +
		"	ORDER BY svcname,portofloadingcode, placeofreturn\n";
		return jdbc.query(sql,new RowMapperImpl(SVCNameMap.class));
	}
	
	public List getIvoyEvoyMap() {
		String whereClause="WHERE status = 'Y'";
		String sql="SELECT v_id, vslcd, internal_voyid, external_voyid \n" +
		"	FROM vslcd_ivoy_evoy\n" +
		whereClause+
		"	ORDER BY vslcd\n";
		return jdbc.query(sql,new RowMapperImpl(IvoyEvoyMap.class));
	}	
	
	public void updateIvoyEvoyMap(IvoyEvoyMap iem) {
		String sql=
			"MERGE INTO vslcd_ivoy_evoy v\n" +
			"   USING (SELECT ? AS vslcd, ? AS internal_voyid, ? AS external_voyid FROM DUAL) t\n" + 
			"   ON (v.vslcd = t.vslcd AND v.internal_voyid = t.internal_voyid)\n" + 
			"   WHEN MATCHED THEN\n" + 
			"      UPDATE\n" + 
			"         SET V.EXTERNAL_VOYID = t.external_voyid, V.STATUS = 'Y', V.UPDATE_DATE = sysdate\n" +
			"   WHEN NOT MATCHED THEN\n" +
			"      INSERT\n" +
			"      VALUES (seq_vslcd_ivoy_evoy.NEXTVAL, t.vslcd, t.internal_voyid, t.external_voyid, 'Y', SYSDATE, SYSDATE)";
		Object[] params=new Object[] {iem.getVslcd(), iem.getInternal_voyid(), iem.getExternal_voyid()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		jdbc.update(sql, params, argTypes);
	}
	
	public void updateBlockCodeUpdate(BlockCodeUpdate bcu) {
		String sql=
			"MERGE INTO block_code_update v\n" +
			"   USING (select ? as svcname, ? as portofloadingcode, ? block_code from dual) t\n" + 
			"   ON (v.svcname = t.svcname and v.portofloadingcode = t.portofloadingcode)\n" + 
			"   WHEN MATCHED THEN\n" + 
			"      UPDATE\n" + 
			"         SET V.block_code = t.block_code, V.STATUS = 'Y', V.UPDATE_DATE = sysdate\n" +
			"   WHEN NOT MATCHED THEN\n" +
			"      INSERT\n" +
			"      VALUES (SEQ_BLOCK_CODE_UPDATE.NEXTVAL, t.svcname, t.portofloadingcode, t.block_code, 'Y', SYSDATE, SYSDATE)";
		Object[] params=new Object[] {bcu.getSvcname(), bcu.getPortofloadingcode(), bcu.getBlock_code()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		jdbc.update(sql, params, argTypes);
	}
	
	public void updateSVCNameMap(SVCNameMap stp) {
		String sql=
			"MERGE INTO mapstp v\n" +
			"   USING (select ? as svcname, ? as placeofreturn, ? as portofloadingcode from dual) t\n" + 
			"   ON (v.svcname = t.svcname and v.portofloadingcode = t.portofloadingcode)\n" + 
			"   WHEN MATCHED THEN\n" + 
			"      UPDATE\n" + 
			"         SET V.placeofreturn = t.placeofreturn, V.STATUS = 'Y', V.UPDATE_DATE = sysdate \n" +
			"   WHEN NOT MATCHED THEN\n" +
			"      INSERT\n" +
			"      VALUES (t.svcname, t.placeofreturn, t.portofloadingcode, 'Y', SYSDATE, SYSDATE)";
		Object[] params=new Object[] {stp.getSvcname(),stp.getPlaceofreturn(), stp.getPortofloadingcode()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		jdbc.update(sql, params, argTypes);
	}
	
	public void disableIvoyEvoyMap(int V_id) {
		String sql=
			"UPDATE vslcd_ivoy_evoy SET STATUS = 'N', UPDATE_DATE = sysdate WHERE V_ID = ?";
		Object[] params=new Object[] {V_id};
		int[] argTypes=new int[] {Types.INTEGER};
		jdbc.update(sql, params, argTypes);
	}
	public void disableSVCNameMap(SVCNameMap stp) {
		String sql=
			"UPDATE mapstp SET STATUS = 'N',UPDATE_DATE = sysdate  WHERE svcname=? and portofloadingcode=? ";
		Object[] params=new Object[] {stp.getSvcname(),stp.getPortofloadingcode()};
		int[] argTypes=new int[] {Types.VARCHAR,Types.VARCHAR};
		jdbc.update(sql, params, argTypes);
	}
	public void disableBlockCodeUpdate(int Id) {
		String sql=
			"UPDATE block_code_update SET STATUS = 'N', UPDATE_DATE = sysdate WHERE ID = ?";
		Object[] params=new Object[] {Id};
		int[] argTypes=new int[] {Types.INTEGER};
		jdbc.update(sql, params, argTypes);
	}
}
