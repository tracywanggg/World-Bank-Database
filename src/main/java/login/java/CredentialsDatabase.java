package login.java;

import java.io.*;

/**
 * Class representing credentials database of the World Bank Data Viewer.
 * @author Group18
 */
public class CredentialsDatabase {

	private static String[][] database;
	private static int totalLines; // number of credentials (usernames + passwords)
	
	public CredentialsDatabase() throws IOException {
		totalLines = findTotalLines();
		database = new String[totalLines/2][2];
		populateDatabase();
	}
	
	/**
	 * Method to return string is passed row and column of database.
	 * @param col
	 * @param row
	 * @return String
	 */
	public static String getCred(int col, int row) {
		return database[col][row];
	}
	
	/**
	 * Method to find the total number of lines in the text file storing the credentials.
	 * @return total number of lines
	 * @throws IOException
	 */
	public int findTotalLines() throws IOException {
		int counter = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("Credentials.txt"));
		
		while(br.readLine() != null) { // count the number of lines
			counter++;
		}
		
		br.close();
		return counter;
	}
	
	/**
	 * Method to return the total number of lines in the text file storing the credentials.
	 * @return total number of lines
	 */
	public static int getTotalLines() {
		return totalLines;
	}
	
	/**
	 * Method to copy the credentials stored in the text file to the database 2D array.
	 * @throws IOException
	 */
	public void populateDatabase() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Credentials.txt"));
		
		String line;
		for(int x = 0; x < totalLines/2; x++) { // text file format: first line is user, next is password, and so on
			line = br.readLine(); // read in username	
			database[x][0] = line; // store in first column
			line = br.readLine(); // read in password
			database[x][1] = line; // store in second column
		}
	}
}
