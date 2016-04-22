package com.apl.sha.ers.spring.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.springframework.aop.AfterReturningAdvice;

import com.apl.sha.ers.db.DBProcess;
import com.apl.sha.ers.model.User;
public class Advisor implements AfterReturningAdvice{
	private static String ipAddress="";
	private DBProcess db;

	public DBProcess getDb() {
		return db;
	}

	public void setDb(DBProcess db) {
		this.db = db;
	}
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
//		System.out.println(method.getName());
		String type="Info";
		String function=method.getName();
		Date eventime=new Date();
		int userID=0;
		if (args[args.length-1] instanceof User) {
			userID=((User)args[args.length-1]).getUserid();
		}
		String event="";
		for(int i=0;i<args.length-1;i++) {
			String objStr=args[i].toString();
			if(args[i].getClass().isArray()) {
				if(args[i].getClass().getComponentType().getSimpleName().equalsIgnoreCase("int")) {
					objStr="";
					int[] array=(int[])args[i];  
					for(int j=0;j<array.length;j++) {
						objStr=objStr+array[j]+",";
					}
				}
			}else if(args[i] instanceof Map) {
				objStr="";
				Map map=(Map)args[i];
				for(Iterator it=map.keySet().iterator();it.hasNext();) {
					objStr=objStr+map.get(it.next())+",";
				}
			}
			event=event+objStr+";";
		}
		if(event.length()>200)event=event.substring(0, 200);
		String comments="";
		db.setLog(userID, function, event, eventime, type, ipAddress, comments);
	}

}
