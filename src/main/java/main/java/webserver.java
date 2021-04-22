package main.java;

/**
 * This class verifies the user selected country, viewers, and years with the databases.
 * @author Group18
 */

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class webserver {

	/**
	 * This method will take the user selected country and check whether the country
	 * is stored in the countries database for the corresponding analysis type. If a
	 * country is found then return true. Else, return false
	 * 
	 * @param country
	 * @param selection
	 * @return valid
	 */
	public static boolean verifyCountry(String country, Selection selobject) {

		try {
			if (selobject != null) {
				BufferedReader file = new BufferedReader(new FileReader("countries.csv")); // read in the file
																									// but put the file
																									// path name instead
																									// of just the name
				String line = "";
				while ((line = file.readLine()) != null) { // read file line by line until it reaches end of file (null)
					String[] arr = line.split(","); // split the string with the commas
					if (arr[0].equals(selobject.getAnalysisType())) { // iterate through the first column and find the
																		// analysis type matching with analysis type
																		// from selection
						for (int i = 0; i < arr.length; i++) { // iterate through the row up until the array length to
																// check if country is stored in database for
																// corresponding analysis type
							if (arr[i].equals(country)) { // if the country in database matches user selected country
															// then return true
								return true;
							}
						}
					}
				}
				return false;
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found. Cannot access countries database");
		} catch (IOException e) {

		}
		return false;
	}

	/**
	 * This method will take the user selected start and end years and first check
	 * what row the user selected country is in for the database. Then after
	 * checking the country this method will check the next two values within the
	 * two columns in the row to compare with the user selected start and end year.
	 * 
	 * @param yearStart
	 * @param yearEnd
	 * @param country
	 * @param selection
	 * @return valid
	 */
	public static boolean verifyYears(int yearStart, int yearEnd, String country, Selection selobject) {
		if (yearStart > yearEnd) {
		
			return false;
		}
		try {
			if (selobject != null) {
				BufferedReader file = new BufferedReader(new FileReader("years.csv")); // read in the csv file
				String line = "";
				while ((line = file.readLine()) != null) { // read file line by line until it reaches end of file (null)
					String[] arr = line.split(","); // split the line with the commas
					if (arr[0].equals(country) // iterate through the first column to check for the row of the user
												// selected country
							&& (Integer.parseInt(arr[1]) <= yearStart) // user selected yearstart has to be greater or
																		// equal than yearstart in database
							&& (Integer.parseInt(arr[2]) >= yearEnd) // user selected yearend has to be smaller than
																		// yearend in database
							&& !(yearStart > yearEnd)) {
						return true;
					}
				}
				return false;
			}
		} catch (FileNotFoundException e) { // file not found error
			System.err.println("File not found. Cannot access years database");
		} catch (IOException e) {

		}
		return false;
	}

	/**
	 * This method will take the user selected viewer input and check which row the
	 * user selected analysisType is stored. After, the method will iterate through
	 * the row to check whether the user selected viewer matches with any of the
	 * viewers available for the corresponding analysis type.
	 * 
	 * @param viewer
	 * @param analysisType
	 * @param selection
	 * @return valid
	 */

	public boolean verifyViewers(String viewer, String analysisType, Selection selobject) {

		try {
			if (selobject != null) {
				BufferedReader file = new BufferedReader(new FileReader("viewers.csv")); // put file path name
																									// instead
				String line = "";
				while ((line = file.readLine()) != null) { // read file line by line until it reaches end of file (null)
					String[] arr = line.split(","); // split the line if there is any "," (split the columns)
					if (arr[0].equals(selobject.getAnalysisType())) { // iterate through the first column and find the
																		// analysis type matching with analysis type
																		// from selection
						for (int i = 0; i < arr.length; i++) { // iterate through the row up until the array length to
																// check if the selected viewer is stored in database
																// for corresponding analysis type
							if (arr[i].equals(viewer)) { // if the viewer in database matches user selected viewer then
															// return true
								return true;
							}
						}
					}
				}
				return false;
			}
		} catch (FileNotFoundException e) { // file not found error
			System.err.println("File not found. Cannot access years database");

		} catch (IOException e) {

		}
		return false;

	}
}
