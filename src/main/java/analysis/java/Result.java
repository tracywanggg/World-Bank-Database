package analysis.java;

import main.java.Selection;

/**
 * Class that creates and stores data retrieved from the World Bank Database.
 * @author Group18
 */
public class Result {
	private Selection s;
	private float[][] arr; // array storing data from WB Database
	private int yearStart;
	private int yearEnd;
	private String country;
	private String analysisType;
	private String[] id;
	
	/**
	 * Constructor for Result class.
	 */
	// result object --> double array
	public Result() // takes selection and double array as parameters
	{
		arr = new float[][] {};
	}
	
	/**
	 * Method to populate result object based on given parameters.
	 * @param selection
	 * @param data array
	 */
	public void setResult(Selection s, float[][] inputData)
	{
		this.s = s;
		country = s.getCountry();
		analysisType = s.getAnalysisType();
		yearStart = s.getYearStart();
		yearEnd = s.getYearEnd();
		arr = inputData; // data
	}
	
	/**
	 * Method to return user-selected country.
	 * @return country
	 */
	public String getCountry()
	{
		return country;
	}
	
	/**
	 * Method to return user-selected start year.
	 * @return start year
	 */
	public int getStartYear()
	{
		return yearStart;
	}
	
	/**
	 * Method to return user-selected end year.
	 * @return end year
	 */
	public int getEndYear()
	{
		return yearEnd;
	}
	
	/**
	 * Method to return user-selected analysis type
	 * @return analysis type
	 */
	public String getAnalysisType()
	{
		return analysisType;
	}
	
	/**
	 * Method to return IDs of the series of data based on user-selected analysis type.
	 * @return IDs array
	 */
	public String[] getID()
	{
		return id;
	}
	
	/**
	 * Method to return 2D array of data retrieved from WB Database.
	 * @return data array
	 */
	public float[][] getValues()
	{
		return arr;
	}
	
	/**
	 * Method to set IDs of the series of data based on user-selected analysis type.
	 */
	public void setID(String[] id)
	{
		this.id = id;
	}
}
