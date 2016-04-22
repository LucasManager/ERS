/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.apl.sha.ers.exception.NoDataException;
import com.apl.sha.ers.model.User;

/** 
 * MyEclipse Struts
 * Creation date: 12-30-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/getDepotInfo.jsp"
 */
public class GetDepotInfoAction extends BaseAction {
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
		HttpSession session=request.getSession();
		String depotCode=request.getParameter("depotcode").toUpperCase();
		Map ctnTypes=(Map)session.getServletContext().getAttribute("ctntypes");
		try {
			session.setAttribute("depot", process.getDepot(depotCode,ctnTypes, (User)session.getAttribute("user")));
		} catch (NoDataException e) {
			return this.errorHandle(mapping, request, "error.object.notfound", new Object[] {"Depot", depotCode});
		}
		return mapping.findForward(success);
	}
}