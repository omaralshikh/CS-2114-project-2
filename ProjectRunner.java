// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Omar Alshikh (omar99)
package game;

/**
 * class that includes the main method
 * 
 * @author omaralshikh
 * @version 09/30/2019
 */
public class ProjectRunner {

    /**
     * main method that runs the program under two conditions
     * 
     * @param input
     */
    public static void main(String[] input) {
        // condition 1 if length is grater than 0 use the constructor with
        // string parameter
        if (input.length > 0) {
            new WhackAShape(input);

        } // end if
        // condition 2 - if not use the default constructor
        else {
            new WhackAShape();
        } // end else
    } // end main

} // end class
