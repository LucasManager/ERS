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
public class SetVesselForm extends ValidatorForm {
	/*
	 * Generated fields
	 */
	private String id;
	private String name ;
	private String simpleName;
	private String cname;
	private String callsign;
	private String lloyds ;
	private String svcname ;
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

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id.toUpperCase();
	}

	public String getLloyds() {
		return lloyds;
	}

	public void setLloyds(String lloyds) {
		this.lloyds = lloyds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSvcname() {
		return svcname;
	}

	public void setSvcname(String svcname) {
		this.svcname = svcname;
	}
}