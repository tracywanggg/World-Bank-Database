package statsVisualiser.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import main.java.Selection;
import main.java.webserver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class representing the main UI of the World Bank Data Viewer
 * @author Group18
 */
public class MainUI extends JFrame {

	JLabel message;

	private static final long serialVersionUID = 1L;

	private static MainUI instance;

	private static JPanel west = new JPanel();

	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	/**
	 * Constructor for Main UI.
	 */
	private MainUI() {

		super("Country Statistics");
		final Selection selected = new Selection();
		JLabel chooseCountryLabel = new JLabel("Choose a country: ");

		// Populate the countries drop down menu
		String[] allCountries = new String[] { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
				"Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia",
				"Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
				"Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island",
				"Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi",
				"Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad",
				"Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
				"Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
				"Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
				"Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
				"Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France",
				"France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon",
				"Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe",
				"Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands",
				"Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia",
				"Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
				"Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of",
				"Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia",
				"Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau",
				"Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali",
				"Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico",
				"Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
				"Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
				"New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island",
				"Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea",
				"Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion",
				"Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
				"Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia",
				"Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia",
				"Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain",
				"Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname",
				"Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
				"Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo",
				"Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
				"Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom",
				"United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu",
				"Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
				"Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe",
				"Palestine" };
		final JComboBox<String> countriesList = new JComboBox<String>(allCountries);
		countriesList.setSelectedItem(null);

		JLabel from = new JLabel("From");
		JLabel to = new JLabel("To");
		Vector<String> years = new Vector<String>();
		for (int i = 2021; i >= 1960; i--) {
			years.add("" + i);
		}
		final JComboBox<String> fromList = new JComboBox<String>(years);
		final JComboBox<String> toList = new JComboBox<String>(years);
		fromList.setSelectedItem(null);
		toList.setSelectedItem(null);

		JPanel north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);

		JButton recalculate = new JButton("Recalculate");

		JLabel viewsLabel = new JLabel("Available Views: ");

		Vector<String> viewsNames = new Vector<String>();
		viewsNames.add("Line Chart");
		viewsNames.add("Bar Chart");
		viewsNames.add("Scatter Chartt");
		viewsNames.add("Report");

		final JComboBox<String> viewsList = new JComboBox<String>(viewsNames);
		viewsList.setSelectedItem(null);

		JButton addView = new JButton("+");
		JButton removeView = new JButton("-");

		JLabel methodLabel = new JLabel("        Choose analysis method: ");

		Vector<String> methodsNames = new Vector<String>();
		methodsNames.add("Average of Government expenditure on education, total for the selected years");
		methodsNames.add("PM2.5 air pollution, mean annual exposure vs. Forest area");
		methodsNames.add("Ratio of CO2 emissions and GDP per capita");
		methodsNames.add("Average forest area for the selected years");
		methodsNames.add("Current health expenditure per capita vs. Mortality rate, infant");
		methodsNames.add("Ratio of Government expenditure on education, total vs. Current health expenditure");

		JComboBox<String> methodsList = new JComboBox<String>(methodsNames);
		methodsList.setSelectedItem(null);

		JPanel south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(methodsList);
		south.add(recalculate);

		JPanel east = new JPanel();

		west.setLayout(new GridLayout(2, 0));

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);

		// analysis selection
		methodsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid;
				JComboBox methodsList = (JComboBox) e.getSource();

				if (selected.getAnalysisType() != null) { // if the user has previously selected something
					if (!selected.getAnalysisType().equals((String) methodsList.getSelectedItem())) { // if the previous
																										// selection is
																										// not equal to
																										// the current
																										// selection,
																										// then empty
																										// viewer list
						for (int x = 0; x < 4; x++) {
							selected.setViewerList(x, 0);
						}
					}
				}

				String analysis;
				if (methodsList.getSelectedItem().equals("Average of Government expenditure on education, total for the selected years")) {
					selected.setAnalysisType("A1");
				} else if (methodsList.getSelectedItem().equals("PM2.5 air pollution, mean annual exposure vs. Forest area")) {
					selected.setAnalysisType("A2");
				} else if (methodsList.getSelectedItem().equals("Ratio of CO2 emissions and GDP per capita")) {
					selected.setAnalysisType("A3");
				} else if (methodsList.getSelectedItem().equals("Average forest area for the selected years")) {
					selected.setAnalysisType("A4");
				} else if (methodsList.getSelectedItem().equals("Current health expenditure per capita vs. Mortality rate, infant")) {
					selected.setAnalysisType("A5");
				} else {
					selected.setAnalysisType("A6");
				}
			}
		});

		// countries selection
		countriesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid = false;
				JComboBox countriesList = (JComboBox) e.getSource();
				selected.setCountry((String) countriesList.getSelectedItem());
				valid = webserver.verifyCountry((String) countriesList.getSelectedItem(), selected);

				if (valid == false) { // if country is invalid, reset selection and display error
					countriesList.setSelectedItem(null);
					selected.setCountry(null);
					displayError("Invalid country selected.");
				} else { // otherwise, continue
					selected.setCountry((String) countriesList.getSelectedItem());
				}
			}
		});
		
		// start year selection
		fromList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid;
				JComboBox fromList = (JComboBox) e.getSource();

				if (toList.getSelectedItem() != null) { // if end year has been selected
					valid = webserver.verifyYears(Integer.parseInt((String) fromList.getSelectedItem()),
							Integer.parseInt((String) toList.getSelectedItem()),
							(String) countriesList.getSelectedItem(), selected);

					if (valid == false) {
						selected.setYearStart(-1);
						selected.setYearEnd(-1);
						fromList.setSelectedItem(null);
						toList.setSelectedItem(null);

						displayError("Invalid years selected.");
					}
				} else { // otherwise, do nothing until end year is selected

				}
			}
		});

		// end year selection
		toList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid;
				JComboBox toList = (JComboBox) e.getSource();

				if (fromList.getSelectedItem() != null) { // if start year has been selected

					valid = webserver.verifyYears(Integer.parseInt((String) fromList.getSelectedItem()),
							Integer.parseInt((String) toList.getSelectedItem()),
							(String) countriesList.getSelectedItem(), selected);

					if (valid == false) { // if years are invalid, clear selection and display error message
						selected.setYearStart(-1);
						selected.setYearEnd(-1);
						fromList.setSelectedItem(null);
						toList.setSelectedItem(null);

						displayError("Invalid years selected.");
					}
				} else { // otherwise, do nothing

				}
			}
		});

		
		recalculate.addActionListener(new ActionListener(){ public void
			 actionPerformed(ActionEvent e) { System.out.println("Recalculate"); } });
	}

	/**
	 * Method to display error window.
	 * @param msg
	 */
	public void displayError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.INFORMATION_MESSAGE);
	}
}