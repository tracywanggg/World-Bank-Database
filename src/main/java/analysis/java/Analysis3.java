package analysis.java;

import main.java.Selection;
import reader.java.Reader;


/**
 * Class representing Ratio of CO2 emissions (metric tons per capita) and GDP per capita (current US$) (A3).
 * @author Group18
 */
public class Analysis3 extends Analysis{
	String [] requiredID = new String[] {"EN.ATM.CO2E.PC", "NY.GDP.PCAP.CD"}; // String to hold the corresponding IDs for the series of data
	
	/**
	 * Method to get call reader class to get data from World Bank Database.
	 */
	public float[][] calculate(Selection s) // main method
	{
		Reader reader = new Reader();
		// first call
		float[] data1 = reader.getData(s, "EN.ATM.CO2E.PC");
		
		// second call
		float[] data2 = reader.getData(s, "NY.GDP.PCAP.CD");
		
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