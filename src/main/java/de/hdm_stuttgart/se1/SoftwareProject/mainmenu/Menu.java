package de.hdm_stuttgart.se1.SoftwareProject.mainmenu;

import java.io.File;
import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.DeletingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.FilteringEntries;
import de.hdm_stuttgart.se1.SoftwareProject.saving.WriteFile;

public class Menu {

	/**
	 * Method prints main menu with all options
	 */
	public static void printMenu() {
		System.out.println("Main Options:\n\n"
				+ "0: Browse Person Entries\n"
				+ "1: Toggle filtering person entries\n"
				+ "2: Create new person entry\n"
				+ "3: Delete person entry\n"
				+ "4: Exit");
	}

	/**
	 * The method asks the user which option he want to choose. Options were printed before @printMenu
	 * The request is repeated, until the input is valid.
	 * @param s Scanner which is needed for user input
	 * @return returns the choice of user as an int
	 */
	public static int chooseOption(Scanner s) {

		boolean correctInput = false;
		int choice = 0;

		while (correctInput == false) {
			try {
				System.out.println("Your choice:");
				choice = s.nextInt();
				correctInput = true;
				return choice;
			} catch (java.util.InputMismatchException e) {
				System.err.println("Input is not an integer!");
				s.nextLine();
			}
		}
		return choice;
	}

	/**
	 * Method switches in case (chosen of user before) and calls the right methods
	 * @param filteredArray If filter is toggled, this array includes all entries matching the filter
	 * @param entries The array containing all entries of our address database
	 * @param filterToggled true if a filter is toggled, false when the program starts
	 * @param s Scanner needed for user input
	 * @param f The .txt-file where the entries will be saved after leaving the program
	 * @return all parameters that could have changed during the method are returned in one array
	 */
	public static Object[][][] switchOption
	(String[][] filteredArray, String[][] entries, boolean filterToggled, Scanner s, File f) {

		switch (chooseOption(s)) {

		case 0: // method of browsing person entries
			Browsing.caseBrowsing(filteredArray, entries, filterToggled);
			break;

		case 1: // method of toggling filtering person entries
			s.nextLine(); // necessary that Scanner reads the correct line with user input
			if (filterToggled == false) { // checks if filter is already toggled
				String pattern = FilteringEntries.askForFilter(s); // user can enter filter phrase
				
				// filter phrase and array with entries are given into method
				// method returns one array, including two arrays: 
				// the array entries reduced by the content which is filtered into filteredArray
				String[][][] returnValues = FilteringEntries.setFilter(pattern, entries); 

				// the results are given back to their arrays
				filteredArray = returnValues[0].clone();
				entries = returnValues[1].clone();

				// filter is now active. You work on with this filter
				filterToggled = true;
			} else { // if filter is toggled, no filtering will be finished
				// arrays entries & filteredArray are put together into entries
				entries = FilteringEntries.endFiltering(filteredArray, entries);

				filterToggled = false; // filter is not longer active
			}
			break;
			
		case 2: // method of creating new person entries
			// gets array with all entries and adds a new entry
			entries = CreatingEntries.createEntry(entries, s);
			break;

		case 3: // method of deleting person entries
			if (filterToggled == false) {
				// if no filter is toggled, one entry can be deleted
				entries = DeletingEntries.deleteEntry(entries, s);
			} else {
				// if filter is toggled, one entry of filteredArray can be deleted
				filteredArray = DeletingEntries.deleteEntry(filteredArray, s);
			}
			break;

		case 4: // method to exit the program
			// put entries and filteredArray together before closing the program
			if (filterToggled == true) { 
				entries = FilteringEntries.endFiltering(filteredArray, entries);
			}
			// writes all content of array entries in "database" txt-file
			WriteFile.writeInFile(f, entries);
			System.exit(0); // stops the program
			break;

		default: // if user input was not 0-4
			System.err.println("Choice not in range [0...4]");
			break;
		}

		// this block creates the array to return all necessary parameter
		Object[][][] returnValues = new Object[3][][];
		returnValues[2] = new Object[1][1];
		returnValues[0] = entries;
		returnValues[1] = filteredArray;
		returnValues[2][0][0] = filterToggled;

		return returnValues;

	}
}
