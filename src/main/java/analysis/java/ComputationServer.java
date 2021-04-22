package analysis.java;

import main.java.Selection;
import main.java.displayViewer;

/**
 * Class representing the computation server of the World Bank Data Viewer.
 * @author Group18
 */
public class ComputationServer {
	private Analysis currentAnalysis; // analysis object that holds selected analysis type
	private displayViewer observer; // observer object 
	
	/**
	 * Method to create correct analysis object and return corresponding result object. 
	 * @param selection
	 * @return result object
	 * @throws Exception
	 */
	public Result perform(Selection s) throws Exception
	{
		this.observer = new displayViewer();
		String type = s.getAnalysisType();
		Analysis a = Factory.create(type); // strategy method employed
		currentAnalysis = a;
		Result rs = new Result();
		rs.setResult(s, currentAnalysis.calculate(s));
		rs.setID(a.getID());
		displayViewer.notify(rs,s); // notify observer class to do viewers
		return rs;
	}
}

