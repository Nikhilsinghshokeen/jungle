//Nikhil Shokeen
//4/4/2025
//This class displays the parts of the user interface, which the player can see on the screen

package jungle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI{

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;   //two fonts used
    BufferedImage keyImage, bushImage, trapImage;  //stores the image for when it needs to be displayed in the ui
    public int displayTime = 150;  //how long pop-up messages are shown
    public String message = "";

    //counts frames for different points
    int messageCounter = 0;
    int timeCounter = 0;
    int healthCounter = 0;
    int tigerCounter = 0;
    int mineCounter = 0;
    int monkCounter = 0;
    int startCounter = 0;

    //flag variables for levels
    public boolean gameFinished = false;
    boolean paused = false;
    boolean inMaze = false;
    boolean withTiger = false;
    boolean inMine = false;
    public boolean messageOn = false;
    boolean withMonkey = false;   
    
    //3 lines for displaying text
    public String dialogue1 = "";
    public String dialogue2 = "";
    public String dialogue3 = "";
        
    double playTime;  //amount of time used
    DecimalFormat dFormat = new DecimalFormat("#0.00");  //formats the seconds to up to 2 decimals

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);   //matches the font variables with the actual font
        arial_80B = new Font("Arial", Font.BOLD, 80);

        
    }

    //shows the screen message
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }


    //assigned variables for each line of the question
    //five choices for questions

    String q1o1 = "        Most jungles can be found in";
    String q1o2 = "            which kind of climate?";
    String q1o3 = "A. Temperate B. Tropical C. Continental";
    String q1Ans = "B";

    String q2o1 = "  The word “jungle” is derived from the";
    String q2o2 = "   word 'jangala'. What does it mean?";
    String q2o3 = "A. Wet land B. Diverse land C. Dry land";
    String q2Ans = "C";

    String q3o1 = "    The Amazon rainforest is located";
    String q3o2 = "              in which continent?";
    String q3o3 = "   A. South America B. Africa C. Asia";
    String q3Ans = "A";

    String q4o1 = "        Most tigers live in the jungles";
    String q4o2 = "          in which part of the world?";
    String q4o3 = "    A. North America B. Africa C. Asia";
    String q4Ans = "C";

    String q5o1 = "    The Amazon rainforest spans how";
    String q5o2 = "      many countries and territories?";
    String q5o3 = "                A. 5   B. 9   C. 15";
    String q5Ans = "B";


    //gets a random index to match to a random question
    public int showRandQuestion(){
        

        //random number 1 to 5
        int randQ = (int) (Math.random() * 5) + 1;

        return randQ;

    }

   

    //draws the new updated screen to repaint it
    public void draw(Graphics2D g2){

        this.g2 = g2;

        //if the game is over 
        if(gameFinished == true){

            g2.setFont(arial_40);
            g2.setColor(Color.white);

            //if the player is dead (no health left)
            if(gp.character.health <= 0){

                gp.character.info = true;  //turns message display screen on

                String text = "You Lost!";
                int textLength, x, y;

                //finds the length of the text so it can be centered correctly
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(); 
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 - (gp.tileSize*3);
                g2.drawString(text, x, y);

                //displays time taken
                text = "You took " + dFormat.format(playTime) + " seconds";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(); 
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 + (gp.tileSize*4);
                g2.drawString(text, x, y);

                //says play again
                g2.setFont(arial_80B);
                g2.setColor(Color.blue);
                text = "Play Again";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(); 
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 + (gp.tileSize*2);
                g2.drawString(text, x, y);
                    
            }

            else{

                gp.character.info = true;  //displays message screen

                String text = "YOU ESCAPED!";
                int textLength, x, y;

                //finds the length of the text so it can be centered correctly
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(); 
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 - (gp.tileSize*3);
                g2.drawString(text, x, y);

                //shows time taken
                text = "You took " + dFormat.format(playTime) + " seconds";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(); 
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 + (gp.tileSize*4);
                g2.drawString(text, x, y);

                //how many points you scored
                g2.setFont(arial_40);
                g2.setColor(Color.white);
                text = "YOU SCORED: " + gp.character.points + " POINTS";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(); 
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 + (gp.tileSize*2);
                g2.drawString(text, x, y);
            }

            gp.gameThread = null;    //ends the game thread, stops the game

        }

        else{

            //for points
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawString("Points: " + gp.character.points, 30, 65); //shows the health

            //for health:
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            if(inMaze){ //once the player starts the maze
                    healthCounter++;  //counts frames 
                    if(healthCounter > 180 && paused == false){ //after 5 seconds (and if it isn't paused)
                        gp.character.health -= 3; //decrements health
                        healthCounter = 0; //resets frames
                    }
            }
            if(withTiger){ //once the player starts the tiger challenge
                tigerCounter++;  //counts frames 
                if(tigerCounter > 180){ //after 3 seconds
                    gp.character.health -= 2; //decrements health
                    tigerCounter = 0; //resets frames
                }
            }
            if(withMonkey){ //once the player starts the monkey challenge
                monkCounter++;  //counts frames 
                if(monkCounter > 180){ //after 3 seconds
                    gp.character.health -= 2; //decrements health
                    monkCounter = 0; //resets frames
                }
            }
            if(inMine){ //once the player starts the mining challenge
                mineCounter++;  //counts frames 
                if(mineCounter > 180){ //after 3 seconds
                    gp.character.health -= 2; //decrements health
                    mineCounter = 0; //resets frames
                }
            }
            g2.drawString("Health: " + gp.character.health, 30, 115); //shows the health

            //for time: 
            if(paused){          //for the pause feature in the maze
                timeCounter++;       //counts frames that it is paused for
                if(timeCounter > 600){     //once it hits 600 frames (10 seconds)
                    paused = false;       //unpauses
                }

            }
            else{
                playTime += (double)1/60;     //when unpaused, it increases the time every frame
                timeCounter = 0;
            }
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 65); //shows timer on screen

            //for messages:
            if(messageOn == true){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize * 5);

                messageCounter++;      //increases every frame while message is displayed

                
                if(messageCounter > displayTime){       //displays for less than 2 seconds (80 frames)
                    messageCounter = 0;
                    messageOn = false;          //shuts it off
                }
            }

        }


        if(gp.character.info == true){
            drawDialogueScreen();   //paints the message display screen
        }

        //starting message whe game is first started
        if(startCounter < 300){   //message for first 300 frames (5 seconds)
            gp.character.info = true;
            gp.ui.dialogue1 = "    Welcome to Jungle Jam! You find ";
            gp.ui.dialogue2 = "   yourself stuck in the jungle, so finish";
            gp.ui.dialogue3 = "     the next seven levels to escape.";
            startCounter++;
        }
        else if(startCounter >= 300 && startCounter < 600){  //next 5 seconds new message
            gp.character.info = true;
            gp.ui.dialogue1 = "    Move with the W A S D keys or the";
            gp.ui.dialogue2 = "   arrow keys. Touch the question box ";
            gp.ui.dialogue3 = "       to learn how to play each level. ";
            startCounter++;
        }
        else if(startCounter >= 600 && startCounter < 900){  //5 seconds after that
            gp.character.info = true;
            gp.ui.dialogue1 = "   Score as many points as you can in ";
            gp.ui.dialogue2 = " the least amount of time without losing ";
            gp.ui.dialogue3 = "        all your health. Good Luck!";
            startCounter++;
        }

        else{
            startCounter = 901;  //sets counter to unreachable amount to not show the message again
            gp.character.info = false; //turns display screen off
            gp.ui.dialogue1 = "";
            gp.ui.dialogue2 = "";
            gp.ui.dialogue3 = "";
        }        

        
    }

    //draws the black message display screen background
    public void drawDialogueScreen(){
            //window:
            int x = gp.tileSize*2;
            int y = gp.tileSize/2;
            int width = gp.screenWidth - (gp.tileSize*4);
            int height = gp.tileSize*4;

            //if the game is over, the screen becomes bigger to fit all text
            if(gameFinished){
                width = gp.screenWidth - 2*gp.tileSize;
                height = gp.tileSize*11;
                x -= 50;
            }
            
            //calls method to draw the inside window
            drawSubWindow(x, y, width, height);

            x += gp.tileSize;
            y += gp.tileSize;

            //writes the 3 dialogue lines in three lines, one above the other
            g2.drawString((dialogue1), x - 25, y);
            g2.drawString((dialogue2), x - 25, y + gp.tileSize);
            g2.drawString((dialogue3), x - 25, y + 2*gp.tileSize);
    }

    //draws the inside of the message display
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 215); //sets the opacity to a little transparent 
        if(gameFinished){
            c = new Color(0, 0, 0, 50);  //if the game is over it makes it more transparent
        }
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        //draws a white border
        c = new Color(255, 255, 255);   //sets outter edge to white
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));  //makes the edge a width of 5
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        showMessage("");

        
    }
    


}