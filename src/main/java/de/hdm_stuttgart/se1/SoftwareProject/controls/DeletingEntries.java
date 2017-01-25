package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class DeletingEntries extends CloneOfArray {

	/**
	 * Lists all person entries of the array and
	 * asks the user for index to be deleted. User has the option
	 * to go back to main menu without deleting one entry.
	 * @param s Scanner needed for user input
	 * @param array If filter is toggled this array is "filteredArray",
	 * if not this array is "entries"
	 * @return an Integer of the index the user wants to delete
	 */
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

	/**
	 * Clones the relevant array into a temporary, new array. Reduces the length of 
	 * the relevant array by one. And copies all entries which should not be deleted 
	 * from the temporary array back into the relevant array. 
	 * @param array If filter is toggled this array is "filteredArray",
	 * if not this array is "entries"
	 * @param s Scanner needed for user input
	 * @return the @array reduced by the entry user chose to delete
	 */
	public static String[][] deleteEntry(String[][] array, Scanner s) {
		
		int input = askUser(s, array);
		
		if (input == array.length) { // if user chose option "Back to main menu"
			return array;
		}
		
		String[][] clone = copyArray(array);

		int newLength = array.length - 1;
		array = new String[newLength][];
		int index = 0;

		for (int i = 0; i < clone.length; i++) {
			if (i != input) {
				array[index] = clone[i].clone();
				index++;
			} 
		}
		
		return array;
	}
}

