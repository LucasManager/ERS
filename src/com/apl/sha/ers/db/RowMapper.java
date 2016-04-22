package com.apl.sha.ers.db;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public abstract class RowMapper {

	private String initCap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	public Object reflect(ResultSet rs, int index, Object object) {
		Class c = object.getClass();
		while(!c.getName().equals("java.lang.Object")) {
			object=reflect(rs,index,c,object);
			c=c.getSuperclass();
		}
		return object;
	}

	public Object reflect(ResultSet rs, int index, Class c) {
		Object object=null;
		try {
			object = c.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return reflect(rs,index,c,object);
	}
	
	public Object reflect(ResultSet rs, int index, Class c, Object object) {
		Field[] fs = c.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
//			String type = fs[i].getType().getSimpleName();
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
				/*if (type.equalsIgnoreCase("String")) {
					c.getMethod(methodname, String.class).invoke(object, rs.getString(name));
				} else if (type.equalsIgnoreCase("int")) {
					c.getMethod(methodname, int.class).invoke(object, rs.getInt(name));
				} else if (type.equalsIgnoreCase("Date")) {
					c.getMethod(methodname, Date.class).invoke(object, new Date(rs.getTimestamp(name).getTime()));
				} else if (type.equals("boolean")) {
					c.getMethod(methodname, boolean.class).invoke(object, rs.getBoolean(name));
				} else if (type.equals("Boolean")) {
					c.getMethod(methodname, Boolean.class).invoke(object, rs.getBoolean(name));
				} else if (type.equalsIgnoreCase("Long")) {
					c.getMethod(methodname, Long.class).invoke(object, rs.getLong(name));
				}*/ 
			} catch (IllegalAccessException iae) {

			} catch (SQLException sqle) {
				
			} catch (Exception e) {

			}
		}
		return object;
	}
}
