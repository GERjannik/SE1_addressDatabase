package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.io.File;
import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.controls.BrowsingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.DeletingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.FilteringEntries;
import de.hdm_stuttgart.se1.SoftwareProject.saving.CheckForFile;
import de.hdm_stuttgart.se1.SoftwareProject.saving.ReadFile;
import de.hdm_stuttgart.se1.SoftwareProject.saving.WriteFile;

public class Mainmenu {

	public static void mainmenu(String[][] entries, String[][] filteredArray, Scanner s, File f, boolean filterToggled) {

		System.out.println("Main Options:\n\n"
				+ "0: Browse Person Entries\n"
				+ "1: Toggle filtering person entries\n"
				+ "2: Create new person entry\n"
				+ "3: Delete person entry\n"
				+ "4: Exit");


		int choice = -1;
		boolean correctInput = false;
		while (correctInput == false) {
			try {
				System.out.println("Your choice:");
				choice = s.nextInt();
				correctInput = true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Input is not an integer!");
				s.nextLine();
			}
		}
		

		switch (choice) {
		
		case 0: // method of browsing person entries
			if (filterToggled == false) {
				BrowsingEntries.printEntries(entries);
			}
			if (filterToggled == true) {
				BrowsingEntries.printEntries(filteredArray);
			}
			break;
		
		case 1: // method of toggling filtering person entries
			s.nextLine();
			if (filterToggled == false) {
				String pattern = FilteringEntries.askForFilter(s);
				String[][][] returnValues = FilteringEntries.completeFilterMethod(s, entries, pattern);
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
				entries = DeletingEntries.deleteEntry(
						entries, DeletingEntries.askUser(s, entries, filterToggled, filteredArray));
			} else {
				filteredArray = DeletingEntries.deleteEntry(
						filteredArray, DeletingEntries.askUser(s, entries, filterToggled, filteredArray));
			}
			break;
		
		case 4: // method to exit the programm
			WriteFile.writeInFile(f, entries);
			System.exit(0);
			break;
		
		default: 
			System.out.println("Choice not in range [0...4]");
			break;
		}
		

		mainmenu(entries, filteredArray, s, f, filterToggled);

		// just for checking
		/*for (int i = 0; i < entries.length; i++) {
			for (int j = 0; j < entries[i].length; j++) {
				System.out.println(entries[i][j].toString());
			}
		}*/
	}

	public static void main(String[] args) {

		String[][] entries = new String[0][];
		String[][] filteredArray = new String[0][];
		CheckForFile addressTxt = new CheckForFile();
		boolean filterToggled = false;
		File f = addressTxt.searchDirectory();
		addressTxt.checkAndCreate();
		
		ReadFile addressFile = new ReadFile();
		entries = 
			addressFile.entriesOfArray(addressFile.sizeOfArray(f),f);
		
		
		
		Scanner s = new Scanner(System.in);

		mainmenu(entries, filteredArray, s, f, filterToggled);
		
		s.close();
	}

}
