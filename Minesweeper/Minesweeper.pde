import de.bezier.guido.*;
//Declare and initialize NUM_ROWS and NUM_COLS = 20
public final static int NUM_ROWS = 20;
public final static int NUM_COLS = 20;
private MSButton[][] buttons; //2d array of minesweeper buttons
private ArrayList <MSButton> bombs = new ArrayList <MSButton>(); //ArrayList of just the minesweeper buttons that are mined

void setup ()
{
    size(400, 400);
    textAlign(CENTER,CENTER);
    
    // make the manager
    Interactive.make( this );
    
    buttons = new MSButton[NUM_ROWS][NUM_COLS];
    for(int row = 0; row < NUM_ROWS; row++) {
        for(int col = 0; col < NUM_COLS; col++) {
            buttons[row][col] = new MSButton(row, col);
        }
    }
    //declare and initialize buttons
    setBombs();
}
public void setBombs()
{
    for(int i = 0; i < 25; i++) {
        int row = (int)(Math.random()*NUM_ROWS);
        int col = (int)(Math.random()*NUM_COLS);
        if(!bombs.contains(buttons[row][col]))
            bombs.add(buttons[row][col]);
    }
}

public void draw ()
{
    background( 0 );
    if(isWon())
        displayWinningMessage();
}
public boolean isWon()
{
    for(int row = 0; row < NUM_ROWS; row++) {
        for(int col = 0; col < NUM_COLS; col++) {
            if(!bombs.contains(buttons[row][col]) && !buttons[row][col].isClicked())
                return false;
        }
    }
    return true;        
}
public void displayLosingMessage()
{
    for(int i = 0; i < bombs.size(); i++)
        bombs.get(i).clicked = true;
    //your code here
}
public void displayWinningMessage()
{
    for(int row = 8; row < 13; row++) {
        buttons[row][7].setLabel("W");
        buttons[row][8].setLabel("I");
        buttons[row][9].setLabel("N");
        buttons[row][10].setLabel("N");
        buttons[row][11].setLabel("E");
        buttons[row][12].setLabel("R");
    }
    //your code here
}

public class MSButton
{
    private int r, c;
    private float x,y, width, height;
    private boolean clicked, marked;
    private String label;
    
    public MSButton(int rr, int cc)
    {
        width = 400/NUM_COLS;
        height = 400/NUM_ROWS;
        r = rr;
        c = cc; 
        x = c*width;
        y = r*height;
        label = "";
        marked = clicked = false;
        Interactive.add(this); // register it with the manager
    }

    public boolean isMarked()
    {
        return marked;
    }
    public boolean isClicked()
    {
        return clicked;
    }
    // called by manager
    
    public void mousePressed () 
    {
        clicked = true;
        if(mouseButton == RIGHT)
            marked = !marked;
        else if(bombs.contains(this))
            displayLosingMessage();
        else if(this.countBombs(r, c) > 0)
            this.setLabel(str(this.countBombs(r, c)));
        else {
            for(int i = -1; i < 2; i++) {
                for(int j = -1; j < 2; j++) {
                    if(!(i == 0 && j == 0)) {
                        if(isValid(r + i, c + j) && !buttons[r + i][c + j].isClicked())
                            buttons[r + i][c + j].mousePressed();
                    }
                }
            }
        }
    }

    public void draw () 
    {    
        if (marked)
            fill(0);
        else if( clicked && bombs.contains(this) ) 
            fill(255,0,0);
        else if(clicked)
            fill( 200 );
        else 
            fill( 100 );

        rect(x, y, width, height);
        fill(0);
        text(label,x+width/2,y+height/2);
    }
    public void setLabel(String newLabel)
    {
        label = newLabel;
    }
    public boolean isValid(int r, int c)
    {
        if(r >= 0 && r < NUM_ROWS && c >= 0 & c < NUM_COLS)
            return true;
        return false;
    }
    public int countBombs(int row, int col)
    {
        int numBombs = 0;
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(!(i == 0 && j == 0)) {
                    if(isValid(row + i, col + j) && bombs.contains(buttons[row + i][col + j]))
                      numBombs++;
                }
            }
        }
        return numBombs;
    }
}
