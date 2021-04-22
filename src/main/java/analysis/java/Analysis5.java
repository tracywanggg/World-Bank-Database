package analysis.java;


import main.java.Selection;
import reader.java.Reader;

/**
 * Class representing CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) (A5).
 * @author Group18
 */
public class Analysis5 extends Analysis{
	String [] requiredID = new String[] {"EN.ATM.CO2E.PC", "EG.USE.PCAP.KG.OE", "EN.ATM.PM25.MC.M"}; // String to hold the corresponding IDs for the series of data
	
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
		float[] data2 = reader.getData(s, "EG.USE.PCAP.KG.OE");
		inputData[1] = data2;
		
		// third call
		float[] data3 = reader.getData(s, "EN.ATM.PM25.MC.M3");
		inputData[3] = data3;
		
		return inputData;
		
	}

	/**
	 * Method to return ID.
	 */
	String[] getID() {
		return requiredID;
	}

}