// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Omar Alshikh (omar99)
package game;

import CS2114.Shape;
import CS2114.SquareShape;
import bag.SimpleBagInterface;
import student.TestableRandom;
import CS2114.Window;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.WindowSide;
import CS2114.TextShape;
import java.awt.Color;

/**
 * class that generates shapes inside a window
 * 
 * @author omaralshikh
 * @version 09/30/2019
 */
public class WhackAShape {
// initialize variables
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;


    /**
     * constructor
     */
    public WhackAShape() {
        // initialize bag
        bag = new SimpleArrayBag<Shape>();
        // initialize window
        window = new Window();
        // title for window
        window.setTitle("Project 2");
        // quit button local variable
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        // add quit button
        window.addButton(quitButton, WindowSide.SOUTH);
        // array of strings containing shapes needed
        String[] STRINGSArr = { "red circle", "blue circle", "red square",
            "blue square" };
        randomGenerator = new TestableRandom();
        // generate random number from 7-12
        int count = randomGenerator.nextInt(6) + 7;
        for (int i = 0; i < count; i++) {
            Shape projShape = buildShape(STRINGSArr[randomGenerator.nextInt(
                STRINGSArr.length)]);
            bag.add(projShape);
        } // end for loop
          // add shape to window
        window.addShape(bag.pick());

    }


    /**
     * constructor with string parameter
     * 
     * @param inputs
     *            inputs of bag
     */
    public WhackAShape(String[] inputs) {

        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        // initialize quit button
        Button quitButton = new Button("Quit");
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        // add quit button
        window.addButton(quitButton, WindowSide.SOUTH);
        for (int i = 0; i < inputs.length; i++) {

            try {
                Shape projShape = buildShape(inputs[i]);

                bag.add(projShape);

            } // end try
            catch (Exception e) {
                e.printStackTrace();

            } // end catch
        } // end for loop
          // add shape to window
        window.addShape(bag.pick());

    }


    /**
     * method to determine whether to create a circle shape or square shape
     * @param input input from bag
     * @throws IllegalArgumentException
     * @return the current shape in window
     */

    private Shape buildShape(String input) {
        // random number from 100-200
        int size = randomGenerator.nextInt(101) + 100;
        int width = window.getGraphPanelWidth();
        int height = window.getGraphPanelHeight();
        // have the shape show up inside the window
        int x = randomGenerator.nextInt(width - size);
        int y = randomGenerator.nextInt(height - size);

        if (input.contains("circle")) {
            if (input.contains("red")) {
                CircleShape currentShape = new CircleShape(x, y, size,
                    Color.RED);

                currentShape.setBackgroundColor(Color.RED);
                currentShape.onClick(this, "clickedShape");
                return currentShape;
            } // end if contains red
            else if (input.contains("blue")) {
                CircleShape currentShape = new CircleShape(x, y, size,
                    Color.BLUE);

                currentShape.setBackgroundColor(Color.BLUE);
                currentShape.onClick(this, "clickedShape");
                return currentShape;

            } // end else if
            else {

                throw new IllegalArgumentException();
            } // end else

        } // end first if

        if (input.contains("square")) {
            if (input.contains("red")) {
                SquareShape currentShape = new SquareShape(x, y, size,
                    Color.RED);
                currentShape.setBackgroundColor(Color.RED);
                currentShape.onClick(this, "clickedShape");
                return currentShape;

            } // end if contains red
            else if (input.contains("blue")) {
                SquareShape currentShape = new SquareShape(x, y, size,
                    Color.BLUE);
                currentShape.setBackgroundColor(Color.BLUE);
                currentShape.onClick(this, "clickedShape");
                return currentShape;

            } // end else if
            else {

                throw new IllegalArgumentException();
            } // end else

        } // end first if

        if (!input.contains("square") && !input.contains("circle")) {
            throw new IllegalArgumentException();
        }
        return null;

    }


    /**
     * this method is called when the user clicks the shape inside the window
     * @param shape to be clicked or removed or added
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            bag.isEmpty();
            // message shown when bag is empty
            TextShape newShape = new TextShape(0, 0, "You Win!");

            int panelWidth = window.getGraphPanelWidth();
            int panelHeight = window.getGraphPanelHeight();
            int shapeWidth = newShape.getWidth();
            int shapeHeight = newShape.getHeight();
            // have the message show up in the center
            newShape.setX((panelWidth - shapeWidth) / 2);
            newShape.setY((panelHeight - shapeHeight) / 2);
            window.addShape(newShape);

        } // end if
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * window closes when quit button is clicked
     * @param button quit button clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);

    }


    /**
     * getter method for window
     * @return window 
     */
    public Window getWindow() {
        return window;

    }


    /**
     * getter method for bag
     * @return bag
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;

    }

} // end class
