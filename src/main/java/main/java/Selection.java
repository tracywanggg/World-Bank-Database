package main.java;

/**
 * Class representing the parameters the user selected.
 * @author group18
 *
 */
public class Selection {
	// Private attributes
	private String country;
	private int yearStart;
	private int yearEnd;
	private int[] viewerList = new int[4];
	private String analysisType;
	private int numSeries;
	private String id;
	
	// Getter Methods
	/**
	 * Method to return user-selected country.
	 * @return country
	 */
	public String getCountry()
	{
		return country;
	}
	
	/**
	 * Method to return user-selected start year
	 * @return start year
	 */
	public int getYearStart()
	{
		return yearStart;
	}
	
	/**
	 * Method to return user-selected end year
	 * @return end year
	 */
	public int getYearEnd()
	{
		return yearEnd;
	}
	
	/**
	 * Method to return user-selected list of viewers
	 * @return viewer list
	 */
	public int[] getViewerList()
	{
		return viewerList;
	}
	
	/**
	 * Method to return user-selected analysis type.
	 * @return analysis type
	 */
	public String getAnalysisType()
	{
		return analysisType;
	}
	
	/**
	 * Method to return number of series of data based on user-selection.
	 * @return data series
	 */
	public int getNumSeries()
	{
		return numSeries;
	}
	
	/**
	 * Method to return IDs of user-selected analysis data series.
	 * @return IDs
	 */
	public String getID()
	{
		return id;
	}
	
	// setter methods
	/**
	 * Method to set user-selection country.
	 */
	public void setCountry(String newCountry)
	{
		this.country = newCountry;
	}
	
	/**
	 * Method to set user-selection start year.
	 */
	public void setYearStart(int newYearStart)
	{
		this.yearStart = newYearStart;
	}
	
	/**
	 * Method to set user-selection end year.
	 */
	public void setYearEnd(int newYearEnd)
	{
		this.yearEnd = newYearEnd;
	}
	
	/**
	 * Method to set user-selection list of viewers.
	 */
	public void setViewerList(int index, int value)
	{
		this.viewerList[index] = value;
	}
	
	/**
	 * Method to set user-selection analysis type.
	 */
	public void setAnalysisType(String newAnalysisType)
	{
		this.analysisType = newAnalysisType;
	}
}
