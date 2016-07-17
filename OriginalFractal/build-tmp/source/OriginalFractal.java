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

public class OriginalFractal extends PApplet {

public void setup() {
  size(600, 600);
  background(255);
  noFill();
  fractal(300, 300, 300);
}

public void draw() {

}

public void fractal(double x, double y, int rad) {
  strokeWeight(3);
  stroke(0);
  if(rad >= 75) {
    fractal(x, y - rad/2, rad/2);
    fractal(x + rad * sqrt(3)/4, y - rad/4, rad/2);
    fractal(x + rad * sqrt(3)/4, y + rad/4, rad/2);
    fractal(x, y + rad/2, rad/2);
    fractal(x - rad * sqrt(3)/4, y + rad/4, rad/2);
    fractal(x - rad * sqrt(3)/4, y - rad/4, rad/2);
  }
  ellipse((float)x, (float)y, 2*rad, 2*rad);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
