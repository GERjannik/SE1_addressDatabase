package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class BrowsingEntries {

	/**
	 * Prints entries of the array sorted by surname
	 * @param entries The array which should be sorted first and printed afterwards
	 * 
	 */
	public static void printEntries(String[][] entries) {
		
		entries = Sorting.sortArray(entries);
		System.out.println("Current person records:");
		
		for (int i = 0; i < entries.length; i++) {
			System.out.print("\n" + i + ":");
			for (int j = 0; j < entries[i].length; j++) {
				if (entries[i][j] == null) {
					System.out.print(" -");
				} else {
					System.out.print(" " + entries[i][j]);
				}
				if (j == 1) {
					System.out.print(", email:");
				}
				if (j == 2) {
					System.out.print(", phone:");
				}
			}
		}
		System.out.println("\n-----------------------------------");
	}
	
	
}
