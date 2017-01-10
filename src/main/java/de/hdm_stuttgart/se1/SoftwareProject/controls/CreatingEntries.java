package de.hdm_stuttgart.se1.SoftwareProject.controls;

import java.util.Scanner;

public class CreatingEntries {

	public static Object[][] createEntry(Object[][] entries, Scanner s) {

		System.out.print("First name: ");
		String firstname = s.next();
		System.out.print("\nLast name: ");
		String lastname = s.next();
		System.out.print("\nEmail address: ");
		String emailaddress = s.next();
		System.out.print("\nPhone number: ");
		String phonenumber = s.next();
		
		Object[] input = {firstname, lastname, emailaddress, phonenumber};
		
		entries = pseudoAppend(entries, input);
		
		return entries;
	}

	public static Object[][] pseudoAppend(Object[][] entries, Object[] input) {
			
		Object[][] clone = copyArray(entries);
		entries = increaseArray(entries);
		pasteArray(clone, entries);
		entries[entries.length - 1] = input;
		
		return entries;
	}
	
	// not needed anymore, methods summarized in one method below
	public static Object[][] copyArray(Object[][] entries) {

		Object [][] clone;

		clone = new Object[entries.length][];
		for (int i = 0; i < entries.length; i++) {
			clone[i] = entries[i].clone();
		}		
		return clone;
	}

	public static Object[][] increaseArray(Object[][] entries) {
		int length = entries.length;
		entries = new Object[length + 1][];
		return entries;
	}

	public static Object[][] pasteArray(Object[][] clone, Object[][] entries) {

		for (int i = 0; i < clone.length; i++) {
			entries[i] = clone[i].clone();
		}
		return entries;
	}

	public static Object[][] increaseEntries(Object[][] entries) {

		//clone "entries" into new Array "clone"
		Object [][] clone;

		clone = new Object[entries.length][];
		for (int i = 0; i < entries.length; i++) {
			clone[i] = entries[i].clone();
		}

		//increase the length of "entries" by 1
		int length = entries.length;
		entries = new Object[length + 1][];

		//paste "clone" back into the bigger Array "entries"
		for (int i = 0; i < clone.length; i++) {
			entries[i] = clone[i].clone();
		}
		return entries;

	}
}
