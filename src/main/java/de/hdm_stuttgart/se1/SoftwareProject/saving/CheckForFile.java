package de.hdm_stuttgart.se1.SoftwareProject.saving;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import de.hdm_stuttgart.se1.SoftwareProject.driver.Driver;

public class CheckForFile {

	File file;
	String absoluteFilePath;
	
	/**
	 * The .txt-file should be created at the location of the runnable .zip-file.
	 * This method checks for location:
	 * 1. Method finds the location of the program in file directory
	 * 2. Deletes the filename of the .zip-file
	 * 3. Adds address.txt to the remaining file path
	 * 4. Converts the "String" into a "File"
	 * @return the complete name (with location) of the address.txt file 
	 */
	public File searchDirectory() {

		String fileName = "address.txt";
		String path="";
		
		// 1.
		try {
			path = new String(Driver.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		// 2.
		int pos = path.lastIndexOf("/");
		String reducedPath = path.substring(0, pos+1);

		// 3.
		this.absoluteFilePath = reducedPath + fileName;
		
		// 4.
		this.file = new File(absoluteFilePath);
		
		return this.file;
	}
	
	/**
	 * Checks if the file already exists. If not, it will be created.
	 */
	public void checkAndCreate() {

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
