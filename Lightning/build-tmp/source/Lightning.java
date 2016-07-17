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

public class Lightning extends PApplet {

int startX = 150;
int startY = 35;
int endX = 150;
int endY = 35;

public void setup()
{
	size(300,300);
	strokeWeight(2);
	background(0);
	drawSky();
}

public void draw()
{
	stroke((int)(Math.random()*256));
    while(endY < 300)
    {
       endX = startX + (int)(Math.random()*19) - 9;
       endY = startY + (int)(Math.random()*10);
       line(startX, startY, endX, endY);
       startX = endX;
       startY = endY;
	}
	if(keyPressed == true)
	{
		background(0);
		drawSky();
	}
}

public void mousePressed()
{
	startX = mouseX;
	startY = 35;
	endX = 150;
	endY = 35;
	fill(0,0,0,20);
	rect(0,0,300,300);
}

public void drawSky()
{
	noStroke();
	fill(200);
	int xPos = 0;
	while(xPos < 301)
	{
	ellipse(xPos,10,60,50);
	xPos = xPos + 50;
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
