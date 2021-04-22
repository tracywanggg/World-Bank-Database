package login.java;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 * Class representing the login UI of the World Bank Data Viewer.
 * @author Group18
 */
public class LoginUI implements ActionListener {

	private static JFrame frame;
	private static JLabel usernameLabel, passwordLabel;
	private static JTextField usernameText;
	private static JPasswordField passwordText;
	private static JButton submitBtn;

	/**
	 * Constructor for login UI.
	 */
	public static void loginWindow() {

		// panel and frame
		JPanel panel = new JPanel();
		frame = new JFrame();
		frame.setSize(300, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle("Login");

		panel.setLayout(null);
		frame.setLocationRelativeTo(null); // window will open in center now

		// username and password labels
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(10, 20, 80, 25);
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 80, 25);

		// username and password fields
		usernameText = new JTextField(20);
		usernameText.setBounds(90, 20, 170, 25);
		passwordText = new JPasswordField(20);
		passwordText.setBounds(90, 50, 170, 25);

		// submit button
		submitBtn = new JButton("Submit!");
		submitBtn.setBounds(100, 85, 80, 25);
		submitBtn.addActionListener(new LoginUI());

		// add elements to panel
		panel.add(usernameLabel);
		panel.add(usernameText);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(submitBtn);

		frame.setVisible(true);
		frame.setResizable(false);
	}

	/**
	 * Describes action taken when submit button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		String inputUsername = usernameText.getText();
		String inputPassword = passwordText.getText();
		try {
			Proxy.submit(inputUsername, inputPassword);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Method to dispose of login UI frame.
	 */
	public static void dispose() {
		frame.dispose();
	}
}
