package mainPackage;

// layout tools
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// event handlers
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// swing components
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

// other
import java.util.Scanner;
import java.util.Vector;



@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener, WindowListener {
	private JTextArea directionsLabel;
	private JTextArea stringLabel;
	private JTextArea charsLabel;
	private JTextField userString;
	private JTextField userChars;
	private JButton submitButton;
	
	MainWindow() {
		// enable only horizontal resizing
		setMinimumSize(new Dimension(300, 250));
		setMaximumSize(new Dimension(1000, 250));
		
		GridBagConstraints gbc = null;
		
		
		
		/*
		 * INITIALIZATIONS
		 */
		
		// directions label
		directionsLabel = new JTextArea();
		directionsLabel.setText("This program checks for any occurences of the given characters in the given string.");
		directionsLabel.setLineWrap(true);
		directionsLabel.setWrapStyleWord(true);
		directionsLabel.setOpaque(false);
		directionsLabel.setEditable(false);
		
		// string label
		stringLabel = new JTextArea();
		stringLabel.setText("Enter string:");
		stringLabel.setLineWrap(true);
		stringLabel.setWrapStyleWord(true);
		stringLabel.setOpaque(false);
		stringLabel.setEditable(false);
		
		// characters label
		charsLabel = new JTextArea();
		charsLabel.setText("Enter character (if you enter more than one, separate with a space):");
		charsLabel.setLineWrap(true);
		charsLabel.setWrapStyleWord(true);
		charsLabel.setOpaque(false);
		charsLabel.setEditable(false);		
		
		// text field for string
		userString = new JTextField();
		userString.setEditable(true);
		
		// text field for character(s)
		userChars = new JTextField();
		userChars.setEditable(true);
		
		// button
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		
		
		
		/*
		 * CONSTRAINTS
		 */
		
		// implement GridBagLayout in MainWindow
		setLayout(new GridBagLayout());
		
		// directions label constraints constraints
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		add(directionsLabel, gbc);
		
		// stringLabel constraints
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 0, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.5;
		add(stringLabel, gbc);
		
		// stringLabel constraints
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0.5;
		add(userString, gbc);

		// charsLabel constraints
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 0, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0.5;
		add(charsLabel, gbc);
		
		// userChars constraints
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.weighty = 0.5;
		add(userChars, gbc);

		// submitButton constraints
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.fill = GridBagConstraints.SOUTH;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.weighty = 0;
		add(submitButton, gbc);
	}
	
	
	
	
	
	/*
	 * EVENT HANDLERS
	 */
	
	// submitButton clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		String stringVal;
		String charsVal;
		Vector<Character> charVals = new Vector<Character>(0);
		
		// get contents of string field and make sure it's not empty
		stringVal = userString.getText();
		if (stringVal.compareTo("") == 0) {
			JOptionPane.showMessageDialog(this, "Please enter a string.");
			return;
		}
		
		// ensure chars field isn't empty
		charsVal = userChars.getText();
		if (charsVal.compareTo("") == 0) {
			JOptionPane.showMessageDialog(this, "Please enter at least one character.");
			return;
		}
		
		// put contents of characters field and put in a vector
		Scanner input = new Scanner(charsVal);
		while (input.hasNext()) {
				charVals.addElement(input.next().charAt(0));
		}
		input.close();
		
		
		
		// close MainWindow
		setVisible(false);
		
		// open ResultWindow
		ResultWindow resultWin = new ResultWindow(this, stringVal, charVals);
		resultWin.addWindowListener(this);
		resultWin.setVisible(true);
	}
	
	// resultWin closed
	@Override
	public void windowClosed(WindowEvent e) {
		setVisible(true);
	}
	
	
	
	
	
	/*
	 * UNUSED EVENT LISTENERS
	 */
	
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	
}
