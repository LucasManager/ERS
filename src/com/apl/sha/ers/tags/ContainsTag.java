package com.apl.sha.ers.tags;

import java.util.Map;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

public class ContainsTag extends ConditionalTagSupport {
	private Object key;

	private Map map;

	@Override
	protected boolean condition() throws JspTagException {
		if(key  instanceof String) {
			key=((String)key).toUpperCase();
		}
		if (map.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}
