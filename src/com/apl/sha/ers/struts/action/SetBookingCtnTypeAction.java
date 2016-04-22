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

import com.apl.sha.ers.model.Booking;
import com.apl.sha.ers.model.BookingCtn;
import com.apl.sha.ers.model.User;
import com.apl.sha.ers.struts.form.SetBookingCtnForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-27-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/getBookingCtn.jsp"
 */
public class SetBookingCtnTypeAction extends BaseAction {
	private static final String cancelPath="/getBookingCtn.jsp";
	private static final String privName="SetBookingCtnAction";
	
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
		if(isCancelled(request)) {
			return cancelHandle(mapping,request,cancelPath);
		}
		ActionForward actionForward=this.checkPriv(mapping, request, privName);
		if(actionForward!=null) return actionForward ;
		SetBookingCtnForm sForm=(SetBookingCtnForm) form;
		Map ctns=new TreeMap();
		for(Iterator it=sForm.getRowIdList().iterator();it.hasNext();) {
			String key=(String)it.next();
			if(sForm.getAttribute(key+"_checked")!=null){
				BookingCtn ctn=new BookingCtn();
				String ctnCode=(String)sForm.getAttribute(key+"_ctnCode");
				ctn.setCtnCode(ctnCode);
				ctn.setIntlcode((String)sForm.getAttribute(key+"_intlCode"));
//				ctn.setDepotCode((String)sForm.getAttribute(key+"_depotCode"));
				int ctnQty=Integer.parseInt((String) sForm.getAttribute(key+"_ctnQty"));
				ctn.setCtnQty(ctnQty);
				ctns.put(key, ctn);
			}
		}
		HttpSession session=request.getSession();
		Booking booking=(Booking)session.getAttribute("booking");
		booking.setCtns(ctns);
		User user=this.getUser(request);
		process.setBookingCtnType(booking, user);
		return this.addForwardParameter(mapping.findForward(success),"blnumber",Integer.toString(booking.getBlnumber()));
	}
}