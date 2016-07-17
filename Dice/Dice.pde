Die [][] dice = new Die[20][15];
void setup()
{
    size(1000, 750);
    noLoop();
    for(int j = 0; j < 15; j++)
    {
    	for(int i = 0; i < 20; i++)
   		{
    		dice[i][j] = new Die(50*i, 50*j);
    	}
    }
}
void draw()
{
    background(255);
 	int sum = 0;
    for(int j = 0; j < 15; j++)
    {
    	for(int i = 0; i < 20; i++)
    	{
    		dice[i][j].roll();
    		dice[i][j].show();
    		sum = sum + dice[i][j].numDots;
    	}
    }
    fill(255,0,0);
    textSize(75);
    textAlign(CENTER);
    text("Total: " + sum, 500, 375);
}
void mousePressed()
{
    redraw();
}
class Die //models one single dice cube
{
  int myX, myY, numDots;
  Die(int x, int y)
  {
    myX = x;
    myY = y;
  }
  void roll()
  {
    numDots = (int)(Math.random()*6) + 1;
  }
  void show()
  {
    fill(255);
    rect(myX, myY, 50, 50);
    fill(0);
    if(numDots % 2 == 1){
      ellipse(myX + 25, myY + 25, 10, 10);
      if(numDots != 1){
        ellipse(myX + 10, myY + 10, 10, 10);
        ellipse(myX + 40, myY + 40, 10, 10);
        if(numDots == 5){
          ellipse(myX + 10, myY + 40, 10, 10);
          ellipse(myX + 40, myY + 10, 10, 10);
        }
      }
    }else{
      ellipse(myX + 10, myY + 10, 10, 10);
      ellipse(myX + 40, myY + 40, 10, 10);
      if(numDots != 2){
        ellipse(myX + 10, myY + 40, 10, 10);
        ellipse(myX + 40, myY + 10, 10, 10);    
        if(numDots == 6){
          ellipse(myX + 10, myY + 25, 10, 10);
          ellipse(myX + 40, myY + 25, 10, 10);
        }      
      }
    }
  }
}
