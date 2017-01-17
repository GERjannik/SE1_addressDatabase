package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class CloneOfArray {

	public static String[][] copyArray(String[][] entries) {

		String [][] clone;

		clone = new String[entries.length][];
		for (int i = 0; i < entries.length; i++) {
			clone[i] = entries[i].clone();
		}		
		return clone;
	}
	
}
