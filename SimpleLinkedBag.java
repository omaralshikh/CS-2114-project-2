// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Omar Alshikh (omar99)
package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * simple linked bag class that works with adding and removing nodes
 * @param <T> type of bag
 * @author omaralshikh
 * @version 09/30/2019
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;


    /**
     * constructor that nulls the first node
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     *  add method that adds a new entry
     *  @param anEntry entry being added
     */

    @Override
    public boolean add(T anEntry) {

        if (anEntry == null) {
            return false;
        } // end if
        Node<T> newNode = new Node<>(anEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;

        numberOfEntries = numberOfEntries + 1;
        return true;

    }


    /**
     * getter method for size of bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * method to check if bag is empty
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
        TestableRandom generator = new TestableRandom();
        if (isEmpty()) {
            return null;
        } // end if
        else {

            int index = generator.nextInt(numberOfEntries);
            Node<T> newNode = firstNode;

            for (int i = 0; i < index; i++) {
                newNode = newNode.next();

            } // end for loop
            return newNode.data();
        } // end else

    }


    /**
     * removes entries from the bag
     * @param anEntry entry being removed 
     */
    @Override
    public boolean remove(T anEntry) {
        Node<T> nodeN = getReferenceTo(anEntry);
        if (nodeN == null) {
            return false;
        } // end if
        else {
            nodeN.setData(firstNode.data());
            firstNode = firstNode.next();
            numberOfEntries--;
            return true;
        } // end else

    }


    /**
     *  helper method for remove method
     * @param anEntry entry being referenced 
     * @return current node in bag
     */
    private Node<T> getReferenceTo(T anEntry) {

        boolean found = false;
        Node<T> currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            } // end if
            else {
                currentNode = currentNode.next();
            } // end else
        } // end while loop
        return currentNode;

    }

} // end class
