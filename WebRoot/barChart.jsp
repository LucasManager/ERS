<%@ page import="java.util.Date"%> 
<%@ page import="org.jfree.data.category.CategoryDataset"%> 
<%@ page import="org.jfree.ui.* "%> 
<%@ page import="org.jfree.util.*"%> 
<%@ page import="org.jfree.chart.*"%> 
<%@ page import="org.jfree.chart.labels.*"%> 
<%@ page import="org.jfree.chart.plot.*"%> 
<%@ page import="org.jfree.chart.annotations.*"%> 
<%@ page import="org.jfree.chart.renderer.category.*"%> 
<%@ page import="org.jfree.chart.axis.*"%> 
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%> 
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%> 
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%> 
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%> 
<%@ page import="org.jfree.chart.labels.StandardPieSectionLabelGenerator"%> 
<%@ page import="java.io.*"%> 
<%@ page import="java.awt.*"%> 
<%@ page import="javax.swing.*"%> 
<%@ page import="java.text.NumberFormat"%> 
<% 
JFreeChart chart=(JFreeChart)session.getAttribute("chart");
//Date date=new Date();
//	chart.setBackgroundPaint(Color.YELLOW);
StandardEntityCollection sec = new StandardEntityCollection(); 
ChartRenderingInfo info = new ChartRenderingInfo(sec); 	
CategoryPlot plot = chart.getCategoryPlot();
int width=300;
int height=400;
int span=15;
span=(request.getParameter("span")==null)?span:Integer.parseInt(request.getParameter("span"));
int items=plot.getDataset().getColumnCount()*plot.getDataset().getRowCount();
if(plot.getOrientation()==PlotOrientation.HORIZONTAL){
	width=(request.getParameter("width")==null)?width:Integer.parseInt(request.getParameter("width"));
	height=100+items*span;
}else{
	height=(request.getParameter("height")==null)?height:Integer.parseInt(request.getParameter("height"));
	width=100+items*span;
}
		//CategoryAxis domainAxis = plot.getDomainAxis();
		//domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
		//domainAxis.setLabelAngle(1.57);
//		domainAxis.setLabelInsets(new RectancleInsets )
	//	plot.setDomainAxis(domainAxis);
//	chart.getLegend().setPosition(RectangleEdge.);
//plot.getRenderer().setShape(new ShapeList().getShape(4));
Paint paint=new GradientPaint(0,0,Color.WHITE,width,height,Color.decode("#b9d1f4"));
chart.setBackgroundPaint(paint);
ChartUtilities.writeChartAsPNG(response.getOutputStream(),chart,width,height,info);
out.clear();
out = pageContext.pushBody();
//System.out.println(new Date().getTime()-date.getTime());
%> 

