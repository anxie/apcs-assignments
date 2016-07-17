int screenHeight = 600;
int screenWidth = 1000;
int flakeRadius = 3;
int bgColor = color(0, 0, 0);
int penColor = color(255, 0, 0);
int penSize = 10;
SnowFlake [] flakes = new SnowFlake[100];
void setup() 
{
  size(screenWidth, screenHeight);
  background(bgColor);
  for(int i = 0; i < flakes.length; i++)
  {
    flakes[i] = new SnowFlake();
  }
}
void draw() 
{
  for(int i = 0; i < flakes.length; i++)
  {
    flakes[i].erase();
    flakes[i].lookDown();
    flakes[i].move();
    flakes[i].wrap();
    flakes[i].show();
  }
}
void mouseDragged() 
{
  if(mouseButton == LEFT) 
  {
    fill(penColor);
    noStroke();
    ellipse(mouseX, mouseY, penSize, penSize);
  } 
  else if(mouseButton == RIGHT) 
  {
    fill(bgColor);
    noStroke();
    ellipse(mouseX, mouseY, 14, 14);
  }
}
void mouseClicked() 
{
  if(mouseButton == CENTER) penColor = color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
}
void keyPressed() 
{
  if(keyCode == UP) penSize += 2;
  if(keyCode == DOWN) penSize += -2;
  if(key == 'a') background(bgColor);
  if(key == 'b') 
  {
    background(bgColor);
    for(int i = 0; i < flakes.length; i++) 
    {
      flakes[i].reshuffle();
    }
  }
}
class SnowFlake 
{
  int x, y;
  boolean isMoving;
  SnowFlake() 
  {
    x = (int)(Math.random()*screenWidth);
    y = (int)(Math.random()*(screenHeight - 10));
    isMoving = true;
  }
  void show()
  {
    fill(255);
    ellipse(x, y, flakeRadius*2, flakeRadius*2);
  }
  void lookDown() 
  {
    if(y > 0 || y < 300)
    {
      if(get(x, y + flakeRadius + 1) != bgColor) isMoving = false;
      else isMoving = true;
    }
  }
  void erase()
  {
    fill(0);
    ellipse(x, y, flakeRadius*2 + 2, flakeRadius*2 + 2);
  }
  void move()
  {
    if(isMoving) y++;
  }
  void wrap()
  {
    if(y >= screenHeight - flakeRadius - 1) y = 0;
  }
  void reshuffle()
  {
    x = (int)(Math.random()*screenWidth);
    y = (int)(Math.random()*(screenHeight - 10));
  }
}
