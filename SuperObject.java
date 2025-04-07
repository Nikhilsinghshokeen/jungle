//Samarth Chetan
//June 16, 2023
//This is the parent class for all the objects used

package jungle;

import java.awt.image.BufferedImage;
import java.awt.*;

public class SuperObject{

    protected BufferedImage image, image1, image2; //image variables that will have a png loaded to it
    protected String name;  //object's name
    protected boolean collision = false;  //defaults collision to off
    protected int worldX, worldY;
    protected Rectangle solidArea = new Rectangle(0, 0, 48, 48);   //objects hitbox
    protected int solidAreaDefaultX = 0;
    protected int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp){

        //x and y coords for only the screen
        int screenX = worldX - gp.character.worldX + gp.character.screenX;
        int screenY = worldY - gp.character.worldY + gp.character.screenY;


        //if the object is currently displayed on the screen (instead of being somewhere off-screen):
        if(worldX + gp.tileSize > gp.character.worldX - gp.character.screenX 
            && worldX - gp.tileSize < gp.character.worldX + gp.character.screenX
            && worldY + gp.tileSize > gp.character.worldY - gp.character.screenY 
            && worldY - gp.tileSize < gp.character.worldY + gp.character.screenY){

            //it will draw the block object on the screen
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
        }

    }


}