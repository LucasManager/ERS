/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.apl.sha.ers.exception.NonUniqueDataException;
import com.apl.sha.ers.model.CtnType;
import com.apl.sha.ers.model.OneWayCtn;
import com.apl.sha.ers.model.User;

/** 
 * MyEclipse Struts
 * Creation date: 01-21-2008
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/getOneWayCtns.do" redirect="true"
 */
public class SetOneWayCtnAction extends BaseAction {
	private static final String errorTag="error";
	private static final String cancelPath="/getOneWayCtns.jsp";
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
		if(request.getParameter("org.apache.struts.taglib.html.CANCEL")!=null) {
			return cancelHandle(mapping,request,cancelPath);
		}
		ActionForward actionForward=this.checkPriv(mapping, request, this.getClass().getSimpleName());
		if(actionForward!=null) return actionForward ;
		User user=this.getUser(request);
		OneWayCtn owc=this.getOneWayCtn(request);
		try {
			process.setOneWayCtns(owc, user);
		} catch (NonUniqueDataException e) {
			ActionErrors errors = new ActionErrors();
			errors.add(errorTag, new ActionMessage("error.duplicate",owc));
			addErrors(request, errors);
			return mapping.getInputForward();
		}
		return this.addForwardParameter(mapping.findForward(success),"ctnCode",owc.getCtnCode());
	}
	private OneWayCtn getOneWayCtn(HttpServletRequest request) {
		OneWayCtn owc=new OneWayCtn();
		owc.setId(Integer.parseInt(request.getParameter("id")));
		owc.setLocation(request.getParameter("location"));
		owc.setCtnCode(request.getParameter("ctnCode"));
		owc.setDest(request.getParameter("dest").toUpperCase());
		owc.setDepotCode(request.getParameter("depotCode"));
		owc.setStatus(Boolean.parseBoolean(request.getParameter("status")));
		owc.setOremark(request.getParameter("oremark"));
		return owc;
	}
}