package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class CreatingEntries extends CloneOfArray {

	/**
	 * Asks the user for input. The method ends not until the input is not empty.
	 * @param s Scanner needed for user input
	 * @param data Output with information the user is asked for
	 * @return the input of the user
	 */
	public static String requiredInput(Scanner s, String data) {
		String input = "";
		while (input.isEmpty()) {
			System.out.println(data);
			input = s.nextLine();
			if (input.isEmpty()) {
				System.out.println("Empty input is not allowed");
			}
		}
		return input;
	}
	
	/**
	 * Asks the user for optional input. If input is empty, method returns "null". 
	 * @param s Scanner needed for user input
	 * @param data Output with information the user is asked for
	 * @return the input of the user
	 */
	public static String optionalInput(Scanner s, String data) {
		System.out.println(data);
		String input = s.nextLine();
		if (input.isEmpty()) {
			input = null;
		}
		return input;
	}
	
	
	/**
	 * Asks the user for all information. After the input of the user, an array "input" with all
	 * information is initialized. Then the array of all entries is increased by one and
	 * "input" is added to "entries".
	 * @param entries Array containing all entries.
	 * @param s Scanner needed for user input
	 * @return the array "entries", increased by one and added a new entry
	 */
	public static String[][] createEntry(String[][] entries, Scanner s) {

		s.nextLine();
		
		String askForName = "First name: ";
		String firstname = requiredInput(s, askForName);
		
		String askForLastname = "Last name: ";
		String lastname = requiredInput(s, askForLastname);
		
		String askForEmail = "Optional input email address: ";
		String emailaddress = optionalInput(s, askForEmail);
		
		String askForphonenumber = "Optional input phonenumber: ";
		String phonenumber = optionalInput(s, askForphonenumber);
		
		String[] input = {firstname, lastname, emailaddress, phonenumber};
		
		entries = pseudoAppend(entries, input);
		
		return entries;
	}

	/**
	 * @param entries Array containing all entries.
	 * @param input Array containing all information user entered
	 * @return the array "entries", increased by one and added a new entry
	 */
	public static String[][] pseudoAppend(String[][] entries, String[] input) {
			
		String[][] clone = copyArray(entries);
		entries = increaseArray(entries);
		pasteArray(clone, entries);
		entries[entries.length - 1] = input;
		
		return entries;
	}

	/**
	 * @param entries Array containing all entries.
	 * @return "entries" increased by one
	 */
	public static String[][] increaseArray(String[][] entries) {
		int length = entries.length;
		entries = new String[length + 1][];
		return entries;
	}

	/**
	 * Pastes "clone" back into "entries".
	 * @param clone Clone of array "entries"
	 * @param entries Array containing all entries.
	 * @return entries with one empty index
	 */
	public static String[][] pasteArray(String[][] clone, String[][] entries) {

		for (int i = 0; i < clone.length; i++) {
			entries[i] = clone[i].clone();
		}
		return entries;
	}
}
