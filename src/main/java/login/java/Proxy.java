package login.java;

import javax.swing.JOptionPane;

import statsVisualiser.gui.MainUI;
import java.io.IOException;
import javax.swing.*;

/**
 * Class representing the proxy.
 * @author Group18
 */
public class Proxy {
	
	/**
	 * Main method for the program.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginUI.loginWindow();
			}
		});
		
		CredentialsDatabase DB = new CredentialsDatabase();
	}
	
	/**
	 * Method that requests login server to verify credentials. Then displays main UI or handles invalid credential error.
	 * @param user
	 * @param pass
	 * @throws IOException
	 */
	public static void submit(String user, String pass) throws IOException {
		boolean result = LoginServer.verifyLogin(user, pass);

		if (result == true) { // hide login window and display main UI
			JOptionPane.showMessageDialog(null, "Login successful. ", "Success", JOptionPane.INFORMATION_MESSAGE);
			hideLoginUI();
			displayMainUI();
			System.out.println("Showing main UI");
		}
		else { // display error message and exit system
			JOptionPane.showMessageDialog(null, "Invalid credentials. The system will now exit. ", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0); 
		}
	}
	
	/**
	 * Method that requests loginUI to dispose of itself.
	 */
	public static void hideLoginUI() {
		LoginUI.dispose();
	}
	
	/**
	 * Method to display main UI.
	 */
	public static void displayMainUI() {
		JFrame frame = MainUI.getInstance();
		frame.pack();
		frame.setSize(1100, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
