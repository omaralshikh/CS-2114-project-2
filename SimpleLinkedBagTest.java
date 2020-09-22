// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Omar Alshikh (omar99)
package game;

import org.junit.Before;
import student.TestCase;
import student.TestableRandom;

/**
 * test class for SimpleLinkedBag class
 * 
 * @author omaralshikh
 * @version 09/30/2019
 */
public class SimpleLinkedBagTest extends TestCase {
    // initialize variables 
    private SimpleLinkedBag<String> arrayBag;
    private String anEntry;


    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        arrayBag = new SimpleLinkedBag<String>();

    }


    /**
     * tests the add method
     */
    public void testAdd() {
        assertFalse(arrayBag.add(anEntry));
        anEntry = "hello";
        assertTrue(arrayBag.add(anEntry));

    }


    /**
     * test getCurrent size method
     */
    public void testGetCurrentSize() {
        assertEquals(0, arrayBag.getCurrentSize());
    }


    /**
     * tests when bag is empty and not empty
     */
    public void testIsEmpty() {
        anEntry = "good";

        assertTrue(arrayBag.isEmpty());
        anEntry = "good";

        arrayBag.add(anEntry);
        assertFalse(arrayBag.isEmpty());
    }


    /**
     * tests the pick method
     */

    public void testPick() {
        TestableRandom.setNextInts(0, 1, 2);
        assertNull(arrayBag.pick());
        anEntry = "coffee";
        arrayBag.add(anEntry);

        arrayBag.add("tea");

        arrayBag.add("soda");

        assertEquals("soda", arrayBag.pick());

        assertEquals("tea", arrayBag.pick());

        assertEquals("coffee", arrayBag.pick());

    }


    /**
     * tests the remove method by using the helper method getReferenceTo()
     */
    public void testRemove() {
        assertFalse(arrayBag.remove(anEntry));
        // add an entry to bag
        anEntry = "office";
        arrayBag.add(anEntry);
        // remove added entry
        assertTrue(arrayBag.remove(anEntry));
        arrayBag.add("file2");
        arrayBag.add("file3");

        assertFalse(arrayBag.remove("file"));

    }

} // end test class
