package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class CloneOfArray {

	public static Object[][] copyArray(Object[][] entries) {

		Object [][] clone;

		clone = new Object[entries.length][];
		for (int i = 0; i < entries.length; i++) {
			clone[i] = entries[i].clone();
		}		
		return clone;
	}
	
}
