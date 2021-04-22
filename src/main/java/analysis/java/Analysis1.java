package analysis.java;

import main.java.Selection;
import reader.java.Reader;


/**
 * Class representing average of Government expenditure on education, total (% of GDP) for the selected years (A1).
 * @author Group18
 *
 */
public class Analysis1 extends Analysis {
	
	String [] requiredID = new String[] {"SE.XPD.TOTL.GD.ZS"}; // String to hold the corresponding IDs for the series of data
	
	/**
	 * Method to get call reader class to get data from World Bank Database.
	 */
	public float[][] calculate(Selection s) // main method
	{
		Reader reader = new Reader();
		// first call
		float[] data1 = reader.getData(s, "SE.XPD.TOTL.GD.ZS");
		
		float[] total = new float[0];
		float[] result = new float[0];
		
		for (int i = 0; i < data1.length; i++)
		{
			total[0] = total[0] + data1[i];
		}
		result[0] = total[0] / data1.length;
		
		inputData[0] = result;
		
		return inputData;
	}
	
	/**
	 * Method to return ID.
	 */
	public String[] getID(){
		return requiredID;
	}
}
