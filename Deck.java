/**
 * Holds all the cards, and manages the following functions; draw, shuffle (current pile) and reset (fills pile)
 * 
 * @author (Oscar Ovind) 
 * @version (V.1 - 08/02/2017)
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Deck extends JPanel {
    java.util.List<Card> currentDeck = new java.util.ArrayList<Card>();

    private boolean removeCardOnDraw = false;

    Card currentCardDisplay;
    public Deck() {
        this.setSize(new Dimension(150, 200));

        currentCardDisplay = new Card(-1);
        this.add(currentCardDisplay);

        CardRules cr = new CardRules();
        Reset();
    }

    public Card Draw() {
        if (currentDeck.size() == 1) {
            //System.out.println("--------- Only one card remains -------");
            Reset();
            //System.out.println("Deck was empty, now refilled");
        }

        Card drawnCard = currentDeck.get((int)(Math.random() * currentDeck.size() - 1));
        if (removeCardOnDraw) {
            currentDeck.remove(drawnCard);
        }

        if (currentCardDisplay != null) {
            currentCardDisplay.Set(drawnCard.getValue());
            currentCardDisplay.repaint();
        } else {
            System.out.println("woopsies");
        }
        //System.out.println("The deck drew: " + drawnCard.getValue());

        //drawnCard.cardEffect.execute();

        return drawnCard;
    }

    public void Reset() {
        for (int a = 0; a < 13; a++) {
            for(int b = 0; b < 4; b++) {
                currentDeck.add(new Card(a));
            }
        }

        Shuffle();
    }

    public void Shuffle() {
        Collections.shuffle(currentDeck, new Random());
    }
}