//Samarth Chetan
//June 16, 2023
//This is the parent class for the character, and it initializes the character attributes

package jungle;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;


public class Entity{

    //'protected' variables allow better encapsulation to avoid all public variables
    //    it only allows the parent class and its subclasses to access it
    
    protected int worldX, worldY;   //x and y value for the whole map

    //player current health and points
    protected int health = 100;

    protected int points = 0;

    protected int tigerHealth = 50;  //tiger enemy health for lvl 2
    protected boolean hasBow = false;  //checks is player picked up bow and arrow in lvl 1
    
    //player attributes
    protected String name;
    protected int speed;
    

    //variables for each of the sprites movement  (a png file is loaded to each one in character class)
    protected BufferedImage up1, up2, down1, down2, right1, right2, left1, left2, apple;
    protected BufferedImage up, down, left, right;
    protected String direction;  //player's current direction

    GamePanel gp;

    //frame counter used for switching between sprites
    protected int spriteCounter = 0;
    protected int spriteNum = 1;

    //variables for player hitbox
    protected Rectangle solidArea;
    protected int solidAreaDefaultX, solidAreaDefaultY;
    protected boolean collisionOn = false;


    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void update(){

        collisionOn = false;
        gp.cChecker.checkTile(this);   //changes collisionOn to true if player is touching a solid object

        //if collision is false, player can move
        if(collisionOn == false){
            switch(direction){
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
                case "space":
                    
            }
    
            
            spriteCounter++;
            //switches sprite every 12 frames
            if(spriteCounter>12){ 
                if(spriteNum == 1){
                    spriteNum = 2;
                }
    
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;  //resets sprite frame counter
            }
        }

    }

    
}