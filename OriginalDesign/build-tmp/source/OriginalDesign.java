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

public class OriginalDesign extends PApplet {

int x;
int y;
int rad;

public void setup()
{
	size(300,300);
	background(255);
	noLoop();
}

public void draw()
{
	drawBubbles();
	if (keyPressed==true)
	{
		background(random(255),random(255),random(255));
	}
}

public void drawBubbles()
{
	noStroke();
	fill(random(100),random(100),random(150,255),50);
	x = mouseX;
	y = mouseY;
	rad = PApplet.parseInt(random(100));
	ellipse(x, y, rad, rad);
	fill(0,0,200,50);
	ellipse(x, y, rad - 5, rad - 5);
	fill(255,255,255,50);
	ellipse(x - 5, y - 10, rad - 10, rad - 10);
}

public void mousePressed()
{
	redraw();
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
