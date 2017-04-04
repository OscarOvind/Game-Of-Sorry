
/**
 * light weight graphics object that can draw its self 
 * (its supossed theo be a circle)
 * 
 * @author (Jonathan Ho) 
 * @version (V.1 Jan 13)
 */
import javax.swing.*;
import java.awt.*;
public class piece {
    //instance fields
    private int xLocation;
    private int yLocation; 
    
    private int homeX, homeY;
    private boolean atHome;
    Color colour;
    protected int locationValue = 0;
    public String ID = new String();
    public Integer intID;
    public String myColor;
    private tile[] tiles;
    // constructor
    public piece(int player, tile startTile, String playerArray) {
        ID = playerArray;
        // sets the color
        
        switch( player)   {
            case 0: 
            colour = Color.BLUE;
            myColor = " BLUE ";
            locationValue = 4;
            break;
            case 1:
            colour = Color.GREEN;
            myColor = " GREEN ";
            locationValue = 19;
            break;
            case 2: 
            colour = Color.RED;
            myColor = " RED ";
            locationValue = 34;
            break;
            case 3:
            colour = Color.YELLOW;
            myColor = " YELLOW ";
            locationValue = 49;
            break;

        }
       
        xLocation = startTile.getX();
        yLocation = startTile.getY();
        homeX = xLocation;
        homeY = yLocation;
        atHome = true;
        tiles = Board._instance.tileArray;
    }

    // its draw method
    public void draw(Graphics g)
    {
        g.setColor(colour);
        g.fillOval(xLocation,yLocation,25,25);

        g.setColor(Color.white);
        g.drawString(ID, xLocation+10, yLocation+15);
    }
    // updates the x coodinate of the tile
    public void updateX(int x)
    {
        xLocation = x;
    }

    public void updateY(int y)
    {
        yLocation = y;
    }

    public void setlocationValue(int x)
    {
        locationValue = x;
    }

    public int getlocationValue()
    {
        return locationValue;
    }

    public void printLocation()
    {
        System.out.println("DEBUG: i am:" + myColor + "at (" + xLocation + ", " + yLocation + ")");
    }
    
    public void goHome()
    {
        xLocation = homeX;
        yLocation = homeY;
        atHome = true;
    }
    
    public void leaveHome()
    {
        atHome = true;
    }
    
    public boolean isAtHome()
    {
        return atHome;
    }
    
    public void goToStart()
    {
        xLocation = tiles[locationValue].getX();
        yLocation = tiles[locationValue].getY();
    }
    
    public int getNextSpot(int spots)
    {
        int newSpot = locationValue + spots;
        if( newSpot > 59)
            newSpot = newSpot - 60;
        else if (newSpot < 0)
            newSpot = newSpot + 60;

        return newSpot;
    }
}