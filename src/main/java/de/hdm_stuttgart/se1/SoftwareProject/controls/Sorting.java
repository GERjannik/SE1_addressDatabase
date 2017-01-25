package de.hdm_stuttgart.se1.SoftwareProject.controls;

public class Sorting {

	/**
	 * Checks if the array is already in the correct order
	 * @param array The array which should be sorted by surname
	 * @return true if array is sorted correctly, false if not
	 */
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

	/**
	 * Jumps from index to index and checks, whether the first char of the surname from entry[index]
	 * comes before the first char of the surname from entries[index+1]. If not, they will be changed.
	 * Finishes, if all entries are in correct order.
	 * @param array which should be sorted
	 * @return the sorted array
	 */
	public static String[][] sortArray(String[][] array) {

		boolean correctOrder = false;
		String[] help= new String[4];
		
		if (array.length == 0 || array.length == 1) {
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
