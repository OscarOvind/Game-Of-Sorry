/**
 * define a windows wich has a x and y coordinate and can draw it self
 * 
 * @author (jonathan Ho) 
 * @version (2/14/16)
 */
import java.awt.*;
import javax.swing.*;

public class tile// class for makeing a tile
{
    int wide, tall, total, upperX;
    int upperY = 0;
    public  static  final int HEIGHT= 25;
    public static final int WIDTH = 25;
    int vertHeight = 1;
    int horiCoe = 4;
    
    Color color = Color.lightGray;
    
    int occupying = -1;
    // -1 because it is outside array bounds
    // constructor that takes in a x( the tile number and translates it into the x coorinate
    public tile (int x , int y)
    {
        upperX = x * 30;
        upperY = y * 30;
    }
    public tile (int x , int y, int c)
    {
        upperX = x * 30;
        upperY = y * 30;
        switch (c)
        {
            case 1:
                color = new Color(12, 176, 232);
                break;
            case 2:
                color = new Color(0, 255, 209);
                break;
            case 3:
                color = new Color(255, 134, 95);
                break;
            case 4:
                color = new Color(255, 248, 162);
                break;
                
        }
    }
    //returns the x coodinate of the tle for use with the tile
    public int getX()
    {
        return upperX;
    }
    public int getY()
    {
        return upperY;
    }
    //draw method
    public void draw (Graphics page)//windows draw method that has a R. N. G. to randomize if the wondows will be drawn or not
    {
        page.setColor(color);       
        page.fillRect(upperX, upperY, WIDTH, HEIGHT);
    }
    
    public void setOccupation(int x)
    {
        occupying = x;
    }
    
    public void removePiece()
    {
        occupying = -1;
    }
    
    public int getOccupation()
    {
        return occupying;
    }
}