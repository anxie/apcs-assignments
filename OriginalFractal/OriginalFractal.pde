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