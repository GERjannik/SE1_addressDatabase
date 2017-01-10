package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class BrowsingEntries {

	public static void printEntries(Object[][] entries) {
		
		System.out.println("Current person records\n");
		
		for (int i = 0; i < entries.length; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < entries[i].length; j++) {
				System.out.print(entries[i][j]);
				if (j == 1) {
					System.out.print(", email: ");
				}
				if (j == 2) {
					System.out.println(", phone: ");
				}
			}
		}
		System.out.println("\n-----------------------------------");
	}
	
	
}
