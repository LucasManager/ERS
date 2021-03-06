/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.action;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.opensymphony.oscache.web.ServletCacheAdministrator;

import com.apl.sha.ers.exception.DataException;
import com.apl.sha.ers.model.CtnType;

/** 
 * MyEclipse Struts
 * Creation date: 06-28-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/home.jsp"
 */
public class RefreshCacheAction extends BaseAction {
	
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
		HttpSession session=request.getSession();
		session.getServletContext().setAttribute("vessels", process.getVessels());
		Map ctnTypes=process.getCtnTypes();
		session.getServletContext().setAttribute("ctntypes", ctnTypes);
		Map ctnCodes=new TreeMap();
		for(Iterator it=ctnTypes.keySet().iterator();it.hasNext();) {
			CtnType ctype=(CtnType) ctnTypes.get(it.next());
			ctnCodes.put(ctype.getCtncode(), ctype.getCtncode());
		}
		session.getServletContext().setAttribute("ctncodes", ctnCodes);
		try {
			session.getServletContext().setAttribute("alldepots", process.getDepots(""));
			session.getServletContext().setAttribute("users", process.getUsers());
		} catch (DataException e) {
		}
		ServletCacheAdministrator scAdmin= ServletCacheAdministrator.getInstance(session.getServletContext());
		scAdmin.flushAll();
		ActionMessages messages=new ActionMessages();
		messages.add("refreshCacheMSG",new ActionMessage("message.success.displayname"));
		this.saveMessages(request, messages);
		return mapping.findForward(success);
	}
}