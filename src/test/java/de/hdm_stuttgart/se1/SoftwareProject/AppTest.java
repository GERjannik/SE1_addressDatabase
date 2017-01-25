package de.hdm_stuttgart.se1.SoftwareProject;

import org.junit.Assert;
import org.junit.Test;

import de.hdm_stuttgart.se1.SoftwareProject.controls.CloneOfArray;
import de.hdm_stuttgart.se1.SoftwareProject.controls.CreatingEntries;
import de.hdm_stuttgart.se1.SoftwareProject.controls.FilteringEntries;

/**
 * Unit test for address database
 */
public class AppTest {

    @Test
    public void test_increaseArray_01() { // array length = 0
    	String[][] array = new String[0][];
    	String[][] clone = CreatingEntries.increaseArray(array);
		Assert.assertEquals(clone.length, 1);
    }
    
    @Test
    public void test_increaseArray_02() { // array length != 0
    	String[][] array = new String[5][];
    	String[][] clone = CreatingEntries.increaseArray(array);
		Assert.assertEquals(clone.length, 6);
    }
    
    @Test
    public void test_copyArray_01() { // empty array
    	String[][] entries = new String[0][];
    	String[][] clone = CloneOfArray.copyArray(entries);
    	Assert.assertArrayEquals(clone, entries);
    }
    
    @Test
    public void test_copyArray_02() { // array not empty
    	String[][] entries = {{"Index 0.1", "Index 0.2", "333", "444"},
    			{"Index 1.1", "Index 1.2", "", "444"},
    			{"Index 2.1", "Index 2.2", "333", ""},
    			{"Index 3.1", "Index 3.2", "", ""}};
    	String[][] clone = CloneOfArray.copyArray(entries);
    	Assert.assertArrayEquals(clone, entries);
    }
    
    @Test
    public void test_pseudoAppend_01() { // entries filled, input filled
    	String[][] entries = {{"Index 0.1", "Index 0.2", "333", "444"},
    			{"Index 1.1", "Index 1.2", "", "444"},
    			{"Index 2.1", "Index 2.2", "333", ""},
    			{"Index 3.1", "Index 3.2", "", ""}};
    	String[] input = {"Input 1", "Input 2", "Input 3", "Input 4"};
    	entries = CreatingEntries.pseudoAppend(entries, input);
    	Assert.assertTrue(entries[entries.length - 1].equals(input));
    }
    
    @Test
    public void test_pseudoAppend_02() { // entries filled, some input == null
    	String[][] entries = {{"Index 0.1", "Index 0.2", "333", "444"},
    			{"Index 1.1", "Index 1.2", "", "444"},
    			{"Index 2.1", "Index 2.2", "333", ""},
    			{"Index 3.1", "Index 3.2", "", ""}};
    	String[] input = {"Input 1", "Input 2", null, null};
    	entries = CreatingEntries.pseudoAppend(entries, input);
    	Assert.assertTrue(entries[entries.length - 1].equals(input));
    }
    
    @Test
    public void test_pseudoAppend_03() { // entries empty, input filled
    	String[][] entries = {};
    	String[] input = {"Input 1", "Input 2", "Input 3", "Input 4"};
    	entries = CreatingEntries.pseudoAppend(entries, input);
    	Assert.assertTrue(entries[entries.length - 1].equals(input));
    }
    
    @Test
    public void test_pasteArray_01() { // clone filled
    	String[][] clone = {{"Index 0.1", "Index 0.2", "333", "444"},
    			{"Index 1.1", "Index 1.2", "", "444"},
    			{"Index 2.1", "Index 2.2", "333", ""},
    			{"Index 3.1", "Index 3.2", "", ""}};
    	String[][] entries = new String[clone.length + 1][];
    	CreatingEntries.pasteArray(clone, entries);
    	for (int i = 0; i < clone.length; i++) {
    		Assert.assertArrayEquals(entries[i], clone[i]);
    	}
    	Assert.assertTrue(entries[entries.length - 1] == null);
    }
    
    @Test
    public void test_pasteArray_02() { // clone empty
    	String[][] clone = {};
    	String[][] entries = new String[clone.length + 1][];
    	CreatingEntries.pasteArray(clone, entries);
    	for (int i = 0; i < clone.length; i++) {
    		Assert.assertArrayEquals(entries[i], clone[i]);
    	}
    	Assert.assertTrue(entries[entries.length - 1] == null);
    }
    
    @Test 
    public void test_setFilter_01_1() { // pattern = "^A.*"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = "^A.*";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length + returnValue[1].length == entries.length);
    }
    
