//Samarth Chetan
//June 16, 2023
//This class creates the frame and panel in which the game is played on

package jungle;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Game extends JFrame implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
      //overrides the main method to avoid an error
    }
   
    public void runGame(){

        //creates the frame for the game and sets its presets
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Jungle Jam!");
        ImageIcon image = new ImageIcon("jgl.jpg");
        window.setIconImage(image.getImage());

        //creates the panel and adds it to the frame
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //sets the game size as final (cannot change it)
        window.pack();
        window.setResizable(false);

        //sets the default location of the frame to the screen center and shows it
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        //calls the methods to start the game
        gamePanel.setupGame();
        gamePanel.startGameThread();

    }

}