package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class Sorting {

	public static String[][] sortArray(String[][] array) {

		int index = 0;
		String[] help= new String[array[0].length];

		//while (array[index][1].charAt(0) > array[index + 1][1].charAt(0)) {
			for (int i = 0; i < array.length-1; i++) {
				index  = 0;
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
		//}
		return array;
	}
}
