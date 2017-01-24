package de.hdm_stuttgart.se1.SoftwareProject.saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	int lines = 0;

	/**
	 * Counts the lines of our .txt-file and creates an array with the correct length.
	 * @param f The file (and location) where our "database" entries are saved.
	 * @return an array with the correct length.
	 */
	public String[][] sizeOfArray(File f) {

		String[][] entries = new String[0][];
		try {
			Scanner read = new Scanner(f);
			this.lines = 0;
			while (read.hasNextLine()) {
				read.nextLine();
				this.lines++;
			}
			entries = new String[this.lines][];

			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Speicherdatei nicht gefunden!");
		}
		return entries;
	}

	/**
	 * Scans one line in the file. Splits the String at every ",".
	 * Creates the inner String[] array and writes the array into the array
	 * containing the entries. Repeats the steps until all lines are read.
	 * @param f The file (and location) where our "database" entries are saved.
	 * @return the array containing all entries of the "database"-file
	 */
	public String[][] writeEntriesInArray(File f) {
		
		String[] row = new String[4];
		String[][] entries = sizeOfArray(f);
		
		try {
			Scanner read = new Scanner(f);
			for (int i = 0; i < this.lines; i++) {
				String content = read.nextLine();
				row = content.split(",");
				for (int j = 0; j < 4; j++) {
					if (row[j].equals(" ")) {
						row[j] = null;
					}
				}
				entries[i] = row;
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Speicherdatei nicht gefunden!");
		}

		return entries;

	}

}

