/**
 * Samantha Bryan
 * I pledge my honor that I have abided by the Stevens Honor System
 */
package HW6;
/**
 * Imports JUnit testing
 */
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class CountingSortTest {

    /**
     * This test tests an array that is empty to ensure that it returns an empty array
     */
    @Test
    public void testSortWithEmptyArray() {
        int[] emptyArray = {};
        assertArrayEquals("Sorting empty array should return empty array", emptyArray, CountingSort.sort(emptyArray));
    }

    /**
     * This test tests an array with only one number to ensure that it returns the same array
     */
    @Test
    public void testSortWithSingleElement() {
        int[] singleElementArray = {5};
        assertArrayEquals("Sorting single element array should return the same array", singleElementArray, CountingSort.sort(singleElementArray));
    }

    /**
     * This test tests to make sure that an array with numbers 0...n is sorted correctly
     */
    @Test
    public void testSortWithNumbers() {
        int[] unsortedArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] sortedArray = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        assertArrayEquals("Sorting array should return sorted array", sortedArray, CountingSort.sort(unsortedArray));
    }

    /**
     * This test tests the same as the last test but also tests that it works with 0 in the array
     */
    @Test
    public void testSortWithZeros() {
        int[] unsortedArray = {3, 1, 4, 1, 0, 12, 5, 9, 2, 6, 5, 3};
        int[] sortedArray = {0, 1, 1, 2, 3, 3, 4, 5, 5, 6, 9, 12};
        assertArrayEquals("Sorting array with zeros should return sorted array", sortedArray, CountingSort.sort(unsortedArray));
    }

}