    @Test
    public void test_setFilter_01_2() { // pattern = "^A.*"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = "^A.*";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length == 3);
    }
    
    @Test
    public void test_setFilter_02_1() { // pattern = "^[A-D].*"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = "^[A-D].*";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length + returnValue[1].length == entries.length);
    }
    
    @Test
    public void test_setFilter_02_2() { // pattern = "^[A-D].*"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = "^[A-D].*";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length == 5);
    }
    
    @Test
    public void test_setFilter_03_1() { // pattern = ".*e$"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = ".*e$";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length + returnValue[1].length == entries.length);
    }
    
    @Test
    public void test_setFilter_03_2() { // pattern = ".*e$"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = ".*e$";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length == 4);
    }
    
    @Test
    public void test_setFilter_04_1() { // pattern = ".*[p-z]$"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = ".*[p-z]$";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length + returnValue[1].length == entries.length);
    }
    
    @Test
    public void test_setFilter_04_2() { // pattern = ".*[p-z]$"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "ASurnamez", "", ""},
    			{"Index 5.1", "DSurnamey", "", ""},
    			{"Index 6.1", "Surnamep", "", ""}};
    	String pattern = ".*[p-z]$";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length == 3);
    }
    
    @Test
    public void test_setFilter_05_1() { // pattern = "Surname"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "Surname", "", ""},
    			{"Index 5.1", "Surname", "", ""},
    			{"Index 6.1", "Surname", "", ""}};
    	String pattern = "Surname";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length + returnValue[1].length == entries.length);
    }
    
    @Test
    public void test_setFilter_05_2() { // pattern = "Surname"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "Surname", "", ""},
    			{"Index 5.1", "Surname", "", ""},
    			{"Index 6.1", "Surname", "", ""}};
    	String pattern = "Surname";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length == 3);
    }
    
    @Test
    public void test_setFilter_06_1() { // pattern = ".*Surname"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "Surname", "", ""},
    			{"Index 5.1", "Surname", "", ""},
    			{"Index 6.1", "Surname", "", ""}};
    	String pattern = ".*Surname";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length + returnValue[1].length == entries.length);
    }
    
    @Test
    public void test_setFilter_06_2() { // pattern = ".*Surname"
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""},
    			{"Index 4.1", "Surname", "", ""},
    			{"Index 5.1", "Surname", "", ""},
    			{"Index 6.1", "Surname", "", ""}};
    	String pattern = ".*Surname";
    	String[][][] returnValue = FilteringEntries.setFilter(pattern, entries);
    	Assert.assertTrue(returnValue[0].length == 7);
    }
    
    @Test
    public void test_endFiltering_01() { // both array filled
    	String[][] entries = {{"Name", "ASurname", "333", "444"},
    			{"Index 1.1", "AASurname", "", "444"},
    			{"Index 2.1", "BSurname", "333", ""},
    			{"Index 3.1", "LSurname", "", ""}};
    	String[][] filteredArray = {{"Index 4.1", "Surname", "", ""},
    			{"Index 5.1", "Surname", "", ""},
    			{"Index 6.1", "Surname", "", ""}};
    	String[][] array = FilteringEntries.endFiltering(filteredArray, entries);
    	Assert.assertTrue(array.length == entries.length + filteredArray.length);
    }
    
    @Test
    public void test_endFiltering_02() { // entries empty, filteredArray filled
    	String[][] entries = {};
    	String[][] filteredArray = {{"Index 4.1", "Surname", "", ""},
    			{"Index 5.1", "Surname", "", ""},
    			{"Index 6.1", "Surname", "", ""}};
    	String[][] array = FilteringEntries.endFiltering(filteredArray, entries);
    	Assert.assertTrue(array.length == entries.length + filteredArray.length);
    }
    
    @Test
    public void test_endFiltering_03() { // entries filled, filteredArray empty
    	String[][] entries = {};
    	String[][] filteredArray = {};
    	String[][] array = FilteringEntries.endFiltering(filteredArray, entries);
    	Assert.assertTrue(array.length == entries.length + filteredArray.length);
    }
    
    @Test
    public void test_endFiltering_04() { // both arrays empty
    	String[][] entries = {{"Index 4.1", "Surname", "", ""},
    			{"Index 5.1", "Surname", "", ""},
    			{"Index 6.1", "Surname", "", ""}};
    	String[][] filteredArray = {};
    	String[][] array = FilteringEntries.endFiltering(filteredArray, entries);
    	Assert.assertTrue(array.length == entries.length + filteredArray.length);
    }
}
