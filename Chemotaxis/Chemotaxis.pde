Bacteria [] colony = new Bacteria[150];
void setup()   
{     
	size(1000, 800);
	background(255);
	for(int i = 0; i < colony.length; i++)
	{
		colony[i] = new Bacteria();
	}	 
}   
void draw()   
{  
 	fill(255, 255, 255, 50);
 	rect(0, 0, 1000, 800);
 	for(int i = 0; i < colony.length; i++)
 	{
 		colony[i].move();
 		colony[i].show();
 	}
 	//move and show the bacteria   
}  
 class Bacteria    
 {     
	int myX, myY, myColor, mySize;
	Bacteria()
 	{
 		myX = (int)(Math.random()*1001);
 		myY = (int)(Math.random()*801);
 		myColor = (int)(Math.random()*256);
 		mySize = (int)(Math.random()*10) + 1;
 	}
 	void move()
 	{
 		if(myX < mouseX)
 		{
 			myX = myX + (int)(Math.random()*4) - 1;
 		}
 		else if(myX > mouseX)
 		{
 			myX = myX + (int)(Math.random()*4) - 2;
 		}
 		else 
 		{
 			myX = myX + (int)(Math.random()*5) - 2;	
 		}
 		if(myY < mouseY)
 		{
 			myY = myY + (int)(Math.random()*4) - 1;
 		}
 		else if(myY > mouseY)
 		{
 			myY = myY + (int)(Math.random()*4) - 2;
 		}
 		else 
 		{
 			myY = myY + (int)(Math.random()*5) - 2;	
 		}
 	}
 	void show()
 	{
 		noStroke();
 		fill(0,myColor,0);
		ellipse(myX, myY, mySize, mySize);
	}
 	//lots of java!   
 }
 
