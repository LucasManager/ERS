/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.apl.sha.ers.exception.DataException;
import com.apl.sha.ers.model.Booking;
import com.apl.sha.ers.model.BookingCtn;
import com.apl.sha.ers.model.User;
import com.apl.sha.ers.struts.form.SetBookingCtnForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-02-2007
 * 
 * XDoclet definition:
 * @struts.action path="/setBookingCtn" name="setBookingCtnForm" input="/setBookingCtn.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/getBookingCtn.jsp"
 */
public class SetBookingCtnAction extends BaseAction {
	private static final String errorTag="error";
	private static final String cancelPath="/getBookingCtn.jsp";
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
		ActionForward actionForward=this.checkPriv(mapping, request, this.getClass().getSimpleName());
		if(actionForward!=null) return actionForward ;
		SetBookingCtnForm setBookingCtnForm = (SetBookingCtnForm) form;
		Map newCtnsCodeVolume=new HashMap();
		Map newCtns=convertFromForm(setBookingCtnForm,newCtnsCodeVolume);
		HttpSession session=request.getSession();
		Booking booking=(Booking)session.getAttribute("booking");
		Map oldCtnsCodeVolume=getCtnCodeVolume(booking.getCtns(), "R");
		if(!matchCtnCodeVolume(oldCtnsCodeVolume, newCtnsCodeVolume)) {
			ActionErrors errors = new ActionErrors();
			errors.add(errorTag, new ActionMessage("error.booking.ctn.update.unmatched"));
			addErrors(request, errors);
			return mapping.getInputForward();
		}
		User user=getUser(request);
		try {
			process.setBookingCtns(booking, newCtns, user);
		} catch (DataException e) {
			e.printStackTrace();
		}
		return this.addForwardParameter(mapping.findForward(success),"blnumber",Integer.toString(booking.getBlnumber()));
	}
	
	private Map convertFromForm(SetBookingCtnForm form, Map newCtnsCodeVolume){
		Map ctns=new TreeMap();
		for(Iterator it=form.getRowIdList().iterator();it.hasNext();) {
			String key=(String)it.next();
			if(form.getAttribute(key+"_checked")!=null){
				BookingCtn ctn=new BookingCtn();
				String ctnCode=(String)form.getAttribute(key+"_ctnCode");
				ctn.setCtnCode(ctnCode);
				ctn.setIntlcode((String)form.getAttribute(key+"_intlCode"));
				ctn.setDepotCode((String)form.getAttribute(key+"_depotCode"));
				int ctnQty=Integer.parseInt((String) form.getAttribute(key+"_ctnQty"));
				ctn.setCtnQty(ctnQty);
				ctns.put(key, ctn);
				if(newCtnsCodeVolume.get(ctnCode)==null) {
					newCtnsCodeVolume.put(ctnCode, ctnQty);
				}else {
					newCtnsCodeVolume.put(ctnCode, (Integer)newCtnsCodeVolume.get(ctnCode)+ctnQty);
				}
			}
		}
		return ctns;
	}
	
	private boolean matchCtnCodeVolume(Map oldCtns, Map newCtns) {
		if(oldCtns.size()!=newCtns.size()) {
			return false;
		}
		for(Iterator it=oldCtns.keySet().iterator();it.hasNext();) {
			String key=(String)it.next();
			if(newCtns.get(key)==null) {
				return false;
			}
			if(oldCtns.get(key)!=newCtns.get(key)) {
				return false;
			}
		}
		return true;
	}
	
	private Map getCtnCodeVolume(Map ctns,String status) {
		Map map=new HashMap();
		for(Iterator it=ctns.keySet().iterator();it.hasNext();) {
			int key=(Integer)it.next();
			BookingCtn ctn=(BookingCtn)ctns.get(key);
			if(ctn.getStatus().equals(status)) {
				String ctnCode=ctn.getCtnCode();
				int ctnQty=ctn.getCtnQty();
				if(map.get(ctnCode)==null) {
					map.put(ctnCode, ctnQty);
				}else {
					map.put(ctnCode, (Integer)map.get(ctnCode)+ctnQty);
				}
			}
		}
		return map;
	}
}