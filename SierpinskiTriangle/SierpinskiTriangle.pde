int siz = 500;
public void setup()
{
	size(siz + 300, siz + 300);
	background(0);
	sierpinski(50, 600, siz);
}
public void draw()
{

}
public void mouseDragged() 
{
	background(0);
	fill(255);
	sierpinski(mouseX, mouseY, siz);
	fill(255, 0, 0);
	ellipse(mouseX, mouseY, 10, 10);
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
  		fill(255);
  		triangle(x, y, x + len, y, x + len/2, y - len);
  	}
}
