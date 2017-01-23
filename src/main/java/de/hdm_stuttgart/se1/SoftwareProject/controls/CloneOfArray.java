package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class CloneOfArray {

	/**
	 * Clones one array
	 * @param entries Array which is cloned into a new one
	 * @return a clone of entries
	 */
	public static String[][] copyArray(String[][] entries) {

		String [][] clone;

		clone = new String[entries.length][];
		for (int i = 0; i < entries.length; i++) {
			clone[i] = entries[i].clone();
		}		
		return clone;
	}
	
}
