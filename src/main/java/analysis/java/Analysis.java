package analysis.java;

import main.java.Selection;

/**
 * Abstract class from which all analysis types inherit.
 * @author Group18
 */
abstract class Analysis {
	
	float[][] inputData = new float[100][100]; // declare array of arrays to hold data retrieved
	
	/**
	 * Method to get call reader class to get data from World Bank Database (abstract).
	 */
	abstract float[][] calculate(Selection s);

	/**
	 * Method to return ID (abstract).
	 */
	abstract String[] getID();
}

