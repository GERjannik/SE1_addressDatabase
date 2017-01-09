package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.util.Scanner;

public class Mainmenu {

	public static void main(String[] args) {
		System.out.println("Main Options:\n\n"
				+ "0: Browse Person Entries\n"
				+ "1: Toggle filtering person entries\n"
				+ "2: Create new person entry\n"
				+ "3: Delete person entry\n"
				+ "4: Exit");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Your choice:");
		int choice = s.nextInt();
	}

}
