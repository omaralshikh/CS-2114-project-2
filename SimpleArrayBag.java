// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Omar Alshikh (omar99)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * SimpleArrayBag class that adds and removes items from an array
 * 
 * @param <T>
 *            type of array
 * @author omaralshikh
 * @version 09/30/2019
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private static final int MAX = 25;

    private T[] bag;
    private int numberOfEntries;


    /**
     * SimpleArrayBag constructor that creates a new array bag
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }


    /**
     * add method to add an array
     * 
     * @param anEntry
     *            the entry being added
     * @return returns false if method fails
     */
    @Override
    public boolean add(T anEntry) {

        if (anEntry == null) {
            return false;
        }

        if (numberOfEntries < 25) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }

        return false;

    }


    /**
     * getter method for size of array
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * method to check if array is empty
     */
    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }


    /**
     * pick method that generates random numbers
     */
    @Override
    public T pick() {
        // random generator
        TestableRandom generator = new TestableRandom();

        if (isEmpty()) {
            return null;
        }
        else {
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }

    }


    /**
     * removes items from an array
     * 
     * @param anEntry
     *            the item being removed
     */
    @Override
    public boolean remove(T anEntry) {

        int index = getIndexOf(anEntry);
        if (index == -1) {
            return false;
        } // end if

        bag[index] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;

    }


    /**
     * helper method that is used by remove method
     * 
     * @param anEntry
     *            checking if the entry matches what is in the bag
     * @return return the place of the entry if it matches otherwise return -1
     */
    private int getIndexOf(T anEntry) {

        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;

            } // end if
        } // end for loop
        return -1;

    }

} // end class
