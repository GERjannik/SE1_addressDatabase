package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class Sorting {

	private static boolean checkMethod(String[][] array) {
		for (int index = 0; index < array.length - 1; index++) {
			if (array[index][1].charAt(0) > array[index + 1][1].charAt(0)) {
				return false;
			}
			if (array[index][1].charAt(0) <= array[index + 1][1].charAt(0) 
					&& index == array.length - 2) {
				return true;
			}
		}
		return false;
	}

	public static String[][] sortArray(String[][] array) {

		boolean correctOrder = false;
		String[] help= new String[4];
		
		if (array.length == 0) {
			return array;
		}

		while (correctOrder == false) {
			for (int i = 0; i < array.length-1; i++) {
				int index  = 0;
				while (array[i + index][1].charAt(0) > array[i + index + 1][1].charAt(0)) {  
					help = array[i + index + 1]; 
					array[i + index + 1] = array[i + index]; 
					array[i + index] = help; 
					index++; 
					if (i + index + 1 >= array.length) { 
						break; 
					}  
				}  
			}
			correctOrder = checkMethod(array);
		}
		return array;
	}
}
