// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Omar Alshikh (omar99)
package game;

import student.TestCase;
import student.TestableRandom;

/**
 * test class for SimpleArrayBag
 * 
 * @author omaralshikh
 * @version 09/30/2019
 */
public class SimpleArrayBagTest extends TestCase {

    private SimpleArrayBag<String> arrayBag;
    private String anEntry;


    /**
     * setup for test class
     */
    public void setUp() {
        arrayBag = new SimpleArrayBag<String>();

    }


    /**
     * tests the add method
     */
    public void testAdd() {
        assertFalse(arrayBag.add(anEntry));
        anEntry = "hi";
        for (int i = 0; i < 25; i++) {
            assertTrue(arrayBag.add(anEntry));

        }
        anEntry = "hello";
        assertFalse(arrayBag.add(anEntry));

    }


    /**
     * test get current size method
     */
    public void testGetCurrentSize() {
        assertEquals(0, arrayBag.getCurrentSize());
    }


    /**
     * tests if bag is empty
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
        anEntry = "yes";
        arrayBag.add(anEntry);
        arrayBag.add("no");
        arrayBag.add("maybe");

        assertEquals("yes", arrayBag.pick());

        assertEquals("no", arrayBag.pick());

        assertEquals("maybe", arrayBag.pick());

    }


    /**
     * tests the remove method by calling the helper method getIndexOf()
     */
    public void testRemove() {

        assertFalse(arrayBag.remove(anEntry));
        // add entry to array
        anEntry = "cs";

        arrayBag.add(anEntry);
        // remove entry from array
        assertTrue(arrayBag.remove(anEntry));
        anEntry = "csc";
        arrayBag.add(anEntry);
        assertTrue(arrayBag.remove(anEntry));

        arrayBag.add("cc1");
        arrayBag.add("cc2");
        assertFalse(arrayBag.remove("cc"));

    }

} // end test class
