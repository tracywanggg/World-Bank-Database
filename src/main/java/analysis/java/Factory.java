package analysis.java;

/**
 * Class representing factory of World Bank Data Viewer.
 * @author Group18
 *
 */
public class Factory {

	/**
	 * Creates corresponding analysis object given user-selected analysis type.
	 * @param analysis name
	 * @return analysis object
	 * @throws Exception
	 */
	public static Analysis create(String s) throws Exception
	{
		if (s=="A1")
		{
			return new Analysis1();
		}
		if (s=="A2")
		{
			return new Analysis2();
		}
		if (s=="A3")
		{
			return new Analysis3();
		}
		if (s=="A4")
		{
			return new Analysis4();
		}
		if (s=="A5")
		{
			return new Analysis5();
		}
		if (s=="A6")
		{
			return new Analysis6();
		}
		else
		{
			throw new Exception();
		}
	}

}
