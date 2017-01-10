package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.controls.BrowsingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;

public class Mainmenu {

	public static void main(String[] args) {

		Object[][] entries = new Object[2][4];
		entries[0][0] = "aaaa";
		entries[0][1] = "aaa";
		entries[0][2] = "aa";
		entries[0][3] = "a";
		entries[1][0] = "bbbb";
		entries[0][1] = "bbb";
		entries[0][2] = "bb";
		entries[0][3] = "b";

		System.out.println("Main Options:\n\n"
				+ "0: Browse Person Entries\n"
				+ "1: Toggle filtering person entries\n"
				+ "2: Create new person entry\n"
				+ "3: Delete person entry\n"
				+ "4: Exit");

		Scanner s = new Scanner(System.in);
		System.out.println("Your choice:");
		int choice = s.nextInt();

		switch (choice) {
			case 0: //method of browsing person entries
				BrowsingEntries.printEntries(entries);
			case 1: //method of toggling filtering person entries
				// method of creating new person entries
			case 2: 
				entries = CreatingEntries.createEntry(entries, s);
			case 3: //method of deleting person entries
			case 4: //method to exit the programm
		}

		//just for checking
		/*for (int i = 0; i < entries.length; i++) {
			for (int j = 0; j < entries[i].length; j++) {
				System.out.println(entries[i][j].toString());
			}
		}*/
		s.close();
	}

}
