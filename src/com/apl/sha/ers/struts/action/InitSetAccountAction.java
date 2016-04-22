/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.apl.sha.ers.exception.LoginException;
import com.apl.sha.ers.model.User;
import com.apl.sha.ers.struts.form.SetUserForm;
import com.apl.sha.ers.util.BeanUtil;
import com.apl.sha.ers.util.DateUtil;

/** 
 * MyEclipse Struts
 * Creation date: 01-24-2007
 * 
 * XDoclet definition:
 * @struts.action path="/initSetAccount" name="initSetAccountForm" scope="request"
 * @struts.action-forward name="success" path="/setAccount.jsp"
 */
public class InitSetAccountAction extends BaseAction {
	private static final String adminPrivName="AdminAccountAction";
	private static final String setPrivName="SetAccountAction";
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=this.checkLogin(mapping, request);
		if(actionForward!=null) return actionForward ;
		String username=request.getParameter("paramUsername");
		User optuser = this.getUser(request);
		User user=null;
		String forwardPath="";
		if(username==null||username.equalsIgnoreCase("")) {
			actionForward=this.checkPriv(mapping, request, setPrivName);
			if(actionForward!=null) return actionForward ;
			user=getUser(request);
			forwardPath="setAccount";
		}else {
			actionForward=this.checkPriv(mapping, request, adminPrivName);
			if(actionForward!=null) return actionForward ;
			try {
				forwardPath="adminAccount";
				//user=process.getUser(username.toLowerCase(), username, false);
				user=process.getUserForAdmin(username.toLowerCase(), optuser);
			} catch (LoginException e) {
				ActionErrors errors = new ActionErrors();
				int errCode=e.getStatus();
				if(errCode==-1) {
						errors.add("paramUsername", new ActionMessage("error.object.notfound",getMessage(request, "user.username.displayname") ,username));
				}
				this.addErrors(request, errors);
				return mapping.findForward(forwardPath);
			}
		}
		SetUserForm initSetAccountForm = (SetUserForm) form;		
		BeanUtil.copyProperties(user, initSetAccountForm);
		initSetAccountForm.setUsergroup(user.getUsergroup().getGroupid());
		initSetAccountForm.setCreatetime(DateUtil.format(user.getCreatetime(),"datetime"));
		initSetAccountForm.setUpdatetime(DateUtil.format(user.getUpdatetime(), "datetime"));
		initSetAccountForm.setCfmpwd(user.getPwd());
		
		//editted by jelly
		initSetAccountForm.setPwd("*#apluser657");
		initSetAccountForm.setCfmpwd("*#apluser657");
		
		return mapping.findForward(forwardPath);
	}
}