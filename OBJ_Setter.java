//Samarth Chetan
//June 16, 2023
//This class creates and attaches the image for the all of the interactive objects

package jungle;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class OBJ_Setter{


}

class OBJ_Apple extends SuperObject{

    public OBJ_Apple(){
        name = "Apple";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("apple.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Banana extends SuperObject{

    public OBJ_Banana(){
        name = "Banana";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("Banana.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_BlueButton extends SuperObject{

    public OBJ_BlueButton(){
        name = "Blue Button";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("blueButton1.png"));
            image2 = ImageIO.read(new File("blueButton2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_BlueButtonSelect extends SuperObject{

    public OBJ_BlueButtonSelect(){
        name = "Blue Button Select";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("blueButton2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_BowNArrow extends SuperObject{

    public OBJ_BowNArrow(){
        name = "Bow and Arrow";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("bowNarrow.png"));
        } catch(IOException e){
            e.printStackTrace();
        }        
    }


}


class OBJ_Brick extends SuperObject{

    public OBJ_Brick(){
        name = "Brick";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("brick.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Bush extends SuperObject{

    public OBJ_Bush(){
        name = "Bush";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("bush.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }


}

class OBJ_Coin extends SuperObject{

    public OBJ_Coin(){
        name = "Coin";

        try{
            image = ImageIO.read(new File("coin.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Door extends SuperObject{

    public OBJ_Door(){
        name = "Door";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("Door.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Door2 extends SuperObject{

    public OBJ_Door2(){
        name = "Door2";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("Door.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Door3 extends SuperObject{

    public OBJ_Door3(){
        name = "Door 3";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("Door.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Door4 extends SuperObject{

    public OBJ_Door4(){
        name = "Door 4";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("Door.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Door5 extends SuperObject{

    public OBJ_Door5(){
        name = "Door5";

        
        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("Door.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_End extends SuperObject{

    public OBJ_End(){
        name = "End";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("end.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Grass extends SuperObject{

    public OBJ_Grass(){
        name = "Grass";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("grass.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_GreenButton extends SuperObject{

    public OBJ_GreenButton(){
        name = "Green Button";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("greenButton1.png"));
            image2 = ImageIO.read(new File("greenButton2.png"));

        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_GreenButtonSelect extends SuperObject{

    public OBJ_GreenButtonSelect(){
        name = "Green Button Select";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("greenButton2.png"));

        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Health extends SuperObject{

    public OBJ_Health(){
        name = "Health";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("health.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Info extends SuperObject{

    public OBJ_Info(){
        name = "Info";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("info.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Key extends SuperObject{

    public OBJ_Key(){
        name = "Key";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("key.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }


}

class OBJ_Paper extends SuperObject{

    public OBJ_Paper(){
        name = "Paper";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("page.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Pause extends SuperObject{

    public OBJ_Pause(){
        name = "Pause";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("pause.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Portal extends SuperObject{

    public OBJ_Portal(){
        name = "Portal";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("portal.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_RedButton extends SuperObject{

    public OBJ_RedButton(){
        name = "Red Button";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("redButton1.png"));
            image2 = ImageIO.read(new File("redButton2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_RedButtonSelect extends SuperObject{

    public OBJ_RedButtonSelect(){
        name = "Red Button Select";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("redButton2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_StumpLeft extends SuperObject{

    public OBJ_StumpLeft(){
        name = "Left Stump";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("brokenStumpLeft.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_StumpRight extends SuperObject{

    public OBJ_StumpRight(){
        name = "Right Stump";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("brokenStumpRight.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Tiger extends SuperObject{

    public OBJ_Tiger(){
        name = "Tiger";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("tiger.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }


}

class OBJ_Trap extends SuperObject{

    public OBJ_Trap(){
        name = "Trap";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("trap.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }


}

class OBJ_Water extends SuperObject{

    public OBJ_Water(){
        name = "Water";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("water.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_Wood extends SuperObject{

    public OBJ_Wood(){
        name = "Wood";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("wood.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}

class OBJ_WoodBranch extends SuperObject{

    public OBJ_WoodBranch(){
        name = "Wood Branch";

        //sets the object image to the png file
        try{
            image = ImageIO.read(new File("treeWood.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
        
    }


}
