package com.apl.sha.ers.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.apl.sha.ers.exception.NoDataException;
import com.apl.sha.ers.model.User;
import com.apl.sha.ers.util.DateUtil;

import com.apl.sha.ers.struts.form.getPendingCtnForm;

public class GetPendingCtnAction extends BaseAction {
	private static final String datePattern="yyyy-MM-dd";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=this.checkPriv(mapping, request, this.getClass().getSimpleName());
		if(actionForward!=null) return actionForward ;
		List PendingCtn;
		getPendingCtnForm pendingctnform = (getPendingCtnForm) form;
		User user=getUser(request);
		Date begDate=DateUtil.parseDate(pendingctnform.getBegPassedDate(),datePattern);
		Date endDate=DateUtil.parseDate(pendingctnform.getEndPassedDate(),datePattern);
		try {
			PendingCtn = process.getPendingCtn(user, begDate, endDate);
		} catch (NoDataException e) {
			ActionErrors errors = new ActionErrors();
			errors.add("getPendingCtnError", new ActionMessage("error.getpendingctn.nodata"));
			this.addErrors(request, errors);
			return mapping.getInputForward();
		}
		request.getSession().setAttribute("PendingCtns",PendingCtn );
		return mapping.findForward(success);
	}
	
	
	
	
	
	
	
}