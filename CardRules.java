import javax.swing.JOptionPane; 

/**
 * @author (Oscar Ovind) 
 * @version (V.2)
 */
public class CardRules {
    public static CardRules _instance;
    
    private static boolean nextTurn = true;
    
    public CardRules() {
        _instance = this;
    }

    /*
     * -- Jonathan takes care of it, I keep this here just in case --
     * 
     * 
     * Need a currentPlayer in the Board class
     * Each player class needs an array with ALL pieces (have a boolean if the piece is active)
     * When a card is drawn, you have to choose from the array (onlt the active) of pieces for the currentPlayer and then the selected piece from that popup is referenced here
     */
    public static piece choosePiece() {
        /*
         * This method is supposed to get a list of all the current ACTIVE pieces of the CURRENT player and a list of the INACTIVE pieces of the CURRENT player
         * This is so that the following rule knows which piece is to be referenced
         */
        return null;
    }
    
    public static void Move(player p, int amt) {
        Board._instance.Move(p.pieces[0], amt);
        if (nextTurn) {
            Board._instance.NewTurn();
        } else {
             nextTurn = true;
        }
    }

    public static void Rule0() {
    }

    public static void Rule1() {
        player p = Board._instance.currentPlayer;
        Object[] options = {"Move piece from spawn",
                "Move 1 forward"
            };
        int n = JOptionPane.showOptionDialog(null,
                "You drew '1', you can choose the following:",
                "Card Choice",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (n == JOptionPane.YES_OPTION) {
            Move(p, 0);
            //System.out.println("DEBUG: 'Move From Spawn' method is not creating and not active");
        } else {
            Move(p, 1);
        }
    }

    public static void Rule2() {
        player p = Board._instance.currentPlayer;
        nextTurn = false;
        Move(p, 2);
        JOptionPane.showMessageDialog(null, "You drew a '2', and can draw another card!");
    }
    
    public static void Rule4() {
        player p = Board._instance.currentPlayer;
        Move(p, -4);
    }
    
    public static void Rule7() {
        //TODO need to implement that players have multiple piece
    }

    public static void Rule10() {
        player p = Board._instance.currentPlayer;
        Object[] options = {"Move 10 forward",
                "Move 1 backwards"
            };
        int n = JOptionPane.showOptionDialog(null,
                "You drew 10, you can choose the following:",
                "Card Choice",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (n == JOptionPane.YES_OPTION) {
            Move(p, 10);
        } else {
            Move(p, -1);
        }
    }

    public static void Rule11() {
        player p = Board._instance.currentPlayer;
        Object[] options = {
                "Switch with Green",
                "Switch with Blue",
                "Switch with Red",
                "Switch with Yellow"
            };
        int n = JOptionPane.showOptionDialog(null,
                "You drew 11, you can choose the following:",
                "Card Choice",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
    }
}