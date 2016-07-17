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

public class AsteroidsGame extends PApplet {

public final static int NUM_STARS = (int)(Math.random()*50);
SpaceShip annie = new SpaceShip();
Star [] stars = new Star[NUM_STARS];
public void setup() 
{
  size(700,700);
  for(int i = 0; i < stars.length; i++) {stars[i] = new Star();}
}
public void draw() 
{
  background(0);
  annie.show();
  annie.move();
  for(int i = 0; i < stars.length; i++) {stars[i].show();}
}
public void keyPressed()
{
  if(keyCode == UP) {annie.accelerate(0.1f);}
  else if(keyCode == DOWN) {annie.accelerate(-0.1f);}
  else if(keyCode == LEFT) {annie.rotate(-20);}
  else if(keyCode == RIGHT) {annie.rotate(20);}
  else if(keyCode == ENTER) 
  {
    annie.setX((int)(Math.random()*width));
    annie.setY((int)(Math.random()*height));
    annie.setPointDirection((int)(Math.random()*360));
    annie.setDirectionX(0);
    annie.setDirectionY(0);
  }
}
class SpaceShip extends Floater  
{
  public SpaceShip() 
  {
    corners = 4;
    xCorners = new int[corners];
    yCorners = new int[corners];
    xCorners[0] = -2;
    yCorners[0] = 0;
    xCorners[1] = -8;
    yCorners[1] = 8;
    xCorners[2] = 16;
    yCorners[2] = 0;
    xCorners[3] = -8;
    yCorners[3] = -8;
    myColor = color(255, 255, 255);
    myCenterX = 250;
    myCenterY = 250;
    myDirectionX = 0;
    myDirectionY = 0;
    myPointDirection = 0;
  }
  public void setX(int x) {myCenterX = x;}
  public int getX() {return (int) myCenterX;}
  public void setY(int y) {myCenterY = y;}
  public int getY() {return (int) myCenterY;}
  public void setDirectionX(double x) {myDirectionX = x;}   
  public double getDirectionX() {return myDirectionX;}   
  public void setDirectionY(double y) {myDirectionY = y;}
  public double getDirectionY() {return myDirectionY;}
  public void setPointDirection(int degrees) {myPointDirection = degrees;}   
  public double getPointDirection() {return myPointDirection;}
}
class Star
{
  private int xStars, yStars, radius1, radius2;
  public Star()
  {
    xStars = (int)(Math.random()*width);
    yStars = (int)(Math.random()*height);
    radius1 = 4;
    radius2 = 2;
  }
  public void show()
  {
    stroke(255, 255, 150);
    float angle = TWO_PI/5;
    float halfAngle = angle/2.0f;
    beginShape();
    for (float a = 0; a < TWO_PI; a += angle) {
      float sx = xStars + cos(a) * radius2;
      float sy = yStars + sin(a) * radius2;
      vertex(sx, sy);
      sx = xStars + cos(a+halfAngle) * radius1;
      sy = yStars + sin(a+halfAngle) * radius1;
      vertex(sx, sy);
    } 
  endShape(CLOSE);
  }
}
abstract class Floater //Do NOT modify the Floater class! Make changes in the SpaceShip class 
{   
  protected int corners;  //the number of corners, a triangular floater has 3   
  protected int[] xCorners;   
  protected int[] yCorners;   
  protected int myColor;   
  protected double myCenterX, myCenterY; //holds center coordinates   
  protected double myDirectionX, myDirectionY; //holds x and y coordinates of the vector for direction of travel   
  protected double myPointDirection; //holds current direction the ship is pointing in degrees    
  abstract public void setX(int x);  
  abstract public int getX();   
  abstract public void setY(int y);   
  abstract public int getY();   
  abstract public void setDirectionX(double x);   
  abstract public double getDirectionX();   
  abstract public void setDirectionY(double y);   
  abstract public double getDirectionY();   
  abstract public void setPointDirection(int degrees);   
  abstract public double getPointDirection(); 

  //Accelerates the floater in the direction it is pointing (myPointDirection)   
  public void accelerate (double dAmount)   
  {          
    //convert the current direction the floater is pointing to radians    
    double dRadians =myPointDirection*(Math.PI/180);     
    //change coordinates of direction of travel    
    myDirectionX += ((dAmount) * Math.cos(dRadians));    
    myDirectionY += ((dAmount) * Math.sin(dRadians));       
  }   
  public void rotate (int nDegreesOfRotation)   
  {     
    //rotates the floater by a given number of degrees    
    myPointDirection+=nDegreesOfRotation;   
  }   
  public void move ()   //move the floater in the current direction of travel
  {      
    //change the x and y coordinates by myDirectionX and myDirectionY       
    myCenterX += myDirectionX;    
    myCenterY += myDirectionY;     

    //wrap around screen    
    if(myCenterX >width) {myCenterX = 0;}    
    else if (myCenterX<0) {myCenterX = width;}    
    if(myCenterY >height) {myCenterY = 0;}   
    else if (myCenterY < 0) {myCenterY = height;}   
  }   
  public void show ()  //Draws the floater at the current position  
  {             
    fill(myColor);   
    stroke(myColor);    
    //convert degrees to radians for sin and cos         
    double dRadians = myPointDirection*(Math.PI/180);                 
    int xRotatedTranslated, yRotatedTranslated;    
    beginShape();         
    for(int nI = 0; nI < corners; nI++)    
    {     
      //rotate and translate the coordinates of the floater using current direction 
      xRotatedTranslated = (int)((xCorners[nI]* Math.cos(dRadians)) - (yCorners[nI] * Math.sin(dRadians))+myCenterX);     
      yRotatedTranslated = (int)((xCorners[nI]* Math.sin(dRadians)) + (yCorners[nI] * Math.cos(dRadians))+myCenterY);      
      vertex(xRotatedTranslated,yRotatedTranslated);    
    }   
    endShape(CLOSE);  
  }   
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "AsteroidsGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
