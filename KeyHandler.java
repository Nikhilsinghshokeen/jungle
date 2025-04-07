//Samarth Chetan
//June 16, 2023
//This class takes in the user's keyboard inputs to control the game

package jungle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    //variables for when a key is pressed
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    public void keyTyped(KeyEvent e){

    }

    //checks when a key is pressed down  (W A S D keys or Arrow keys)
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();   //gets the action event when a certain key is pressed

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = true;
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = true;
        }

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }

        
    }

    //checks when the key is released
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();  //gets the action event when the key is released

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }

    }


}