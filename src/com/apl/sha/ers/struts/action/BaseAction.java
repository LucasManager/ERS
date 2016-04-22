package com.apl.sha.ers.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.apl.sha.ers.Processing;
import com.apl.sha.ers.model.User;

abstract public class BaseAction extends Action {

	private final static String error = "error";
	private final static String login = "login";
	private final static String pagePath ="pagepath";
	private final static String homePath="/home.jsp";
	protected final static String success= "success";
	
	protected Processing process;

	public Processing getProcess() {
		return process;
	}

	public void setProcess(Processing process) {
		this.process = process;
	}

	protected ActionForward errorHandle(ActionMapping mapping,
			HttpServletRequest request, String message, Object[] objects) {
		ActionErrors errors = new ActionErrors();
		errors.add(error, new ActionMessage(message, objects));
		this.addErrors(request, errors);
		String returnPath=request.getParameter(pagePath);
		if(returnPath==null||returnPath.equalsIgnoreCase("")) {
			returnPath=mapping.getInput();
		}
		if(returnPath==null||returnPath.equalsIgnoreCase("")) {
			returnPath=request.getHeader("Referer");
		}
		returnPath=(returnPath==null||returnPath.substring(returnPath.length()-3).equalsIgnoreCase(".do"))?homePath:returnPath;
		request.setAttribute("returnPath", returnPath);
		return mapping.findForward(error);
		
	}

	protected ActionForward errorHandle(ActionMapping mapping,
			HttpServletRequest request, String message) {
		return errorHandle(mapping, request, message, null);
	}
	
	protected ActionForward cancelHandle(ActionMapping mapping,
			HttpServletRequest request, String defaultPath) {
		String returnPath=(String)request.getSession(false).getAttribute("returnPath");
		request.getSession(false).removeAttribute("returnPath");
		returnPath=(returnPath==null)?defaultPath:returnPath;
		if(returnPath==null) {
			return mapping.getInputForward();
		}
		return new ActionForward(returnPath,true);
	}
	protected void setReturnPath(HttpServletRequest request,String defaultPath) {
		String returnPath=request.getParameter(pagePath);
		if(returnPath==null){
			returnPath=defaultPath;
		}
		request.getSession(false).setAttribute("returnPath", returnPath);
	}
	protected ActionForward checkLogin(ActionMapping mapping, HttpServletRequest request) {
		if(request.getSession().getAttribute("user")==null) {
			return mapping.findForward(login);
		}
		return null;
	}
	protected ActionForward checkPriv(ActionMapping mapping, HttpServletRequest request, String privname) {
/*		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return mapping.findForward(login);
		if (!user.getPrivs().hasPriv(privname))
			return this.errorHandle(mapping,request,"error.priv.required");
		return null;*/
		return checkPriv(mapping, request, privname, null);
	}
	protected ActionForward checkPriv(ActionMapping mapping, HttpServletRequest request, String privname,String param) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return mapping.findForward(login);
		if (!user.getPrivs().hasPriv(privname))
			return this.errorHandle(mapping,request,"error.priv.required");
		if(param!=null&&!user.getPrivs().getPriv(privname).getParam().contains(param)) {
			return this.errorHandle(mapping,request,"error.priv.required");
		}
		return null;
	}
	protected ActionForward addForwardParameter(ActionForward forward, String paramName, String param) {
		StringBuffer path=new StringBuffer(forward.getPath());
		boolean isQuery=(path.indexOf("?")>=0);
		if(isQuery)
			path.append("&"+paramName+"="+param);
		else
			path.append("?"+paramName+"="+param);
		return new ActionForward(path.toString(),forward.getRedirect());
	}
	protected String getMessage(HttpServletRequest request,String key) {
		return this.getMessage(request, key, null);
	}
	protected String getMessage(HttpServletRequest request,String key, Object[] objects) {
		return this.getResources(request).getMessage(this.getLocale(request),key,objects);
	}
	protected User getUser(HttpServletRequest request) {
		return (User)request.getSession().getAttribute("user");
	}
}
