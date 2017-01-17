package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class FilteringEntries extends CloneOfArray {


	public static String askForFilter(Scanner s) {
		System.out.println("Filter phrase: ");
		String pattern = s.nextLine();
		return pattern;
	}

	public static int setFilterCases(String pattern) {

		// check for filter expression "^A.*"
		if (pattern.substring(0, 0).equals("^") 
				&& pattern.substring(pattern.length() - 2, pattern.length() - 1).equals(".*")) {
			return 0;
		}
		// check for filter expression "^[A-D].*"

		if (pattern.substring(0, 1).equals("^[") 
				&& pattern.substring( pattern.length()-3, pattern.length()-1).equals("].*")) {
			return 0;
		}
		// check for filter expression ".*$s"
		if (pattern.substring(0, 1).equals(".*") 
				&& pattern.substring(pattern.length() - 1, pattern.length() - 1).equals("$")) {
			return 0;
		}
		// if no regular expression is true, this case will check entries containing filter input
		return 1;
	}

	// switches in the correct case and creates filteredArray
	public static String[][][] switchFilter(int cases, String pattern, String[][] entries) {

		String[][][] returnValue = new String[2][][];
		String[][] filteredArray = new String[0][];
		String[][] tempArray = new String[0][];

		int length = 0,
				indexTemp = 0,
				index = 0;

		switch (cases) {

		case 0: // check how many entries match filter expression
			for (int i = 0; i < entries.length; i++) {
				if (entries[i][1].matches(pattern)) {
					length++;
				}
			}
			// create new array (temporary), so we can reduce Array "entries" by the filter matches
			tempArray = new String[entries.length - length][];
			// create new array with all entries which contain filter expression
			filteredArray = new String[length][];
			for (int i = 0; i < entries.length; i++) {
				if (entries[i][1].matches(pattern)) {
					filteredArray[index] = entries[i].clone();
					index++;
				} else {
					tempArray[indexTemp] = entries[i].clone();
					indexTemp++;
				}
			}

			// clone remaining entries back in original Array
			entries = tempArray.clone();

			returnValue[0] = filteredArray;
			returnValue[1] = entries;
			
			return returnValue;

		case 1: // check how many entries contain filter expression
			for (int i = 0; i < entries.length; i++) {
				if (entries[i][1].contains(pattern)) {
					length++;
				}
			}
			// create new array (temporary), so we can reduce Array "entries" by the filter matches
			tempArray = new String[entries.length - length][];
			// create new array with all entries which contain filter expression
			filteredArray = new String[length][];
			for (int i = 0; i < entries.length; i++) {
				if (entries[i][1].contains(pattern)) {
					filteredArray[index] = entries[i].clone();
					index++;
				} else {
					tempArray[indexTemp] = entries[i].clone();
					indexTemp++;
				}
			}
			// clone remaining entries back in original Array
			entries = tempArray.clone();

			returnValue[0] = filteredArray;
			returnValue[1] = entries;

			return returnValue;		
		}
		return returnValue;
	}



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

public static String[][][] completeFilterMethod(Scanner s, String[][] entries, String pattern) {
	return switchFilter(setFilterCases(pattern), pattern, entries);
}
}
