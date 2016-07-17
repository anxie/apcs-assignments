Chemotaxis
==========
Chemotaxis is when an organism moves toward or away from a chemical stimulus, like food. Biologists write software using random walks to model and study how very small organisms like bacteria search for food. In this assignment you will create a simulation of organisms moving away from a starting position using a random walk. This assignment is similar in some ways to the ticklish penguin, but is different in that you must create a class to represent the organisms. NOTE: you must use Math.random() for all the random numbers in this assignment. The random() function we used in processing last year is not part of the AP subset.

Requirements
============
This assignment will have a Bacteria class

The class Bacteria will have the following members:
3 ints which hold the x and y coordinates of the bacteria position, and the bacteria color.
A constructor which initializes the 3 ints
void move() which moves the bacteria in a random walk pattern.
void show() which draws the bacteria in the correct position
   
Extensions
==========

If you have extra time, you might try to have the bacteria move in a "biased random walk" towards some stimulus like a piece of food or the mouse. You can modify your class so the bacteria have a finite lifespan and can reproduce. Your simulation doesn't have to look like mine. Have fun and be creative.
