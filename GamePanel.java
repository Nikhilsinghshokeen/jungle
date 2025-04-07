//Samarth Chetan
//June 16, 2023
//This class runs the game through the gamepanel by constantly repainting the screen to update it after each frame

package jungle;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable{


    //screen settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //world settings
    public final int maxWorldCol = 80;
    public final int maxWorldRow = 80;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    int FPS = 60;

    //gets other necessary classes
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    public Collisions cChecker = new Collisions(this);
    public InteractiveObjPlacer iPlacer = new InteractiveObjPlacer(this);
    public UI ui = new UI(this);
    Thread gameThread;
    public Character character = new Character(this, keyH);
    public SuperObject obj[] = new SuperObject[200];
    public Pet p = new Pet();

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 10;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));  //sets the panel size to the screen's width and height
        this.setBackground(new Color(28 ,115, 68));  //makes background color green
        this.setDoubleBuffered(true);  //draws the graphics off-screen then copies it to the board when needed
        this.addKeyListener(keyH);  //takes in key inputs
        this.setFocusable(true);

    }

    //sets up the game calling the method to place all interactive blocks
    public void setupGame(){
        iPlacer.setObject();
    }    

    public void startGameThread(){
        gameThread = new Thread(this);
        character.setDefaultValues();
        gameThread.start();
    }

    public void run(){
        double drawInterval = 1000000000/FPS;     //draws the new screen in intervals of this
        double delta = 0;  
        //timer variables
        long lastTime = System.nanoTime();   
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        
        while(gameThread != null){  //only when the game is still running

            currentTime = System.nanoTime();  //sets the current time to the timer 

            delta += (currentTime - lastTime) / drawInterval;  //delta changes when new frame is drawn
            timer += (currentTime - lastTime);   //increases the timer
            lastTime = currentTime; //updates the last time

            //when it is time to update a frame, it updates the info and repaints it
            if (delta >= 1){ 
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                drawCount = 0;
                timer = 0;
            }

        }

    }



    public void update(){

       character.update();  //gets update method from character class

    }

    //paints the updated screen
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        //paints tiles
        tileM.draw(g2);

        //paints objects
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){   //makes sure the slot isn't empty first
                obj[i].draw(g2, this);
            }
        }

        //paints the character
        character.draw(g2);

        //paints user interface
        ui.draw(g2);

        g2.dispose();
    }
}