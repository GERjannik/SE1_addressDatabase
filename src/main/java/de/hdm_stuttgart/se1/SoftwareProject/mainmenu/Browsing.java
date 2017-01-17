package de.hdm_stuttgart.se1.SoftwareProject.mainmenu;

import de.hdm_stuttgart.se1.SoftwareProject.controls.BrowsingEntries;

public class Browsing extends BrowsingEntries {

	public static void caseBrowsing(String[][] filteredArray, String[][] entries, boolean filterToggled) {
		if (filterToggled == false) {
			printEntries(entries);
		}
		if (filterToggled == true) {
			printEntries(filteredArray);
		}
	}
}
