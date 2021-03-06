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
import org.jfree.chart.JFreeChart;

import com.apl.sha.ers.ERSChartFactory;
import com.apl.sha.ers.exception.NoDataException;
import com.apl.sha.ers.model.Depot;
import com.apl.sha.ers.model.DepotCtn;
import com.apl.sha.ers.model.User;

/** 
 * MyEclipse Struts
 * Creation date: 12-30-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/getDepotInfo.jsp"
 */
public class GetDepotAction extends BaseAction {
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
		Depot depot;
		User user=getUser(request);
		try {
			depot = process.getDepot(depotCode,ctnTypes, user);
		} catch (NoDataException e1) {
			return this.errorHandle(mapping, request, "error.object.notfound", new Object[] {"Depot", depotCode});
		}
		session.setAttribute("chart", getBarChart(
				this.getMessage(request, "depot.container.chart.title",new Object[] {depot.getDepotcode()}),
				depot.getContainers(),
				this.getMessage(request, "depot.container.chart.categoryaxis"),
				this.getMessage(request, "depot.container.chart.valueaxis"),
				session.getServletContext().getRealPath("/image/apl_chartlogo.gif"),
				this.getMessage(request, "depot.container.remainqty.displayname"),
				this.getMessage(request, "depot.container.reservedqty.displayname"),
				this.getMessage(request, "depot.container.pickupedqty.displayname")));
		session.setAttribute("depot", depot);
		return mapping.findForward(success);
	}
	
	private JFreeChart getPieChart(Map containers) {
		Map map=new TreeMap();
		for(Iterator it=containers.keySet().iterator();it.hasNext();) {
			String key=(String)it.next();
			DepotCtn ctn=(DepotCtn)containers.get(key);
			map.put(key, ctn.getInitalQty());
		}
		JFreeChart chart=ERSChartFactory.createPie3DChart("test", map);
		return chart;
	}
	
	private JFreeChart getBarChart(String title,Map containers,String categoryaxis, String valueaxis, String bgImagePath,String remain,String reserved, String pickuped) {
		int size=containers.size()*3;
		Number[] data=new Number[size]; 
		Comparable[] rowkey=new Comparable[size]; 
		Comparable[] colkey=new Comparable[size];
		int i=0;
		for(Iterator it=containers.keySet().iterator();it.hasNext();) {
			String key=(String)it.next();
			DepotCtn ctn=(DepotCtn)containers.get(key);
			rowkey[i]=remain;
			colkey[i]=key;
			data[i]=ctn.getInitalQty()-ctn.getPickupedQty()-ctn.getReservedQty();
			rowkey[++i]=reserved;
			colkey[i]=key;
			data[i]=ctn.getReservedQty();
			rowkey[++i]=pickuped;
			colkey[i]=key;
			data[i]=ctn.getPickupedQty();
			i++;
		}
		if(ERSChartFactory.getBackgroundimage()==null) {
			ERSChartFactory.setBackgroundimage(bgImagePath);
		}
		JFreeChart chart=ERSChartFactory.createStackedBar3DChart(title,categoryaxis,valueaxis, data, rowkey, colkey);
		return chart;
	}
}