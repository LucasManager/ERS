/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.apl.sha.ers.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.apl.sha.ers.exception.DataException;
import com.apl.sha.ers.model.User;
import com.apl.sha.ers.util.DateUtil;

import java.util.*;
import java.util.Date;
import java.sql.*;
import javax.servlet.ServletOutputStream;

/** 
 * MyEclipse Struts
 * Creation date: 01-08-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/getCtnReport"
 */
public class GetCtnReportAction extends BaseAction {
	private static final String privname="GetCtnReportAction";
	private static final String datePattern="yyyy-MM-dd";
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
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward actionForward=this.checkPriv(mapping, request, privname);
		if(actionForward!=null) return actionForward ;
		HttpSession session=request.getSession();
		Date begDate=DateUtil.parseDate(request.getParameter("begDate"),datePattern);
		Date endDate=DateUtil.parseDate(request.getParameter("endDate"),datePattern);
		String vslCD=request.getParameter("vessel");
		String DepotCode=request.getParameter("localdepotcode");
		User user=(User)session.getAttribute("user");
	    try{
	        Vector vec;
	    	String fname = "CTN_DIST_REPORT";
	        ServletOutputStream os = response.getOutputStream();
	        
	        response.reset();
	        response.setHeader("Content-disposition", "attachment; filename=" + fname + ".xls");
	        //response.setContentType("application/msexcel");
	        response.setContentType("application/octet-stream");
	        String line = "<table border =1>";
            
            vec=process.getCtnList(user.getLocation(),vslCD,DepotCode,begDate,endDate);

	        Vector veccol = (Vector) vec.get(0);
	        int colcount = veccol.size();
	        int rowcount = vec.size();
	        int recordcount = rowcount-1;
	        os.write(line.getBytes());
	        line = "<tr><td colspan='3'><STRONG>TOTAL: " + recordcount + "</STRONG></td></tr>"; 
	        os.write(line.getBytes());	        
	        for (Integer i = 0; i < rowcount; i++) {
	        	line = "<tr>";
	            Vector vectmp = new Vector();
	            vectmp = (Vector) vec.get(i);
	            if(i.equals(0)){
	                for (int j = 0; j < colcount; j++) {
	                     line = line + "<th align='center' bgcolor='#C0C0C0' bordercolor='#FFFFFF'>" + vectmp.get(j) + "</th>";
	                }
	            }
	            else{
	            	for (int j = 0; j < colcount; j++) {
		                line = line + "<td nowrap>" + vectmp.get(j) + "</td>";
		            }
	            }
	            line = line + "</tr>";
	            os.write(line.getBytes());
	        }
	        line = "</table>"; 
	        os.write(line.getBytes());	
	        os.flush();
			os.close();
            
	      }catch(Exception e){
	        System.out.println(e);
	      }
		//return mapping.findForward(success);
		return null;
	}
}
