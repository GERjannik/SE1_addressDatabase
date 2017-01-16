package de.hdm_stuttgart.se1.SoftwareProject.saving;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author mi
 * 
 * needed: instance of CheckForFile in Main, then call 1. searchDirectory, 2. checkAndCreate
 *
 */
public class CheckForFile {

	File file;
	String absoluteFilePath;


	/**
	 * 
	 * 1. gets the location of the jar file
	 * 2. deletes the name of the jar file
	 * 3. adds the address.txt to the path and convert from String to File
	 * 
	 * 
	 */
	public File searchDirectory() {

		String fileName = "address.txt";
		String path="";
		
		// 1.
		try {
			path = new String(TempApp.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		// 2.
		int pos = path.lastIndexOf("/");
		String reducedPath = path.substring(0, pos+1);

		// 3.
		this.absoluteFilePath = reducedPath + fileName;
		this.file = new File(absoluteFilePath);
		
		return this.file;
	}

	/**
	 * check for existing file and create if not exist
	 * call the method in main method after creating a instance of CheckForFile
	 */
	public void checkAndCreate() {

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
