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

public class SierpinskiTriangle extends PApplet {

int siz = 500;
public void setup()
{
	size(siz, siz);
	background(0);
}
public void draw()
{
	sierpinski(0, siz, siz);
}
public void sierpinski(int x, float y, int len) 
{
	if(len > 20) 
	{
 		sierpinski(x, y, len/2);
 		sierpinski(x + len/2, y, len/2);
 		sierpinski(x + len/4, y - len/2, len/2);
  	}
  	else 
  	{
  		fill((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
  		triangle(x, y, x + len, y, x + len/2, y - len);
  	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
