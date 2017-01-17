package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class CreatingEntries extends CloneOfArray {

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
	
	public static String optionalInput(Scanner s, String data) {
		System.out.println(data);
		String input = s.nextLine();
		if (input.isEmpty()) {
			input = null;
		}
		return input;
	}
	
	
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

	public static String[][] pseudoAppend(String[][] entries, String[] input) {
			
		String[][] clone = copyArray(entries);
		entries = increaseArray(entries);
		pasteArray(clone, entries);
		entries[entries.length - 1] = input;
		
		return entries;
	}
	
	// not needed anymore, methods summarized in one method below
	

	public static String[][] increaseArray(String[][] entries) {
		int length = entries.length;
		entries = new String[length + 1][];
		return entries;
	}

	public static String[][] pasteArray(String[][] clone, String[][] entries) {

		for (int i = 0; i < clone.length; i++) {
			entries[i] = clone[i].clone();
		}
		return entries;
	}
	
	

	public static String[][] increaseEntries(String[][] entries) {

		//clone "entries" into new Array "clone"
		String[][] clone;

		clone = new String[entries.length][];
		for (int i = 0; i < entries.length; i++) {
			clone[i] = entries[i].clone();
		}

		//increase the length of "entries" by 1
		int length = entries.length;
		entries = new String[length + 1][];

		//paste "clone" back into the bigger Array "entries"
		for (int i = 0; i < clone.length; i++) {
			entries[i] = clone[i].clone();
		}
		return entries;

	}
}
