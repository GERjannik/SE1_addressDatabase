package de.hdm_stuttgart.se1.SoftwareProject.driver;

import java.io.File;
import java.util.Scanner;

import de.hdm_stuttgart.se1.SoftwareProject.mainmenu.Mainmenu;
import de.hdm_stuttgart.se1.SoftwareProject.mainmenu.Menu;
import de.hdm_stuttgart.se1.SoftwareProject.saving.CheckForFile;
import de.hdm_stuttgart.se1.SoftwareProject.saving.ReadFile;

public class Driver extends Menu{

	/**
	 * This is the driver class. When program starts,
	 * it has to create once:
	 * - two string arrays (entries and filteredArray),
	 * - a boolean filterToggled,
	 * - an instance of CheckForFile and ReadFile.
	 * After all necessary things are done, starts main menu 
	 * @param args
	 */
	public static void main(String[] args) {

		// main array with all entries
		String[][] entries = new String[0][];
		// temporary array with entries which match chosen filter
		String[][] filteredArray = new String[0][];
		
		// no filter toggled at the beginning
		boolean filterToggled = false;
		
		// need instances of these classes
		CheckForFile addressTxt = new CheckForFile();
		ReadFile addressFile = new ReadFile();
		Scanner s = new Scanner(System.in);
		
		// checks where the runnable zip program-file is located
		File f = addressTxt.searchDirectory();
		// if there isn't any address.txt for saving at the program location, it will be created 
		addressTxt.checkAndCreate();
		// reads the content of the address.txt and writes array "entries"
		entries = addressFile.writeEntriesInArray(addressFile.sizeOfArray(f),f);

		// main menu is started
		Mainmenu.mainmenu(entries, filteredArray, s, f, filterToggled);

		s.close();
	}
	
}
