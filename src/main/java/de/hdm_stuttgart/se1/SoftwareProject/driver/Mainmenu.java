package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.io.File;
import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.controls.BrowsingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.DeletingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.saving.CheckForFile;
import de.hdm_stuttgart.se1.SoftwareProject.saving.WriteFile;

public class Mainmenu {

	public static void mainmenu(Object[][] entries, Scanner s, File f) {

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
		case 0: //method of browsing person entries
			BrowsingEntries.printEntries(entries);
			break;
		case 1: //method of toggling filtering person entries
			// method of creating new person entries
		case 2: 
			entries = CreatingEntries.createEntry(entries, s);
			break;
		case 3: //method of deleting person entries
			entries = DeletingEntries.deleteEntry(entries, DeletingEntries.askUser(s, entries));
			break;
		case 4: //method to exit the programm
			WriteFile.writeInFile(f, entries);
			System.exit(0);
			break;
		default: 
			System.out.println("Choice not in range [0...4]");
			break;
		}
		

		mainmenu(entries, s, f);

		//just for checking
		/*for (int i = 0; i < entries.length; i++) {
			for (int j = 0; j < entries[i].length; j++) {
				System.out.println(entries[i][j].toString());
			}
		}*/
	}

	public static void main(String[] args) {

		Object[][] entries = new Object[0][];
		CheckForFile addressTxt = new CheckForFile();
		addressTxt.searchDirectory();
		addressTxt.checkAndCreate();
		Scanner s = new Scanner(System.in);

		mainmenu(entries, s, addressTxt.searchDirectory());
		
		s.close();
	}

}
