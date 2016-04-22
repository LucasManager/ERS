package com.apl.sha.ers.struts.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.struts.validator.ValidatorForm;

public class MapForm extends ValidatorForm {
	private Map map = new TreeMap();

	public void setMap(Map map) {
		this.map = map;
	}

	public Map getMap() {
		return this.map;
	}

	public void setAttribute(String attributeKey, Object attributeValue) {
		map.put(attributeKey, attributeValue);
	}

	public Object getAttribute(String attributeKey) {
		Object keyValue = map.get(attributeKey);
		return keyValue;
	}
	public Collection getRowIdList(String rowPrefix) {
		if (map.isEmpty())
			return new ArrayList();
		Collection allRowId = new TreeSet();
		for (Iterator it = map.keySet().iterator();it.hasNext();) 
		{
			String key = (String) it.next();
			if (key.indexOf(rowPrefix) != -1) {
				key = key.substring(0, key.indexOf('_'));
				allRowId.add(key);
			}
		}
		return allRowId;
	}
	public Collection getRowIdList() {
		return getRowIdList("");
	}
}
