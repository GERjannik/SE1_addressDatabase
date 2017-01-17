package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class FilteringEntries extends CloneOfArray {


	public static String askForFilter(Scanner s) {
		
		System.out.println("Filter phrase: ");
		String pattern = s.nextLine();
		return pattern;
	}

	// creates "filteredArray" and removes filtered entries from "entries"
	public static String[][][] setFilter(String pattern, String[][] entries) {

		String[][][] returnValue = new String[2][][];
		String[][] filteredArray = new String[0][];
		String[][] entriesReduced = new String[0][];

		int length = 0,
				indexTemp = 0,
				index = 0;


		for (int i = 0; i < entries.length; i++) {
			if (entries[i][1].matches(pattern)) {
				length++;
			}
		}
		// create new array, so we can reduce Array "entries" by the filter matches
		entriesReduced = new String[entries.length - length][];
		// create new array with all entries which contain filter expression
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


		returnValue[0] = filteredArray;
		returnValue[1] = entriesReduced;

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

}
