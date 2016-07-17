int x;
int y;
int rad;

void setup()
{
	size(300,300);
	background(255);
	noLoop();
}

void draw()
{
	drawBubbles();
	if (keyPressed==true)
	{
		background(random(255),random(255),random(255));
	}
}

void drawBubbles()
{
	noStroke();
	fill(random(100),random(100),random(150,255),50);
	x = mouseX;
	y = mouseY;
	rad = int(random(100));
	ellipse(x, y, rad, rad);
	fill(0,0,200,50);
	ellipse(x, y, rad - 5, rad - 5);
	fill(255,255,255,50);
	ellipse(x - 5, y - 10, rad - 10, rad - 10);
}

void mousePressed()
{
	redraw();
}

