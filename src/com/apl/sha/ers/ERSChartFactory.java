package com.apl.sha.ers;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.Align;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.TableOrder;


public abstract class ERSChartFactory {
	private static String backgroundimage;
	
	public static String getBackgroundimage() {
		return backgroundimage;
	}

	public static void setBackgroundimage(String backgroundimage) {
		ERSChartFactory.backgroundimage = backgroundimage;
	}

	public static JFreeChart createMultiplePie3DChart(String title, Comparable[] rowkey, Comparable[] colkey, Number[] data) {
//		DefaultPieDataset dataset = new DefaultPieDataset();
//		double[][] data=new double[map.][];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < data.length; i++) {
			dataset.addValue(data[i], rowkey[i], colkey[i]);
		}
//		CategoryDataset dataset = DatasetUtilities.createCategoryDataset();
		/*for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			Number value = (Number) map.get(key);
			dataset.setValue(key, value);
		}*/
		JFreeChart chart = ChartFactory.createMultiplePieChart3D(title, dataset, TableOrder.BY_ROW, true, true, false);
		ImageIcon imageIcon=new ImageIcon(backgroundimage);
		chart.setBackgroundImage(imageIcon.getImage());
		chart.setBackgroundImageAlignment(Align.TOP_LEFT);
		chart.getTitle().setPaint(Color.GRAY);
		return chart;
	}

	public static JFreeChart createPie3DChart(String title, Map map) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			Number value = (Number) map.get(key);
			dataset.setValue(key, value);
		}
		JFreeChart chart = ChartFactory.createPieChart3D(title,
				dataset, true, true, true);
		return chart;
	}
	
	public static JFreeChart createStackedBar3DChart(String title, String rowname,
			String colname, Number[] data, Comparable[] rowkey,
			Comparable[] colkey) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < data.length; i++) {
			dataset.addValue(data[i], rowkey[i], colkey[i]);
		}
		JFreeChart chart = ChartFactory.createStackedBarChart3D(title, rowname,
				colname, dataset, PlotOrientation.HORIZONTAL, true, true, true);
		ImageIcon imageIcon=new ImageIcon(backgroundimage);
		chart.setBackgroundImage(imageIcon.getImage());
		chart.setBackgroundImageAlignment(Align.TOP_LEFT);
		chart.getTitle().setPaint(Color.GRAY);
		chart.getTitle().setPadding(5,50,1,1);
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelsVisible(true);
		domainAxis.setVisible(true);
		domainAxis.setTickMarksVisible(false);
			//domainAxis.setCategoryMargin(0.1);
			//domainAxis.setUpperMargin(0.1);
//		plot.setDomainAxis(domainAxis);
		//ValueAxis rangeAxis = plot.getRangeAxis();
		//Set the distance between highest Item and picture top 
			//rangeAxis.setUpperMargin(0.15);
		//Set the distance between lowest Item and picture top 
			//rangeAxis.setLowerMargin(0.15);
		//plot.setRangeAxis(rangeAxis);
		
/*		2D
 * 		GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
 */
		CategoryItemRenderer renderer=plot.getRenderer();
		renderer.setBaseOutlinePaint(Color.BLACK);
		// bar color
			//renderer.setSeriesPaint(0, new Color(0, 0, 255));
			//renderer.setSeriesPaint(1, new Color(0, 100, 255));
			//renderer.setSeriesPaint(2, Color.GREEN);
		// parallel bar distance
		// renderer.setItemMargin(0.1);
		// show item value
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",NumberFormat.getNumberInstance(),NumberFormat.getPercentInstance()));
		renderer.setItemLabelsVisible(true);
			//renderer.setItemLabelFont(Font.);
//		plot.setRenderer(renderer);
		//bar transparency
		plot.setForegroundAlpha(0.6f);
			//plot.setBackgroundAlpha(0.5f);
		//Set axis and legend position
			//plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
			//plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
		chart.getLegend().setMargin(1,1,5,1);
		return chart;
	}
	public static JFreeChart createBar3DChart(String title, String rowname,
			String colname, Number[] data, Comparable[] rowkey,
			Comparable[] colkey) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < data.length; i++) {
			dataset.addValue(data[i], rowkey[i], colkey[i]);
		}
		JFreeChart chart = ChartFactory.createStackedBarChart3D(title, rowname,
				colname, dataset, PlotOrientation.HORIZONTAL, true, true, true);
		ImageIcon imageIcon=new ImageIcon(backgroundimage);
		chart.setBackgroundImage(imageIcon.getImage());
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelsVisible(true);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		domainAxis.setVisible(true);
		domainAxis.setTickMarksVisible(false);
			//domainAxis.setCategoryMargin(0.1);
			//domainAxis.setUpperMargin(0.1);
			//domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
			//domainAxis.setLabelAngle(1.57);
		//plot.setDomainAxis(domainAxis);
		//ValueAxis rangeAxis = plot.getRangeAxis();
		//Set the distance between highest Item and picture top 
			//rangeAxis.setUpperMargin(0.15);
		//Set the distance between lowest Item and picture top 
			//rangeAxis.setLowerMargin(0.15);
			//plot.setRangeAxis(rangeAxis);
		
		BarRenderer renderer = new BarRenderer3D();
		renderer.setBaseOutlinePaint(Color.BLACK);
		// bar color
			//renderer.setSeriesPaint(0, new Color(0, 0, 255));
			//renderer.setSeriesPaint(1, new Color(0, 100, 255));
			//renderer.setSeriesPaint(2, Color.GREEN);
		// parallel bar distance
		renderer.setItemMargin(0.1);
		// show item value
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",NumberFormat.getNumberInstance(),NumberFormat.getPercentInstance()));
		renderer.setItemLabelsVisible(true);
			//renderer.setItemLabelFont(Font.);
		plot.setRenderer(renderer);
		//bar transparency
		plot.setForegroundAlpha(0.6f);
			//plot.setBackgroundAlpha(0.5f);
		//Set axis and legend position
			//plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
			//plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
			chart.getLegend().setPosition(RectangleEdge.TOP);

		return chart;
	}
}
