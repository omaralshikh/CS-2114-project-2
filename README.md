# Data-Structures-and-Algorithms-Project-2

In this project you will learn how to extend and implement the rudimentary methods of a SimpleLinkedBag and a SimpleArrayBag. 
Both of these classes will implement theSimpleBagInterface<T>. You will then use these methods to create a very familiar game, 
where you have a Window with Shapes which disappear when clicked. These Shapes will either be the CircleShape or SquareShape classes. 
These Shape instances will be stored in your SimpleBagInterface<Shape> and will be predetermined by input strings. 
These input strings will be one of the following:

red circle
blue circle
red square
blue square

Your job will be to convert these strings into shapes and add them to your bag. When it comes time to play the game in a Window, 
you will use the pick() method to randomly select one shape to display on the screen without removing it. 
Each Shape will have anonClick() method defined so you can listen when the user clicks on them, just like. 
When clicked, you will remove the shape from the Window, take it out of the Bag, and display another random shape from the bag until the bag is empty. 
Once the bag is empty, you will display a TextShape saying, “You Win!” The Window will have a Quit button on 
the South side of the window which will quit the program and end the game
