package de.hdm_stuttgart.se1.SoftwareProject.mainmenu;

import de.hdm_stuttgart.se1.SoftwareProject.controls.BrowsingEntries;

public class Browsing extends BrowsingEntries {

	/**
	 * Method checks if a filter is toggled, and calls printEntries with the correct array in parameter.
	 * If no filter is toggled, entries is printed. If filter is active, filteredArray is printed.
	 * @param filteredArray If filter is toggled, this array includes all entries matching the filter
	 * @param entries The array containing all entries of our address database
	 * @param filterToggled true if a filter is toggled, false when the program starts
	 * 
	 */
	public static void caseBrowsing(String[][] filteredArray, String[][] entries, boolean filterToggled) {
		if (filterToggled == false) {
			printEntries(entries);
		}
		if (filterToggled == true) {
			printEntries(filteredArray);
		}
	}
}
