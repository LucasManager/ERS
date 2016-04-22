package com.apl.sha.ers.tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import com.apl.sha.ers.model.User;

public class PrivTag extends ConditionalTagSupport {
	private static final String userStr="user";
	private String privName;
	private String privParam;
	private boolean caseExist=true;
	@Override
	protected boolean condition() throws JspTagException {
		boolean result=false;
		User user=(User)pageContext.getSession().getAttribute(userStr);
		if (user.getPrivs().hasPriv(privName)){
			if(privParam!=null&&!user.getPrivs().getPriv(privName).getParam().contains(privParam)) {
				result=false;
			}else {
				result=true;
			}
		} else {
			result=false;
		}
		if(!caseExist) {
			result=!result;
		}
		return result;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	public void setPrivParam(String privParam) {
		this.privParam = privParam;
	}

	public void setCaseExist(boolean caseExist) {
		this.caseExist = caseExist;
	}

}
