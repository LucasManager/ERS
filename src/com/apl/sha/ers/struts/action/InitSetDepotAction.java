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

import com.apl.sha.ers.model.Depot;
import com.apl.sha.ers.model.User;
import com.apl.sha.ers.struts.form.SetDepotForm;
import com.apl.sha.ers.util.BeanUtil;

/** 
 * MyEclipse Struts
 * Creation date: 01-11-2007
 * 
 * XDoclet definition:
 * @struts.action path="/initSetDepot" name="initSetDepotForm" input="/form/initSetDepot.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/setDepot.jsp"
 */
public class InitSetDepotAction extends BaseAction {
	private static final String privname="SetDepotAction";
	private static final String returnPath="/depot.jsp";
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
		ActionForward actionForward=this.checkPriv(mapping, request, privname);
		if(actionForward!=null) return actionForward ;
		HttpSession session=request.getSession(false);
		SetDepotForm initSetDepotForm = (SetDepotForm) form;
		String depotcode=request.getParameter("depotcode");
		Depot depot=new Depot();
		if(depotcode==null) {
			User user=(User)session.getAttribute("user");
			depot.setLocation(user.getLocation());
//			session.setAttribute("returnpath", "/depot.jsp");
		}else {
			depot=(Depot)session.getAttribute("depot");
			if(depot==null||!depot.getDepotcode().equals(depotcode)) {
				Map map=(Map)session.getAttribute("depots");
				depot=(Depot)map.get(depotcode);
			}
//			session.setAttribute("returnpath","/getDepot.jsp");
		}
		convertToForm(depot,initSetDepotForm);
		setReturnPath(request, returnPath);
		return mapping.findForward(success);
	}
	
	private void convertToForm(Depot depot,SetDepotForm form) {
		/*form.setId(depot.getId());
		form.setDepotcode(depot.getDepotcode());
		form.setLocation(depot.getLocation());
		form.setEname(depot.getEname());
		form.setCname(depot.getCname());
		form.setTel(depot.getTel());
		form.setEaddress(depot.getEaddress());
		form.setCaddress(depot.getCaddress());
		form.setContact(depot.getContact());
		form.setEmail(depot.getEmail());*/
		BeanUtil.copyProperties(depot, form);
	}
}