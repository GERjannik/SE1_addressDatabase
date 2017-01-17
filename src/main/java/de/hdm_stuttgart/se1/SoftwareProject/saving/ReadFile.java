package de.hdm_stuttgart.se1.SoftwareProject.saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	int lines = 0;

	public String[][] sizeOfArray(File f) {
		Scanner read;
		String[][] entries = new String[0][];
		try {
			read = new Scanner(f);
			this.lines = 0;
			while (read.hasNextLine()) {
				read.nextLine();
				this.lines++;
			}
			entries = new String[lines][];

			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Speicherdatei nicht gefunden!");
		}
		return entries;
	}

	public String[][] writeEntriesInArray(String[][] entries, File f) {
		String[] collum = new String[4];
		Scanner read;
		try {
			read = new Scanner(f);
			for (int i = 0; i < this.lines; i++) {
				String content = read.nextLine();
				collum = content.split(",");
				for (int j = 0; j < 4; j++) {
					if (collum[j].equals(" ")) {
						collum[j] = null;
					}
				}
				entries[i] = collum;
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Speicherdatei nicht gefunden!");
		}

		return entries;

	}

}

