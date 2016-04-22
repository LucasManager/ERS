<%@ page import="java.util.Date"%> 
<%@ page import="org.jfree.data.general.PieDataset"%> 
<%@ page import="org.jfree.chart.*"%> 
<%@ page import="org.jfree.chart.plot.*"%> 
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%> 
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%> 
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%> 
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%> 
<%@ page import="org.jfree.chart.labels.StandardPieSectionLabelGenerator"%> 
<%@ page import="java.io.*"%> 
<% 
StandardEntityCollection sec = new StandardEntityCollection(); 
ChartRenderingInfo info = new ChartRenderingInfo(sec); 	
PrintWriter w = new PrintWriter(out);//
ChartUtilities.writeImageMap(w, "map0", info, false); 
//System.out.println(new Date());
%> 
<img src="chart.jsp"></img>
