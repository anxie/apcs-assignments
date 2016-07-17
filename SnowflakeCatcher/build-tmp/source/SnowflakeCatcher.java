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

public class SnowflakeCatcher extends PApplet {

SnowFlake [] flakes = new SnowFlake[50];
public void setup()
{
  size(300,300);
  for(int i = 0; i < flakes.length; i++)
  {
    flakes[i] = new SnowFlake();
  }
  //your code here
}
public void draw()
{
  background(0);
  for(int i = 0; i < flakes.length; i++)
  {
    flakes[i].erase();
    flakes[i].lookDown();
    flakes[i].move();
    flakes[i].wrap();
    flakes[i].show();
  }
  //your code here
}
public void mouseDragged()
{
  //your code here
}

class SnowFlake
{
  int x, y;
  boolean isMoving;
  //class member variable declarations
  SnowFlake()
  {
    x = (int)(Math.random()*301);
    y = (int)(Math.random()*301);
    isMoving = true;
    //class member variable initializations
  }
  public void show()
  {
    fill(255);
    ellipse(x, y, 5, 5);
    //your code here
  }
  public void lookDown()
  {
    if(y > 0 || y < 300)
    {
      if(get(x, y+1) != color(0, 0, 0))
      {
          isMoving = false;
      }else
      {
        isMoving = true;
      }
    }
    //your code here
  }
  public void erase()
  {
    fill(0);
    ellipse(x, y, 7, 7);
    //your code here
  }
  public void move()
  {
    if(isMoving)
    {
      y = y + 1;
    }
    //your code here
  }
  public void wrap()
  {
    //your code here
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
