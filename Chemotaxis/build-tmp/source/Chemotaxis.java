import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria [] colony = new Bacteria[100];
public void setup()   
{     
	size(500, 500);
	background(255);
	for(int i = 0; i < colony.length; i++)
	{
		colony[i] = new Bacteria();
	}	 
}   
public void draw()   
{  
 	background(255);
 	for(int i = 0; i < colony.length; i++)
 	{
 		colony[i].move();
 		colony[i].show();
 	}
 	//move and show the bacteria   
}  
 class Bacteria    
 {     
	int myX, myY, myColor;
	Bacteria()
 	{
 		myX = (int)(Math.random()*501);
 		myY = (int)(Math.random()*501);
 		myColor = (int)(Math.random()*256);
 	}
 	public void move()
 	{
 		if(myX < mouseX)
 		{
 			myX = myX + (int)(Math.random()*4) - 1;
 		}
 		else if(myX > mouseX)
 		{
 			myX = myX + (int)(Math.random()*4) - 2;
 		}
 		else 
 		{
 			myX = myX + (int)(Math.random()*5) - 2;	
 		}
 		if(myY < mouseY)
 		{
 			myY = myY + (int)(Math.random()*4) - 1;
 		}
 		else if(myY > mouseY)
 		{
 			myY = myY + (int)(Math.random()*4) - 2;
 		}
 		else 
 		{
 			myY = myY + (int)(Math.random()*5) - 2;	
 		}
 	}
 	public void show()
 	{
 		noStroke();
 		fill(0,myColor,0);
		ellipse(myX, myY, 10, 10);
	}
 	//lots of java!   
 }
 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
