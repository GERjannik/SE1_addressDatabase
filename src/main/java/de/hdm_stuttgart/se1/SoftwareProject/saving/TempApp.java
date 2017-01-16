package de.hdm_stuttgart.se1.SoftwareProject.saving;

import de.hdm_stuttgart.se1.SoftwareProject.saving.CheckForFile;

public class TempApp {
	
	public static void main(String[] args) {

		CheckForFile f = new CheckForFile();
		f.searchDirectory();
		f.checkAndCreate();
		

		
	}

}
