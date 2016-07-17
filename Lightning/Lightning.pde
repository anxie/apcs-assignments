int startX = 150;
int startY = 35;
int endX = 150;
int endY = 35;

void setup()
{
	size(300,300);
	strokeWeight(2);
	background(0);
	drawSky();
}

void draw()
{
	stroke((int)(Math.random()*256));
    while(endY < 300)
    {
       endX = startX + (int)(Math.random()*19) - 9;
       endY = startY + (int)(Math.random()*10);
       line(startX, startY, endX, endY);
       startX = endX;
       startY = endY;
	}
	if(keyPressed == true)
	{
		background(0);
		drawSky();
	}
}

void mousePressed()
{
	startX = mouseX;
	startY = 35;
	endX = 150;
	endY = 35;
	fill(0,0,0,20);
	rect(0,0,300,300);
}

void drawSky()
{
	noStroke();
	fill(255);
	int xPos = 0;
	while(xPos < 301)
	{
	ellipse(xPos,10,60,50);
	xPos = xPos + 50;
	}
}
