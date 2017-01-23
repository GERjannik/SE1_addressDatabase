package de.hdm_stuttgart.se1.SoftwareProject;

import org.junit.Assert;
import org.junit.Test;

import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;

/**
 * Unit test for address database
 */
public class AppTest {

    @Test
    public void test_increase_01() {
    	String[][] array = new String[0][];
    	String[][] clone = CreatingEntries.increaseArray(array);
		Assert.assertEquals(clone.length, array.length + 1);
    }
    
    @Test
    public void test_increase_02() {
    	String[][] array = new String[5][];
    	String[][] clone = CreatingEntries.increaseArray(array);
		Assert.assertEquals(clone.length, array.length + 1);
    }
}
