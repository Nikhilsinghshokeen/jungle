//Nikhil Shokeen
//4/4/2025
//This class creates and attaches the image for the pet object

package jungle;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Pet extends SuperObject{


    public Pet(){
        name = "Pet";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("monkey.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }
    
}


