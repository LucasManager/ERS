/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * MyEclipse Struts Creation date: 01-24-2007
 * 
 * XDoclet definition:
 * 
 * @struts.form name="setUserForm"
 */
public class SetBookingInfoForm extends ValidatorForm {
	/*
	 * Generated fields
	 */
	private int setBI_blnumber;
	private String setBI_blockcode;	
	/**
	 * Method validate
	 * 
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
		return errors;
	}

	/**
	 * Method reset
	 * 
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}

	public int getSetBI_blnumber() {
		return setBI_blnumber;
	}

	public void setSetBI_blnumber(int setBI_blnumber) {
		this.setBI_blnumber = setBI_blnumber;
	}

	public String getSetBI_blockcode() {
		return setBI_blockcode;
	}

	public void setSetBI_blockcode(String setBI_blockcode) {
		this.setBI_blockcode = setBI_blockcode;
	}




	
}