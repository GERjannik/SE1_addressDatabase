package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.controls.BrowsingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.DeletingEntries;

public class Mainmenu {

	public static void mainmenu(Object[][] entries) {

		System.out.println("Main Options:\n\n"
				+ "0: Browse Person Entries\n"
				+ "1: Toggle filtering person entries\n"
				+ "2: Create new person entry\n"
				+ "3: Delete person entry\n"
				+ "4: Exit");


		Scanner s = new Scanner(System.in);
		System.out.println("Your choice:");
		int choice = 0;
		try {
			 choice = s.nextInt();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Input is not of type Integer!");
			mainmenu(entries);
		}

		switch (choice) {
		case 0: //method of browsing person entries
			BrowsingEntries.printEntries(entries);
			mainmenu(entries);
			break;
		case 1: //method of toggling filtering person entries
			// method of creating new person entries
		case 2: 
			entries = CreatingEntries.createEntry(entries, s);
			mainmenu(entries);
			break;
		case 3: //method of deleting person entries
			entries = DeletingEntries.deleteEntry(entries, DeletingEntries.askUser(s, entries));
			mainmenu(entries);
			break;
		case 4: //method to exit the programm
			break;
		default: 
			System.out.println("Choice not in range [0...4]");
			mainmenu(entries);
			break;
		}

		//just for checking
		/*for (int i = 0; i < entries.length; i++) {
			for (int j = 0; j < entries[i].length; j++) {
				System.out.println(entries[i][j].toString());
			}
		}*/
		s.close();
	}

	public static void main(String[] args) {

		Object[][] entries = new Object[0][];
		mainmenu(entries);
	}

}
