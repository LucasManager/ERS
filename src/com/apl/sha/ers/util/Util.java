package com.apl.sha.ers.util;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Util {
	public static String addQuotation(String list) {
		String[] tmp=list.split(",");
		String result="";
		for(int i=0;i<tmp.length;i++) {
			result=result+"'"+tmp[i]+"',";
		}
		return result.substring(0, result.length()-1);
	}
	
	public static Map convertToMap(List list,String keyname, Class cls) throws Exception{
		Method method=null;
		method=cls.getMethod("get"+initCap(keyname), new Class[]{});
		Map map=new TreeMap();
		for(Iterator it=list.iterator();it.hasNext();) {
			Object object=it.next();
			map.put(method.invoke(object, new Object[]{}), object);
		}
		return map;
	}
	
	public static void minusMap(Map srcMap, Map subMap) {
		for(Iterator it=subMap.keySet().iterator();it.hasNext();) {
			srcMap.remove((String)it.next());
		}
	}
	
	public static String initCap(String str) {
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
	
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/** Add the element to the position of the Array <br/>
 	 *	The array length will be added by 1.  
	 * @param oldArray
	 * @param element
	 * @param pos the position of the element, 0 is the first
	 * @return new Object[]
	 */
	public static Object[] addElement(Object[] oldArray, Object element,int pos) {
		Object[] newArray=new Object[oldArray.length+1];
		System.arraycopy(oldArray, 0, newArray, 0, pos);
		System.arraycopy(oldArray, pos, newArray, pos+1, oldArray.length-pos);
		newArray[pos]=element;
		return newArray;
	}

	/** Add the element to the end of Array
	 * @param oldArray
	 * @param element
	 * @return new Object[]
	 */
	public static Object[] addElement(Object[] oldArray, Object element) {
		return addElement(oldArray,element,oldArray.length);

	}
}
