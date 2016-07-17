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

public class GoogleBillboard extends PApplet {

public final static String e = "2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059";  
public void setup()  
{            
     noLoop();  
}  
public void draw()  
{   
	double number;
	for(int i = 1; i < e.length(); i++) {
		String digits = e.substring(i, i+10);
		number = Double.parseDouble(digits);
		if(isPrime(number) == true) {
			System.out.println(number);
			i = e.length();
		}
	}
}  
public boolean isPrime(double dNum) {
  if(dNum >= 2) {
    for(int i = 2; i <= Math.sqrt(dNum); i++) {
      if(dNum % i == 0)
        return false;
    }
    return true;
  } else return false;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GoogleBillboard" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
