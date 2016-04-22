package com.apl.sha.ers.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Privs implements Serializable{
	private Map privs= new HashMap();
	
	public Privs(Map privs) {
		this.privs=privs;
	}
	
	public Privs(List list) {
		for(Iterator it=list.iterator();it.hasNext();) {
			Priv priv=(Priv)it.next();
			privs.put(priv.getPriv().toUpperCase(), priv);
		}
	}
	
	public Iterator iterator() {
		return privs.entrySet().iterator();
	}
	
	public Priv getPriv(String privname) {
		return (Priv)privs.get(privname.toUpperCase());
	}
	
	public boolean hasPriv(String privname) {
		return privs.containsKey(privname.toUpperCase());
	}
	
	public Map getPrivs() {
		return privs;
	}

	public void sort() {
		
	}

	@Override
	public String toString() {
		String str="";
		for(Iterator it=privs.keySet().iterator();it.hasNext();) {
			Priv priv=(Priv)privs.get((String)it.next());
			str=str+priv.toString()+";";
		}
		return str;
	}
	
}
