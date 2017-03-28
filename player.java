/**
 * Write a description of class Player here.
 * 
 * @author (Jonathan Ho)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class player {
    int startingTile, endTile;
    tile[] home;
    tile[] safe;

    int teamID; //0 = blue, 1 = green, 2 = red, 3 = yellow
    piece[] pieces = new piece[4];

    public player (int num, tile[] homeArray ) {
        teamID = num;
        for(int i = 0; i < 4; i++) {
            pieces[i] = new piece(num, homeArray, (i+=1)+"");
        }
        SetHome(num);
    }

    public void draw(Graphics page) {
        for(int i = 0; i < 4; i++) {
            pieces[i].draw(page);
        }
    }
    
    void SetHome(int playerNumber) {
        switch( playerNumber) {
            case 0: 
            //home = Board._instance.blueHome;
            safe = Board._instance.blueSafe;
            startingTile = 4;
            endTile = startingTile - 2;
            break;
            case 1:
            //home = Board._instance.greenHome;
            safe = Board._instance.greenSafe;
            endTile = startingTile - 2;
            startingTile = 19;
            break;
            case 2: 
            //home = Board._instance.redHome;
            safe = Board._instance.redSafe;
            endTile = startingTile - 2;
            startingTile = 34;
            break;
            case 3:
            //home = Board._instance.yellowHome;
            safe = Board._instance.yellowSafe;
            endTile = startingTile - 2;
            startingTile = 49;
            break;
        }
    }
}