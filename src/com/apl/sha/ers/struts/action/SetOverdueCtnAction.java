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
import org.apache.struts.action.ActionMessages;

import com.apl.sha.ers.model.User;

/** 
 * MyEclipse Struts
 * Creation date: 06-26-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/booking.jsp"
 */
public class SetOverdueCtnAction extends BaseAction {
	private static final String privname="SetOverdueCtnAction";
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
		String vessel=request.getParameter("vessel_o");
		String voyage=request.getParameter("voyage_o");
		User user=(User) request.getSession().getAttribute("user");
		ActionMessages messages=new ActionMessages();
		ActionErrors errors = new ActionErrors();
		if(!voyage.trim().equalsIgnoreCase("")){
			if(!isNumeric(voyage.trim())){
				errors.add("setOverdueCtnError", new ActionMessage("errors.number",new Object[] {voyage}));
				this.addErrors(request, errors);
				return mapping.getInputForward();
			}			
		}
		
		if(process.setOverdueCtn(vessel, voyage, user)>0) {
			messages.add("setOverdueCtnMSG",new ActionMessage("message.success.displayname"));			
		}else {
			messages.add("setOverdueCtnMSG",new ActionMessage("error.overduectn.notfound"));			
		}
		this.saveMessages(request, messages);
		return mapping.findForward(success);
	}
	
	 public static boolean isNumeric(String number) { 
         try {
             Integer.parseInt(number);
             return true;
         }catch (NumberFormatException sqo) {
             return false;
         }
     }
	
}