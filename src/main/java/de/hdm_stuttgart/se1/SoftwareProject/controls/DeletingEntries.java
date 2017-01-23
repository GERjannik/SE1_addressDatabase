package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class DeletingEntries extends CloneOfArray {


	// lists all person entries an asks user for index to delete
	public static int askUser(Scanner s, String[][] array) {

		boolean legalInput = false;
		int input = 0;
		int arrayLength = 0;
		
		while (legalInput == false) {
			try {
				arrayLength = array.length;	
				BrowsingEntries.printEntries(array);
				System.out.println(arrayLength + ": No delete, back to main menu");
				System.out.println("Index of person's record to delete: ");
				input = s.nextInt();
				if (input >= 0 && input <= arrayLength) {
					return input;
				}
				
				System.err.println("Your choice is not in range [0..." + (arrayLength) + "]");
				
			} catch (java.util.InputMismatchException e) {
				System.err.println("Input is not an integer!");
				s.nextLine();
			}
		}
		return input;

	}

	// this method clones array, decreases original length by 1 and
	// pastes all entries except the user choice back in original array
	public static String[][] deleteEntry(String[][] entries, Scanner s) {
		int input = askUser(s, entries);
		if (input == entries.length) {
			return entries;
		}
		
		String[][] clone = copyArray(entries);

		int newLength = entries.length - 1;
		entries = new String[newLength][];
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

