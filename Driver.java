/**
 * adds the panel containing the Game board to a frame so it is visible
 * 
 * @author (Jonathan Ho) 
 * @version (1/19/16)
 */
import javax.swing.*;
import java.awt.*;
public class Driver {
    public static void main(String [] args) {
        JFrame frame = new JFrame("Sorry!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new Board());
        
        frame.pack();
        frame.setVisible(true);
    }
}