package analysis.java;

import main.java.Selection;
import reader.java.Reader;

/**
 * Class representing Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP). (A6).
 * @author Group18
 */
public class Analysis6 extends Analysis {
	String [] requiredID = new String[] {"SE.XPD.TOTL.GD.ZS", "SH.XPD.CHEX.GD.ZS"}; // String to hold the corresponding IDs for the series of data
	
	/**
	 * Method to get call reader class to get data from World Bank Database.
	 */
	public float[][] calculate(Selection s) // main method
	{
		Reader reader = new Reader();
		// first call
		float[] data1 = reader.getData(s, "SE.XPD.TOTL.GD.ZS");
		
		// second call
		float[] data2 = reader.getData(s, "SH.XPD.CHEX.GD.ZS");
		
		float[] data3 =  new float[100];
		for (int i = 0; i < data1.length; i++)
		{
			float result = data1[i] / data2[i];
			data3[i] = result;
		}
		
		inputData[0] = data3;
		
		return inputData;
		
	}

	/**
	 * Method to return ID.
	 */
	String[] getID() {
		return requiredID;
	}
}