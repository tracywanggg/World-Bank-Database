package analysis.java;

import main.java.Selection;
import reader.java.Reader;

/**
 * Class representing Average Forest area (% of land area) for the selected years (A4).
 * @author Group18
 */
public class Analysis4 extends Analysis{
	String [] requiredID = new String[] {"AG.LND.FRST.ZS"}; // String to hold the corresponding IDs for the series of data
	
	/**
	 * Method to get call reader class to get data from World Bank Database.
	 */
	public float[][] calculate(Selection s) // main method
	{
		Reader reader = new Reader();
		// first call
		float[] data1 = reader.getData(s, "AG.LND.FRST.ZS");
		
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
	String[] getID() {
		return requiredID;
	}
}
