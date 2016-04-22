package com.apl.sha.ers.db;

import java.lang.reflect.Field;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.apl.sha.ers.model.UserGroup;

public class ORMapperFactory  {
	
	public static Object mapping(SqlRowSet rs, int index, Object object) {
		Class c = object.getClass();
		Field[] fs = c.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Class type = fs[i].getType();
			String name = fs[i].getName();
			String methodname = "set" + initCap(name);
			try {
				if (type == String.class) {
					c.getMethod(methodname, String.class).invoke(object, rs.getString(name));
				} else if (type==int.class) {
					c.getMethod(methodname, int.class).invoke(object, rs.getInt(name));
				} else if (type==Date.class) {
					c.getMethod(methodname, Date.class).invoke(object, new Date(rs.getTimestamp(name).getTime()));
				} else if (type==boolean.class) {
					c.getMethod(methodname, boolean.class).invoke(object, rs.getBoolean(name));
				} else if (type==Boolean.class) {
					c.getMethod(methodname, Boolean.class).invoke(object, rs.getBoolean(name));
				} else if (type==Long.class) {
					c.getMethod(methodname, Long.class).invoke(object, rs.getLong(name));
				}
			} catch (IllegalAccessException iae) {
//				iae.printStackTrace();
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
		return object;
	}

	private static String initCap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);

	}

	public static UserGroup mappingUserGroup(SqlRowSet rs, int index,
			UserGroup ug) {
		ug.setGroupid(rs.getInt("usergroupid"));
		ug.setGroupname(rs.getString("usergroupname"));
		ug.setComments(rs.getString("usergroupcomments"));
		return ug;
	}
	
	
}