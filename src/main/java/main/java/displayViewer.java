package main.java;

import analysis.java.Result;
import main.java.Selection;

/**
 * This class checks the user selected viewers and calls the method to create the corresponding ciewer
 * @author Group18
 *
 */
public class displayViewer {
	
	//private attributes for selection and result object
	private static Selection selectionObject;
	private static Result resultObject;
	
	/**
	 * This method accepts the result and selection object
	 * @param resultObj
	 * @param selObj
	 */
	public static void notify(Result resultObj, Selection selObj) { // accepts the result and selection object
		resultObject = resultObj;
		selectionObject = selObj;
		update(resultObject, selectionObject);
	}
	
	/**
	 * This method reads through the user selected viewers list, and creates the viewer
	 * @param resultObj
	 * @param selObj
	 */
	public static void update(Result resultObj, Selection selObj) { // pass through the result object and selection object

		// invoke the methods in result class to get data from result object
		// String country = resultObj.getCountry();
		// int yearStart = resultObj.getYearStart();
		// int yearEnd = resultObj.getYearEnd();
		// String analysisType = resultObj.getAnalysisType();
		// int numSeries = resultObj.getNumSeries();
		// string iD = resultObj.getID();
		
		int[] selectedViewersA = selObj.getViewerList(); // get the array list of user selected viewers
		Result res = resultObj;
		Selection sel = selObj;
		
		for (int i=0; i < selectedViewersA.length; i++) { 
			if (selectedViewersA[0] == 1) { // if the first element of the array is a 1 this means line graph
				LineGraph lineGraph = new LineGraph(sel, res);
					
			}
			if (selectedViewersA[1] == 1) { // if the second element of the array is a 1 this means bar chart
				BarGraph barGraph = new BarGraph(res, sel); // create a bar graph

			}
			if (selectedViewersA[2] == 1) {// if the third elemen of the array is a 1 this means scatter graph
				ScatterChart scatterChart = new ScatterChart(sel, res);
				
			}
			if (selectedViewersA[3] == 1) { // if the fourth element of the array is a 1 this means report graph
				ReportGraph reportGraph = new ReportGraph(sel, res);
				
			}
		}
	}
	

}