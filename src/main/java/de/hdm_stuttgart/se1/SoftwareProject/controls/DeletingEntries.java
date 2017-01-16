package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class DeletingEntries extends CloneOfArray {


	// lists all person entries an asks user for index to delete
	public static int askUser(Scanner s, Object[][] entries) {

		boolean legalInput = false;
		int input = -1;
		while (legalInput == false) {
			try {
				BrowsingEntries.printEntries(entries);
				System.out.println("Index of person's record to delete: ");
				input = s.nextInt();
				if (input >= 0 && input < entries.length) {
					legalInput = true;
				} else {
					System.out.println("Your choice is not in range [0..." + (entries.length - 1) + "]");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Input is not an integer!");
				s.nextLine();
			}
		}
		return input;

	}

	// this method clones array, decreases original length by 1 and
	// pastes all entries except the user choice back in original array
	public static Object[][] deleteEntry(Object[][] entries, int input) {
		Object[][] clone = copyArray(entries);

		int newLength = entries.length - 1;
		entries = new Object[newLength][];
		int index = 0;

		for (int i = 0; i < clone.length; i++) {
			if (i != input) {
				entries[index] = clone[i].clone();
				index++;
			} 
		}
		return entries;
	}
}

