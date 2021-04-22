package main.java;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import analysis.java.Result;

/**
 * Class representing the bar graph viewer.
 * @author Group18
 */
public class BarGraph extends ApplicationFrame {

	private String chartTitle;

	/**
	 * Constructor for bar graph
	 * @param result
	 * @param selection
	 */
	public BarGraph(Result res, Selection sel) {
		super("graph");
		chartTitle = sel.getAnalysisType();
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "XAxis", "YAxis", createDataset(res, sel),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	/**
	 * Method to create dataset based on user-selection and data from result.
	 * @param result
	 * @param selection
	 * @return dataSet
	 */
	private CategoryDataset createDataset(Result res, Selection sel) {
		float[][] data = res.getValues();
		int series = data[0].length; // number of rows = number of series

		// set series name based on analysis type
		String series1 = "s1", series2 = "s2", series3 = "s3";
		String category = "category";
		if (sel.getAnalysisType().equals("")) {
			series1 = "";
			series2 = "";
			series3 = "";
		} else if (sel.getAnalysisType().equals("")) {
			series1 = "";
			series2 = "";
		}

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// populate first series
		for (int x = 0; x < data.length; x++) {
			dataset.addValue(data[0][x], series1, category);
		}
		
		// second series
		if(series >= 2) {
			for (int x = 0; x < data.length; x++) {
				dataset.addValue(data[1][x], series2, category);
			}
		}
		
		// third series
		if(series == 3) {
			for (int x = 0; x < data.length; x++) {
				dataset.addValue(data[2][x], series3, category);
			}
		}
		return dataset;
	}
}