package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.io.File;
import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.mainmenu.Menu;
import de.hdm_stuttgart.se1.SoftwareProject.saving.CheckForFile;
import de.hdm_stuttgart.se1.SoftwareProject.saving.ReadFile;

public class Driver extends Menu{

	public static void mainmenu
			(String[][] entries, String[][] filteredArray, Scanner s, File f, boolean filterToggled) {

		printMenu();
		int choice = chooseOption(s);

		Object[][][] returnValues = switchOption(choice, filteredArray, entries, filterToggled, s, f);
		entries = (String[][]) returnValues[0];
		filteredArray = (String[][]) returnValues[1];
		filterToggled = (boolean) returnValues[2][0][0];

		mainmenu(entries, filteredArray, s, f, filterToggled);
	}

	public static void main(String[] args) {

		String[][] entries = new String[0][];
		String[][] filteredArray = new String[0][];
		
		boolean filterToggled = false;
		
		CheckForFile addressTxt = new CheckForFile();
		ReadFile addressFile = new ReadFile();
		Scanner s = new Scanner(System.in);
		
		File f = addressTxt.searchDirectory();
		addressTxt.checkAndCreate();
		entries = addressFile.writeEntriesInArray(addressFile.sizeOfArray(f),f);

		mainmenu(entries, filteredArray, s, f, filterToggled);

		s.close();
	}

}
