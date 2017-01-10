package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.util.Scanner;

<<<<<<< HEAD
import de.hdm_stuttgart.se1.SoftwareProject.controls.BrowsingEntries;
=======
>>>>>>> f2cb559a479ba5070b267a6fe2e04ec52e313bf5
import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;

public class Mainmenu {

	public static void main(String[] args) {

<<<<<<< HEAD
		Object[][] entries = new Object[2][4];
		entries[0][0] = "aaaa";
		entries[0][1] = "aaa";
		entries[0][2] = "aa";
		entries[0][3] = "a";
		entries[1][0] = "bbbb";
		entries[1][1] = "bbb";
		entries[1][2] = "bb";
		entries[1][3] = "b";

=======
		Object[][] entries = new Object [0][];
>>>>>>> f2cb559a479ba5070b267a6fe2e04ec52e313bf5
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
<<<<<<< HEAD
				BrowsingEntries.printEntries(entries);
				break;
=======
>>>>>>> f2cb559a479ba5070b267a6fe2e04ec52e313bf5
			case 1: //method of toggling filtering person entries
				// method of creating new person entries
			case 2: 
				entries = CreatingEntries.createEntry(entries, s);
<<<<<<< HEAD
				break;
=======
>>>>>>> f2cb559a479ba5070b267a6fe2e04ec52e313bf5
			case 3: //method of deleting person entries
			case 4: //method to exit the programm
		}

		//just for checking
<<<<<<< HEAD
		/*for (int i = 0; i < entries.length; i++) {
			for (int j = 0; j < entries[i].length; j++) {
				System.out.println(entries[i][j].toString());
			}
		}*/
=======
		for (int i = 0; i < entries.length; i++) {
			for (int j = 0; j < entries[i].length; j++) {
				System.out.println(entries[i][j].toString());
			}
		}
>>>>>>> f2cb559a479ba5070b267a6fe2e04ec52e313bf5
		s.close();
	}

}
