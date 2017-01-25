package de.hdm_stuttgart.se1.SoftwareProject.mainmenu;

import java.io.File;
import java.util.Scanner;

public class Mainmenu extends Menu{

	/**
	 * This is the main menu of the program. The method will be repeated(calls itself),
	 * after finishing a function, until user leaves the program.
	 * @param entries The array containing all entries of our address database
	 * @param filteredArray If filter is toggled, this array includes all entries matching the filter
	 * @param s Scanner needed for user input
	 * @param f Our .txt-file where the entries will be saved after leaving the program
	 * @param filterToggled true if a filter is toggled, false when the program starts
	 */
	public static void mainmenu
		(String[][] entries, String[][] filteredArray, Scanner s, File f, boolean filterToggled) {

		// prints main Options of the program
		printMenu();

		// user can choose option, which is executed afterwards
		// returnVales contains all results of the executed method
		Object[][][] returnValues = switchOption(filteredArray, entries, filterToggled, s, f);
		
		// results are given back to their "parents"
		entries = (String[][]) returnValues[0];
		filteredArray = (String[][]) returnValues[1];
		filterToggled = (boolean) returnValues[2][0][0];

		// starts "mainmenu" again
		mainmenu(entries, filteredArray, s, f, filterToggled);
	}

}
