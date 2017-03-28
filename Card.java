/**
 * This is the card class that holds the value and the rule associated (in text form)
 * 
 * @author (Oscar Ovind) 
 * @version (V.2)
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Card extends JPanel {
    //All the rules in test form for trying to make the textarea work and look nice
    private String[] rules = {
            "Sorry!",
            "Move from start or move forward 1",
            "Move 2 and draw a card",
            "Move forward 3",
            "Move backwards 4",
            "Move forward 5",
            "Move forward 6",
            "Move forward 7 or split between two pieces",
            "Move forward 8",
            "Move forward 9",
            "Move forward 10 or move backward 1",
            "Move forward 11 or change places wit an opponent",
            "Move forward 12"
        };

    //Graphical variables
    private int cardWidth = 100;
    private int cardHeight = 150;

    private int X = 0;
    private int Y = 0;

    //Graphical components
    private JLabel valueDisplay;
    private JTextArea textArea;

    //Card variables
    private int cardValue;
    private String cardRule;

    public DrawEffect onDraw;

    public Card(int myValue) {        
        this.setLayout(new BorderLayout());

        this.setSize(new Dimension(cardWidth, cardHeight));

        //Value display
        valueDisplay = new JLabel();
        valueDisplay.setFont (valueDisplay.getFont ().deriveFont (32.0f));
        this.add(valueDisplay, BorderLayout.NORTH);

        //Text area so the rules that would normally go off-screen, can get wrapped and displayed correctly as well as inside the card
        //TODO: The textarea slighty overlaps the drawn borders. This should be fixed so it actually looks nice
        textArea = new JTextArea(0,0);
        textArea.setPreferredSize(new Dimension(cardWidth, (cardHeight/2)));
        textArea.setFont(valueDisplay.getFont ().deriveFont (12.0f));
        textArea.setEditable(false);
        textArea.setText(cardRule);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        this.add(textArea, BorderLayout.SOUTH);

        //Draw();
        if (myValue != -1) {
            Set(myValue);
            SetEffect();
        }
    }

    private void SetEffect() {
        switch(cardValue) {
            case 1:
            onDraw = new DrawEffect() {
                public void execute(player p) {
                    CardRules._instance.Rule1();
                }
            };
            break;
            case 2:
            onDraw = new DrawEffect() {
                public void execute(player p) {
                    CardRules._instance.Rule2();
                }
            };
            break;
            case 4:
            onDraw = new DrawEffect() {
                public void execute(player p) {
                    CardRules._instance.Rule4();
                }
            };
            break;
            case 10:
            onDraw = new DrawEffect() {
                public void execute(player p) {
                    CardRules._instance.Rule10();
                }
            };
            break;
            default:
            onDraw = new DrawEffect() {
                public void execute(player p) {
                    CardRules._instance.Move(p, cardValue);
                }
            };
            break;
        }
    }

    /*
     * The draw method for the card
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Make it look nice
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Fill
        g2d.setColor(Color.WHITE);
        g2d.fillRect(X,Y,cardWidth,cardHeight);

        //Border
        g2d.setColor(Color.BLACK);
        g2d.drawRect(X,Y,cardWidth,cardHeight);
    }

    public void Set(int num) {

        if (num < 0) {
            num *= -1;
        }

        cardValue = num;
        valueDisplay.setText(cardValue+"");

        cardRule = rules[cardValue]; //Gets the rule associated with the new cardValue
        textArea.setText(cardRule); //Sets the description area of the card to display the rule

        repaint();

        if (cardValue == 4) {
            cardValue = -4;
        }
    }

    /*
     * -----REMOVED AND ADDED TO THE DECK CLASS SO WE HAVE SENTRALIZED MANAGING FOR CARD ACTIONS-----
     * ----- DO NOT USE -----
     */
    public int Draw() {
        Random rand = new Random();
        cardValue = rand.nextInt((rules.length-1) - 0 + 1); //Gets the new cardValue from 0-12
        valueDisplay.setText(cardValue+"");

        cardRule = rules[cardValue]; //Gets the rule associated with the new cardValue
        textArea.setText(cardRule); //Sets the description area of the card to display the rule

        return cardValue;
    }

    public int getValue() {
        return cardValue;
    }
}