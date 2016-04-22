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
JFreeChart chart=(JFreeChart) session.getAttribute("chart");
//System.out.println(new Date());
StandardEntityCollection sec = new StandardEntityCollection(); 
ChartRenderingInfo info = new ChartRenderingInfo(sec); 	
PiePlot plot=(PiePlot)chart.getPlot();
plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: ({1}ctn, {2})"));
ChartUtilities.writeChartAsPNG(response.getOutputStream(),chart,500,400,info);
//System.out.println(new Date());
%> 

