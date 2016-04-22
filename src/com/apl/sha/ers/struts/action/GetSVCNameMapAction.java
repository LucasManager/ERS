/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.apl.sha.ers.model.OneWayCtn;
import com.apl.sha.ers.model.User;

/** 
 * MyEclipse Struts
 * Creation date: 01-15-2008
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/getOneWayCtns.jsp"
 */
public class GetSVCNameMapAction extends BaseAction {
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
		ActionForward actionForward=this.checkPriv(mapping, request, this.getClass().getSimpleName());
		if(actionForward!=null) return actionForward ;
		request.getSession().setAttribute("SVCNameMaps",process.getSVCNameMap());
		return mapping.findForward(success);
	}
	
}