package analysis.java;
/*
 * PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area) 
 */

import main.java.Selection;
import reader.java.Reader;

/**
 * Class representing PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area) (A2)
 * @author Group18
 *
 */
public class Analysis2 extends Analysis{
	String [] requiredID = new String[] {"EN.ATM.CO2E.PC", "AG.LND.FRST.ZS"}; // String to hold the corresponding IDs for the series of data
	
	/**
	 * Method to get call reader class to get data from World Bank Database.
	 */
	public float[][] calculate(Selection s) // main method
	{
		Reader reader = new Reader();
		// first call
		float[] data1 = reader.getData(s, "EN.ATM.CO2E.PC");
		inputData[0] = data1;
		
		// second call
		float[] data2 = reader.getData(s, "AG.LND.FRST.ZS");
		inputData[1] = data2;
		
		return inputData;
		
	}

	/**
	 * Method to return ID.
	 */
	String[] getID() {
		return requiredID;
	}

	
}