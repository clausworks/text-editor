/*
 * Name: Nicholas Brunet
 * Class: CIS 111 (Antelope Valley College)
 * Professor: Alec Winetrobe
 * 
 * Project: Lab 4b
 * Due: 3/15/19
 * 
 * Description: The user enters a string and a number of characters, and the
 * program determines the number of occurrences of each character in the
 * string, displaying the results in a table in a new window.
 */



package mainPackage;

import javax.swing.JFrame;



public class MainClass {

	public static void main(String[] args) {
		MainWindow mainWin = new MainWindow();

		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}



}
