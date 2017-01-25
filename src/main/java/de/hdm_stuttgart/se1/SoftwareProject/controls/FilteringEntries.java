package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class FilteringEntries extends CloneOfArray {

	/**
	 * Method asking the user for the filter phrase
	 * @param s Scanner needed for user input
	 * @return the filter phrase the user has typed in
	 */
	public static String askForFilter(Scanner s) {
		
		System.out.println("Filter phrase: ");
		String pattern = s.nextLine();
		
		return pattern;
	}

	/**
	 * The second indexes of the entries are checked for matches with the filter phrase.
	 * If there's a match, the full entry is copied into the filtered array and
	 * deleted from the entries array
	 * @param pattern The filter phrase user has entered
	 * @param entries The array with all entries
	 * @return a three-dimensional Array containing array of entries and
	 * array of filtered entries
	 */
	public static String[][][] setFilter(String pattern, String[][] entries) {

		String[][][] returnValue = new String[2][][];
		String[][] filteredArray = new String[0][];
		String[][] entriesReduced = new String[0][];

		int length = 0;
		int indexTemp = 0;
		int index = 0;

		for (int i = 0; i < entries.length; i++) { // checks how long the filteredArray must be
			if (entries[i][1].matches(pattern)) {
				length++;
			}
		}
		
		// creates new array, so we can reduce array "entries" by the filter matches
		entriesReduced = new String[entries.length - length][];
		
		// creates new array with all entries which contain filter expression
		filteredArray = new String[length][];
		
		for (int i = 0; i < entries.length; i++) {
			if (entries[i][1].matches(pattern)) {
				filteredArray[index] = entries[i].clone();
				index++;
			} else {
				entriesReduced[indexTemp] = entries[i].clone();
				indexTemp++;
			}
		}

		returnValue[0] = filteredArray; // filteredArray contains all filtered entries 
		returnValue[1] = entriesReduced; // entriesReduced contains all not-filtered entries

		return returnValue;
	}

	/**
	 * If user untoggles filter, the array with the filtered entries and the
	 * array entries will be merged.
	 * @param filteredArray Array containing all filtered entries 
	 * @param entries Array containing all not-filtered entries
	 * @return one array containing all entries of both arrays
	 */
	public static String[][] endFiltering(String[][] filteredArray, String[][] entries) {
		
		int newLength = entries.length + filteredArray.length;
		int index = 0;
		
		String[][] clone = copyArray(entries);
		
		entries = new String[newLength][];
		
		for (int i = 0; i < clone.length; i++) {
			entries[index] = clone[i].clone();
			index++;
		}
		for (int i = 0; i < filteredArray.length; i++) {
			entries[index] = filteredArray[i].clone();
			index++;
		}
		
		return entries;
	}

}
