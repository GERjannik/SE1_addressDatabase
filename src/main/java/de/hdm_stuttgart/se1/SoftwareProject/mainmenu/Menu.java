package de.hdm_stuttgart.se1.SoftwareProject.mainmenu;

import java.io.File;
import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.DeletingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.FilteringEntries;
import de.hdm_stuttgart.se1.SoftwareProject.saving.WriteFile;

public class Menu {

	public static void printMenu() {
		System.out.println("Main Options:\n\n"
				+ "0: Browse Person Entries\n"
				+ "1: Toggle filtering person entries\n"
				+ "2: Create new person entry\n"
				+ "3: Delete person entry\n"
				+ "4: Exit");
	}
	
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
	
	public static Object[][][] switchOption
			(String[][] filteredArray, String[][] entries, boolean filterToggled, Scanner s, File f) {
		
		switch (chooseOption(s)) {

		case 0: // method of browsing person entries
			Browsing.caseBrowsing(filteredArray, entries, filterToggled);
			break;

		case 1: // method of toggling filtering person entries
			s.nextLine();
			if (filterToggled == false) {
				String pattern = FilteringEntries.askForFilter(s);
				String[][][] returnValues = FilteringEntries.setFilter(pattern, entries);

				filteredArray = returnValues[0].clone();
				entries = returnValues[1].clone();
				
				filterToggled = true;
			} else {
				entries = FilteringEntries.endFiltering(filteredArray, entries);
				
				filterToggled = false;
			}
			break;
		case 2: // method of creating new person entries
			entries = CreatingEntries.createEntry(entries, s);
			break;

		case 3: // method of deleting person entries
			if (filterToggled == false) {
				entries = DeletingEntries.deleteEntry(entries, s);
			} else {
				filteredArray = DeletingEntries.deleteEntry(filteredArray, s);
			}
			break;

		case 4: // method to exit the programm
			entries = FilteringEntries.endFiltering(filteredArray, entries);
			WriteFile.writeInFile(f, entries);
			System.exit(0);
			break;

		default: 
			System.err.println("Choice not in range [0...4]");
			break;
		}
		
		Object[][][] returnValues = new Object[3][][];
		returnValues[2] = new Object[1][1];
		returnValues[0] = entries;
		returnValues[1] = filteredArray;
		returnValues[2][0][0] = filterToggled;
		
		return returnValues;

	}
}
