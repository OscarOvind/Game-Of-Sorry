/**
 * @author (Vincent Chu) $co-author(Jonathan Ho, Oscar Ovind)
 * @version (V.2.5)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Board extends JPanel {
    public static Board _instance;

    player[] players = new player[4];
    int playerTurnIndex = -1;
    player currentPlayer;

    //instance fields
    tile[] tileArray = new tile[60];
    

    tile[] blue = new tile [4];
    tile[] green = new tile [4];
    tile[] red = new tile [4];
    tile[] yellow = new tile [4];

    tile[] blueSafe = new tile [6];
    tile[] greenSafe = new tile [6];
    tile[] redSafe = new tile [6];
    tile[] yellowSafe = new tile [6];

    int pieceLocationX, pieceLocationY;
    public JButton button;
    public Deck deck;
    final int BLUE_PLAYER = 0;
    final int GREEN_PLAYER = 1;
    final int RED_PLAYER = 2;
    final int YELLOW_PLAYER = 3;

    JLabel currentPlayerDisplay;

    piece[] pieceArray = new piece[4];

    piece bluePiece, greenPiece, redPiece, yellowPiece;
    //conctructor
    public Board() {
        _instance = this;

        setLayout(null);

        //creating the graphical objects
        setPreferredSize(new Dimension(500, 500));

        //for loop for creating the amount of tiles 9 at this point
        int y=0;
        int x = 0;
        int colour = 0;
        for(int i = 0; i <= 14; i++) {
            tileArray[i]= new tile(x, y,colour);
            x++;
        }
        for(int i = 15; i <= 29; i++) {
            tileArray[i]= new tile(x, y,colour);
            y++;
        }
        for(int i = 30; i <= 44; i++) {
            tileArray[i]= new tile(x, y,colour);
            x--;
        }
        for(int i = 45; i <= 59; i++) {
            tileArray[i]= new tile(x, y,colour);
            y--;
        }
        //print blue base
        colour = 1;
        x = 4;
        y= 2;
        blue[0]= new tile(x, y,colour);
        blue[1]= new tile(x+1, y,colour);
        blue[2]= new tile(x, y+1,colour);
        blue[3]= new tile(x+1, y+1,colour);
        /*(for(int i = 0; i <= 1; i++) {
            blue[i]= new tile(x, y,colour);
            System.out.println("DEBUG: bluehome[" + i +"] is: " + blue[i].getX() + ", " + blue[i].getY());
            x++;
        }
        x=4;
        y++;
        for(int i = 2; i <= 3; i++) {
            blue[i]= new tile(x, y,colour);
            System.out.println("DEBUG: bluehome[" + i +"] is: " + blue[i].getX() + ", " + blue[i].getY());
            x++;
        }
        */
        //print green base
        colour=2;
        x=12;
        y=4;
        green[0]= new tile(x, y,colour);
        green[1]= new tile(x+1, y,colour);
        green[2]= new tile(x, y+1,colour);
        green[3]= new tile(x+1, y+1,colour);
        /*
        for(int i = 0; i <= 1; i++) {
            green[i]= new tile(x, y,colour);
            x++;
        }
        x=12;
        y++;
        for(int i = 2; i <= green.length-1; i++) {
            green[i]= new tile(x, y,colour);
            x++;
        }
        */
        //print red base
        colour=3;
        x = 10;
        y= 12;
        red[0]= new tile(x, y,colour);
        red[1]= new tile(x+1, y,colour);
        red[2]= new tile(x, y+1,colour);
        red[3]= new tile(x+1, y+1,colour);
        /*
        for(int i = 0; i <= 1; i++) {
            red[i]= new tile(x, y,colour);
            x++;
        }
        x=10;
        y++;
        for(int i = 2; i <= 3; i++) {
            red[i]= new tile(x, y,colour);
            x++;
        }
        */
        //print yellow base
        colour=4;
        x=2;
        y=10;
        yellow[0]= new tile(x, y,colour);
        yellow[1]= new tile(x+1, y,colour);
        yellow[2]= new tile(x, y+1,colour);
        yellow[3]= new tile(x+1, y+1,colour);
        /*
        for(int i = 0; i <= 1; i++) {
            yellow[i]= new tile(x, y,colour);
            x++;
        }
        x=2;
        y++;
        for(int i = 2; i <= green.length-1; i++) {
            yellow[i]= new tile(x, y,colour);
            x++;
        }
        */
       
        //Print safe zone
        //blue
        x=2;
        y=1;
        colour=1;
        for(int i = 0; i <= blueSafe.length-1; i++) {
            blueSafe[i]= new tile(x, y,colour);
            y++;
        }
        //green
        x=14;
        y=2;
        colour=2;
        for(int i = 0; i <= greenSafe.length-1; i++) {
            greenSafe[i]= new tile(x, y,colour);
            x--;
        }
        //yellow
        x=13;
        y=14;
        colour=3;
        for(int i = 0; i <= redSafe.length-1; i++) {
            redSafe[i]= new tile(x, y,colour);
            y--;
        }
        //red
        x=1;
        y=13;
        colour=4;
        for(int i = 0; i <= yellowSafe.length-1; i++) {
            yellowSafe[i]= new tile(x, y,colour);
            x++;
        }

        //for(int i = 0; i < players.length; i++) {
        //    players[i] = new player(i, tileArray);
        //}
        
        int tempNumOfPlayers = 4;
        switch (tempNumOfPlayers)
        {
            case 4:
                players[tempNumOfPlayers-1] = new player(tempNumOfPlayers-1, yellow);
            case 3:
                 players[tempNumOfPlayers-2] = new player(tempNumOfPlayers-2, red);
            case 2:
                players[tempNumOfPlayers-3] = new player(tempNumOfPlayers-3, green);
            case 1:
                 players[tempNumOfPlayers-4] = new player(tempNumOfPlayers-4, blue);
        }
        
        
        
        bluePiece = players[0].pieces[0];
        pieceArray[BLUE_PLAYER] = bluePiece;

        greenPiece = players[1].pieces[0];
        pieceArray[GREEN_PLAYER] = greenPiece;

        redPiece = players[2].pieces[0];
        pieceArray[RED_PLAYER] = redPiece;

        yellowPiece = players[3].pieces[0];
        pieceArray[YELLOW_PLAYER] = yellowPiece;
        
        deck = new Deck();
        Dimension size = deck.getPreferredSize();
        deck.setBounds(180, 180, size.width, size.height);
        this.add(deck);

        currentPlayerDisplay = new JLabel("");
        currentPlayerDisplay.setBounds(170, 250+size.height, 150, 50);

        button = new JButton("Advance the piece");
        button.addActionListener(new buttonListener());       
        button.setSize(new Dimension(200, 50));
        button.setBounds(170, 200+size.height, 125, 35);
        add(button);

        repaint();
        NewTurn();
    }

    public  void paintComponent(Graphics page) {
        //painting the components
        super.paintComponent(page);
        for(int i = 0; i <= 59; i++) {
            tileArray[i].draw(page);
        } 
        for(int i = 0; i <= blue.length-1; i++) {
            blue[i].draw(page);
        } 
        for(int i = 0; i <= green.length-1; i++) {
            green[i].draw(page);
        } 
        for(int i = 0; i <= red.length-1; i++) {
            red[i].draw(page);
        } 
        for(int i = 0; i <= yellow.length-1; i++) {
            yellow[i].draw(page);
        } 
        for(int i = 0; i <= blueSafe.length-1; i++) {
            blueSafe[i].draw(page);
        } 
        for(int i = 0; i <= greenSafe.length-1; i++) {
            greenSafe[i].draw(page);
        } 
        for(int i = 0; i <= redSafe.length-1; i++) {
            redSafe[i].draw(page);
        } 
        for(int i = 0; i <= yellowSafe.length-1; i++) {
            yellowSafe[i].draw(page);
        } 
        for (int player = 0; player < players.length; player++)
        {
            players[player].draw(page);
        }
        /*
        bluePiece.draw(page);
        greenPiece.draw(page);
        redPiece.draw(page);
        yellowPiece.draw(page);
        */
    }

    /*
     * vv Code by Oscar from here vv
     */
    public int temp;
    public class buttonListener implements ActionListener {
        public void actionPerformed ( ActionEvent e) {
            GetPlayerCard();
        }
    }

    public void GetPlayerCard() {
        Card daCard = deck.Draw();
        daCard.onDraw.execute(currentPlayer);
    }

    public void NewTurn() {//Increments the playerTurnIndex, and assigns the new currentPlayer so the pieces are easily accessible
        playerTurnIndex++;
        if (playerTurnIndex >= players.length) {
            playerTurnIndex = 0;
        }
        currentPlayer = players[playerTurnIndex]; //assigns the new currentPlayer
        System.out.println("Its now Player" + playerTurnIndex + "'s turn!");
        currentPlayerDisplay.setText("Its now Player" + playerTurnIndex + "'s turn!");
    }

    /*
     * This method takes the selected piece of the current player and figures out if the wanted location (current position + the moves from the drawn card),
     * If the wanted tile location is free, then we move, if not we have to trigger the "bumb back" function /TODO
     * Then we clear the current tile for the piece and assign the piece to the new tile (and update the graphics)
     */
    public void Move(piece thePiece, int amt) {
        int currentPosition = thePiece.getlocationValue(); //current position of the player
        int wantedPosition = currentPosition + amt; //where the player wants to move the piece according to the moves by the drawn card

        if (wantedPosition >= tileArray.length) { //Handle if we get to move over the 60 tile mark
            wantedPosition -= 60;
        }
        if (wantedPosition < 0) { //if our wanted position is in the negatives
            wantedPosition += 60;
        }

        System.out.println(currentPosition + " | " + wantedPosition); //DEBUG

        //Check if the spot we want to move to is open
        if (tileArray[wantedPosition].getOccupation() == -1) {
            tileArray[currentPosition].removePiece(); //No longer occupying the curren tile
            thePiece.setlocationValue(wantedPosition); //Moves to the wanted location
            tileArray[wantedPosition].setOccupation(playerTurnIndex);
            thePiece.updateX(tileArray[wantedPosition].getX()); //Set the Graphical X coordinate
            thePiece.updateY(tileArray[wantedPosition].getY()); //Set the Graphical Y coordinate
        } else {
            System.out.println("Tile["+wantedPosition+"] is occupied! Trigger: \"bumb back\""); //this is where the bumping should happen
        }
        repaint();
        //NewTurn(); //automatically give the turn to the next player
        //Moved the newturn handling to the CardRules to be able to handle Rule2
    }
}