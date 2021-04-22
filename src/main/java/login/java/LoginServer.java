package login.java;

import java.io.IOException;

/**
 * Class representing the login server of the World Bank Data Viewer.
 * @author Group18
 */
public class LoginServer {

	private static LoginServer instance = null;
	
	private static LoginServer getLoginServerInstance() {
		if (instance == null) {
			instance = new LoginServer();
		}
		
		return instance;
	}
	
	/**
	 * Method that returns true if passed credentials are verified in the credentials database, and false otherwise.
	 * @param username
	 * @param password
	 * @return true if found, false otherwise
	 * @throws IOException
	 */
	public static boolean verifyLogin(String username, String password) throws IOException {	

		// look for credentials in credentials database
		for(int x = 0; x < CredentialsDatabase.getTotalLines()/2; x++) { // traverse database
			if(CredentialsDatabase.getCred(x,0).equals(username)) { // look for matching username
				if(CredentialsDatabase.getCred(x, 1).equals(password)) { // if username is found, check if password matches
					return true; // return true if username password pair is found
				}
			}
		}
		return false; // otherwise, return false
	}
}
