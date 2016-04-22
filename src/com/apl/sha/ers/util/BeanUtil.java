package com.apl.sha.ers.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {
	public static Object copyProperties(Object src,Object dest) {
		Field[] fs = null;
		if(src.getClass().getDeclaredFields().length<dest.getClass().getDeclaredFields().length) {
			fs=src.getClass().getDeclaredFields();
		}else {
			fs=dest.getClass().getDeclaredFields();
		}
		for (int i = 0; i < fs.length; i++) {
//			String type = fs[i].getType().getSimpleName();
			String name = fs[i].getName();
//			String methodName = "set" + Util.initCap(name);
//			if(dest.getClass().getMethod(methodName,))
			try {
				BeanUtils.copyProperty(dest, name, BeanUtils.getProperty(src, name));
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			} catch (NoSuchMethodException e) {
			} catch (IllegalArgumentException e) {
			}
		}
		return dest;
	}
	
	public static Object cloneBean(Object bean) {
		Object newBean=null;
		try {
			newBean=BeanUtils.cloneBean(bean);
		} catch (IllegalAccessException e) {
		} catch (InstantiationException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		}
		return newBean;
	}
}
