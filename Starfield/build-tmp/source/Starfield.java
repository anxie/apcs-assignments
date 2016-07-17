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

public class Starfield extends PApplet {

int screenSize = 800;
public final static int NUM_PARTS = 1000;
Particle[] particles = new Particle[NUM_PARTS + 1];
public void setup() {
	size(screenSize, screenSize);
	for(int i = 0; i < NUM_PARTS; i++) {
		particles[i] = new NormalParticle();
	}
	particles[particles.length - 1] = new OddballParticle();
}
public void draw() {
	background(0);
	for(int i = 0; i < NUM_PARTS + 1; i++) {
		particles[i].move();
		particles[i].show();
	}
}
interface Particle {
	public void show();
	public void move();
}
class NormalParticle implements Particle {
	private int colo;
	private double dX, dY, angle, speed, siz;
	NormalParticle() {
		dX = screenSize/2;
		dY = screenSize/2;
		angle = Math.PI*2*Math.random();
		speed = Math.random()*10;
		siz = Math.random()*5;
		colo = color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
	}
	public void move() {
		dX = dX + Math.cos(angle)*speed; 
		dY = dY + Math.sin(angle)*speed;
		angle = angle + Math.random();
	}
	public void show() {
		fill(colo);
		ellipse((float)dX, (float)dY, (float)siz, (float)siz);
	}
}
class OddballParticle implements Particle {
	private double dX, dY, speedX, speedY;
	OddballParticle() {
		dX = screenSize/2;
		dY = screenSize/2;
		speedX = Math.random()*11 - 5;
		speedY = Math.random()*11 - 5;
	}
	public void move() {
		speedX = Math.random()*11 - 5;
		speedY = Math.random()*11 - 5;
		if(dX <= 0 || dX >= screenSize || dY <= 0 || dY >= screenSize) {
			dX = screenSize/2;
			dY = screenSize/2;
		}
		else {
			dX = dX + speedX;
			dY = dY + speedY;
		}
	}
	public void show() {
		fill(255, 255, 255);
		ellipse((float)dX, (float)dY, 10, 10);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
