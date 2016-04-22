package com.apl.sha.ers.util;

import java.util.Vector;

public class BasicFunc {
	public static String getComments(String comments) {
		int len = 50;
		if (comments.length() > len) {
			return comments.substring(0, len);
		} else {
			return comments;
		}

	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException de) {
			return false;
		}
		return true;
	}
	
    public static boolean isGroupEmp(String empid,Vector groupemps) {
        int size=groupemps.size();
        Vector vec=null;
        for(int i=0;i<size;i++) {
        	vec=(Vector)groupemps.get(i);
            if(empid.equalsIgnoreCase((String)vec.get(1))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isInlist(String str,String[] strlist) {
    	for(int i=0;i<strlist.length;i++) {
    		if (str.equalsIgnoreCase(strlist[i])) {
    			return true;
    		}
		}
        return false;
    }
    
    public static boolean isDate(String str) {
//		try {
//			Double.parseDouble(str);
//		} catch (NumberFormatException de) {
//			return false;
//		}
		return true;
	}
    
    public static String getEmpName(int empid,Vector groupemps) {
        int size=groupemps.size();
        Vector vec=null;
        for(int i=0;i<size;i++) {
        	vec=(Vector)groupemps.get(i);
            if(empid==Integer.parseInt((String)vec.get(1))) {
            	String empname=(String)vec.get(0);
            	empname=empname.substring(0,empname.indexOf("--")).replaceAll(" ","");
                return empname;
            }
        }
        return null;
    }
}
