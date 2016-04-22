<%@ page import="java.util.Date"%> 
<%@ page import="org.jfree.data.general.PieDataset"%> 
<%@ page import="org.jfree.chart.*"%> 
<%@ page import="org.jfree.chart.plot.*"%> 
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%> 
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%> 
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%> 
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%> 
<%@ page import="org.jfree.chart.labels.StandardPieSectionLabelGenerator"%> 
<%@ page import="org.jfree.util.TableOrder"%> 
<%@ page import="java.io.*"%> 
<%@ page import="java.awt.*"%> 


<% 
int width=450;
int height=500;
int span=100;
span=(request.getParameter("span")==null)?span:Integer.parseInt(request.getParameter("span"));
JFreeChart chart=(JFreeChart) session.getAttribute("chart");
//System.out.println(new Date());
StandardEntityCollection sec = new StandardEntityCollection(); 
ChartRenderingInfo info = new ChartRenderingInfo(sec); 	
MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
height=plot.getDataset().getColumnCount()*span;
span=(request.getParameter("span")==null)?span:Integer.parseInt(request.getParameter("span"));
int items=plot.getDataset().getRowCount();
//if(plot.getDataExtractOrder==TableOrder.BY_COLUMN){
	width=(request.getParameter("width")==null)?width:Integer.parseInt(request.getParameter("width"));
	height=100+items*span;
//}else{
//	height=(request.getParameter("height")==null)?height:Integer.parseInt(request.getParameter("height"));
//	width=100+items*span;
//}
//plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
PiePlot piePlot=(PiePlot)plot.getPieChart().getPlot();
piePlot.setForegroundAlpha(0.4f);
piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: ({1}, {2})"));
piePlot.setIgnoreNullValues(true);
//piePlot.setExplodePercent("DRY4086ANN",0.1D);
//piePlot.setNoDataMessage("No Data");
//piePlot.setStartAngle(0.2);
//plot.setForegroundAlpha(0.1f);
//plot.setForegroundAlpha(0.7f);
//Paint paint=new GradientPaint(0,0,Color.WHITE,width,height,Color.decode("#b9d1f4"));
//chart.setBackgroundPaint(paint);
ChartUtilities.writeChartAsPNG(response.getOutputStream(),chart,width,height,info);
out.clear();
out = pageContext.pushBody();
//System.out.println(new Date());
%> 

