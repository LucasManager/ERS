package com.apl.sha.ers.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DateUtil {
	private static String datePattern="yyyy-MM-dd";
	private static String timePattern="yyyy-MM-dd HH:mm";
	private static String dateTimePattern="yyyy-MM-dd HH:mm";
	
	public static String formatDate(Date date) {
		return formatDate(date, datePattern);
	}
	
	public static String formatDate(Date date,String pattern) {
		if(date==null) return null;
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * @param datetime
	 * @param type (date[default],time,datetime)
	 * @return formated Date String
	 */
	public static String format(Date datetime,String type) {
		if(type==null) {
			type="date";
		}
		if(type.equalsIgnoreCase("dateTime")) {
			return formatDate(datetime, dateTimePattern);
		}else if(type.equalsIgnoreCase("Time")) {
			return formatDate(datetime, timePattern);
		}else {
			return formatDate(datetime, datePattern);
		}
	}
	
	public static Date parseDate(String date,String pattern) {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
		}
		return null;
	}
	public static Date parseDate(String date) {
		return parseDate(date,datePattern);
	}
	
	/**
	 * @param datetime String
	 * @param type (date[default],time,datetime)
	 * @return Date 
	 */
	public static Date parse(String datetime,String type) {
		if(type==null) {
			type="date";
		}
		if(type.equalsIgnoreCase("dateTime")) {
			return parseDate(datetime, dateTimePattern);
		}else if(type.equalsIgnoreCase("Time")) {
			return parseDate(datetime, timePattern);
		}else {
			return parseDate(datetime, datePattern);
		}
	}
	
	public static boolean isValidDate(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat(datePattern);
		try {
			sdf.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static Date getDateBFToday(int days) {
		Calendar calendar=Calendar.getInstance();
		Calendar newCalendar=Calendar.getInstance();
		calendar.setTime(new Date());
		newCalendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
		newCalendar.add(Calendar.DATE, -days);
		return newCalendar.getTime();
	}
}
