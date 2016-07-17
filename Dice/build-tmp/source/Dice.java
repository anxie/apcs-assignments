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

public class Dice extends PApplet {

Die [][] dice = new Die[20][15];
public void setup()
{
    size(1000, 750);
    noLoop();
    for(int j =0; j < 15; j++)
    {
    	for(int i = 0; i < 20; i++)
   		{
    		dice[i][j] = new Die(50*i, 50*j);
    	}
    }
}
public void draw()
{
    background(255);
 	int sum = 0;
    for(int j = 0; j < 15; j++)
    {
    	for(int i = 0; i < 20; i++)
    	{
    		dice[i][j].roll();
    		dice[i][j].show();
    		sum = sum + dice[i][j].numDots;
    	}
    }
    fill(255,0,0);
    textSize(75);
    textAlign(CENTER);
    text("Total: " + sum, 500, 375);
}
public void mousePressed()
{
    redraw();
}
class Die //models one single dice cube
{
  int myX, myY, numDots;
  Die(int x, int y)
  {
    myX = x;
    myY = y;
  }
  public void roll()
  {
    numDots = (int)(Math.random()*6) + 1;
  }
  public void show()
  {
    fill(255);
    rect(myX, myY, 50, 50);
    fill(0);
    if(numDots % 2 == 1){
      ellipse(myX + 25, myY + 25, 10, 10);
      if(numDots != 1){
        ellipse(myX + 10, myY + 10, 10, 10);
        ellipse(myX + 40, myY + 40, 10, 10);
        if(numDots == 5){
          ellipse(myX + 10, myY + 40, 10, 10);
          ellipse(myX + 40, myY + 10, 10, 10);
        }
      }
    }else{
      ellipse(myX + 10, myY + 10, 10, 10);
      ellipse(myX + 40, myY + 40, 10, 10);
      if(numDots != 2){
        ellipse(myX + 10, myY + 40, 10, 10);
        ellipse(myX + 40, myY + 10, 10, 10);    
        if(numDots == 6){
          ellipse(myX + 10, myY + 25, 10, 10);
          ellipse(myX + 40, myY + 25, 10, 10);
        }      
      }
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
