package mainPackage;

// layout tools
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// event handlers
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing components
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

// other
import java.util.Vector;

@SuppressWarnings("serial")
public class ResultWindow extends JFrame implements ActionListener {
	JLabel label;
	JButton okButton;
	JScrollPane resultsScrollPane;
	JTable results;
	String[] colHeaders = {"Character", "Occurences"};
	String[][] tableVals;
	
	ResultWindow(MainWindow mainWin, String stringVal, Vector<Character> charVals) {
		GridBagConstraints gbc = null;
		
		/*
		 * INITIALIZATIONS
		 */
		
		// label
		label = new JLabel("Results:");
		
		// button
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		// table
		tableVals = new String[charVals.size()][2];
		
		for (int i = 0; i < charVals.size(); ++i) {
			int count = 0; // temporarily keeps track of occurrences
			char curChar = charVals.elementAt(i);
			
			for (int j = 0; j < stringVal.length(); ++j) {
				if (curChar == stringVal.charAt(j)) {
					++count;
				}
			}
			tableVals[i][0] = Character.toString(curChar);
			tableVals[i][1] = Integer.toString(count);
		}
		
		results = new JTable(tableVals, colHeaders);
		results.setPreferredScrollableViewportSize(results.getPreferredSize());

		
		// scroll pane
		resultsScrollPane = new JScrollPane(results);
		
		
		/*
		 * LAYOUT
		 */
		
		setLayout(new GridBagLayout());
		
		// label constraints;
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 0, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		add(label, gbc);
		
		// scroll pane constraints;
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 10, 0, 10);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(resultsScrollPane, gbc);
		
		// label constraints;
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(okButton, gbc);

		
		pack();
	}
	
	public void actionPerformed(ActionEvent event) {
		dispose(); // close window when OK button is clicked
	}
}
