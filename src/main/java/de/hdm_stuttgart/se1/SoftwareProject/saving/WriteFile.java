package de.hdm_stuttgart.se1.SoftwareProject.saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class WriteFile {

	 static Formatter x;
	
	public static void writeInFile(File f, String[][] entries) {
		try {
			x = new Formatter(f);
			for (int i = 0; i < entries.length; i++) {
				for (int j = 0; j < entries[i].length; j++) {
					if (entries[i][j] == null && j == 3) {
						x.format("%s\n", " ");
					} else if (entries[i][j] == null) {
						x.format("%s,", " ");
					} else if (j == 3) {
						x.format("%s\n", entries[i][j].toString());
					} else {
						x.format("%s,", entries[i][j].toString());
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		x.close();
	}
}
