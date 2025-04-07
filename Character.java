//Nikhil Shokeen
//4/4/2025
//This class handles all the character-related attributes and functions

package jungle;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import jungle.TileManager;
import jungle.GamePanel;
import jungle.KeyHandler;



public class Character extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;

    //initializes variables for later levels
    private int brickNum = 0;
    private int woodNum = 0;
    private int appleNum = 0;
    public int screenX;  //x coord for the screen
    public int screenY;  //y coord for the screen
    public int hasKey = 0; // how many keys the player has
    SuperObject sO = new SuperObject();

    //flag variable to check if a level is done
    private boolean tigerDefeat = false;
    private boolean houseMade = false;
    public boolean quesChecked = false;

    //character constuctor with GamePanel and KeyHandler argument
    public Character(GamePanel gp, KeyHandler keyH) {

        super(gp);  

        this.gp = gp;
        this.keyH = keyH;

        //gets coordinates for the center of the screen
        screenX = gp.screenWidth / 2 - gp.tileSize / 2;
        screenY = gp.screenHeight / 2 - gp.tileSize / 2;

        // sets the hitbox on the player
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 20;
        solidArea.height = 20;

        setDefaultValues();
        getPlayerImage();
    }

    //loads all character image files to a variable
    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(new File("playerUp1.png"));
            up2 = ImageIO.read(new File("playerUp2.png"));
            down1 = ImageIO.read(new File("playerDown1.png"));
            down2 = ImageIO.read(new File("playerDown2.png"));
            left1 = ImageIO.read(new File("playerLeft1.png"));
            left2 = ImageIO.read(new File("playerLeft2.png"));
            right1 = ImageIO.read(new File("playerRight1.png"));
            right2 = ImageIO.read(new File("playerRight2.png"));
            apple = ImageIO.read(new File("apple.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //character's default values when the game is run
    public void setDefaultValues() {

        worldX = 250;
        worldY = 280;
        speed = 4;
        health = 100;
        lvl = 1;
        direction = "down";

    }

    //updates the screen information
    public void update() {

        // switches between animations when sprite is moving
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
                || keyH.rightPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
            }

            else if (keyH.downPressed == true) {
                direction = "down";
            }

            else if (keyH.rightPressed == true) {
                direction = "right";
            }

            else if (keyH.leftPressed == true) {
                direction = "left";
            }

            // checks tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // checks object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            movePet(114);

            //checks to see if player is still alive
            if(health <= 0){
                info = true; //turns on the display text screen
                if(info == true){
                    gp.ui.gameFinished = true;
                }
            }

            // if no collision needed
            if (collisionOn == false) {

                //moves the player sprite's coordinates based on player speed
                switch (direction) {
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
                }
            }

            //counts every frame
            spriteCounter++;

            // switches between frame one and two for animation
            if (spriteCounter > 10) { // changes sprite every 10 frames
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0; // resets counter
            }

        }

    }

    //moves the pet back and forth between two points
    public void movePet(int i){

        if(gp.gameThread != null){  //makes sure game is running first
            if(gp.obj[114] != null){ //makes sure the pet exists first
                
                if(numMonkHits == 1){
                    gp.obj[i].worldY += 5;
                    if(gp.obj[i].worldY >= 1500){                   //sets upper and lower bounds
                        while(gp.obj[i].worldY >= 1100){
                            gp.obj[i].worldY -= 5;
                        }
                    }
                }
                else{
                    gp.obj[i].worldX += 5;
                    if(gp.obj[i].worldX >= 2000){                    //sets left and right bounds
                        while(gp.obj[i].worldX >= 1100){
                            gp.obj[i].worldX -= 5;
                        }
                    }
                }

            }

        }
        
    }

    //initializes variables for later levels
    private String ans;
    private int randMonkX = (int) (Math.random() * 500) + 1048;      //random monkey coordinates
    private int randMonkY = (int) (Math.random() * 500) + 848;
    private int randMonkX2 = (int) (Math.random() * 500) + 1048;
    private int randMonkY2 = (int) (Math.random() * 500) + 848;
    private int numMonkHits = 0;
    private boolean doneTree;
    private boolean falling = false;
    private int touches = 0;
    private int lvl;
    boolean info = false;
    private ArrayList<String> quesArray = new ArrayList<String>();
    private int a = 0;


    //what to do when the player interacts with an object
    public void pickUpObject(int i) {
        if (i != 999) { // i was initialized to 999, so checks to see only if it changed
            String objectName = gp.obj[i].name; //gets the name of the object

            switch (objectName) { //when character collides with an object with the name it is looking for
                case "Key":
                    hasKey++;
                    gp.obj[i] = null; // 'takes out' the object from the array by setting it to null
                    gp.ui.showMessage("You picked up a key!");
                    break;
                case "Door":
                    if (hasBow) {    //if the bow and arrow is picked up first
                        gp.obj[i] = null;
                        gp.ui.showMessage("You opened the door!");
                        points += 30;
                        gp.ui.withTiger = true;  //signals moved on to next level
                        lvl = 2; //signals moved on to next level
                    } else { //if they haven't completed the current level yet
                        gp.ui.showMessage("You need a bow and arrow to open it first");
                    }

                    break;
                    
                case "Bush":
                    gp.obj[i] = null;
                    gp.ui.showMessage("You checked the bush!");
                    break;
                case "Trap":
                    health -= 10;
                    points -= 5;
                    try {   //pauses the game screen for short bursts to show player is caught in the trap
                        Thread.sleep(500);  // 'sleeps' the game thread for 500 frames
                        keyH.upPressed = false;
                        keyH.downPressed = false;
                        keyH.leftPressed = false;
                        keyH.rightPressed = false;

                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got caught in a trap!");
                    break;
                case "Bow and Arrow":
                    hasBow = true;  //confirms bow and arrow picked up
                    try {
                        Thread.sleep(500);  //pauses screen to show it is picked up
                        keyH.upPressed = false;
                        keyH.downPressed = false;
                        keyH.leftPressed = false;
                        keyH.rightPressed = false;

                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    gp.obj[i] = null;
                    gp.ui.showMessage("You picked up the bow and arrow!");
                    break;
                case "Tiger":
                    tigerHealth -= 10;    //tiger faces 10 damage every time it gets hit
                    if (tigerHealth == 0) {  //if the tiger is fully dead
                        gp.obj[i] = null;
                        gp.ui.showMessage("You defeated the tiger!");
                        tigerDefeat = true;
                        gp.ui.withTiger = false;
                    } else { //if the tiger still has some health left
                        gp.ui.showMessage("The tiger's health is down to " + tigerHealth);
                        int tigerRandX = (int) (Math.random() * 20) + 21;
                        int tigerRandY = (int) (Math.random() * 11) + 5;
                        gp.obj[17].worldX = tigerRandX * gp.tileSize;
                        gp.obj[17].worldY = tigerRandY * gp.tileSize;
                    }
                    break;
                case "Door2":
                    if (tigerDefeat) {  //if done with the tiger level
                        gp.obj[i] = null;
                        points += 50;
                        lvl = 3; //signals moved on to next level
                    } else { //if not yet finished current level
                        gp.ui.showMessage("You must defeat the tiger first to move on");
                    }
                    break;
                case "Paper":
                        chooseQuestion();  //calls method to choose a random question
                        quesChecked = true;   
                        //adds the three lines of the question and its answer into an empty array
                        quesArray.add(gp.ui.dialogue1);
                        quesArray.add(gp.ui.dialogue2);
                        quesArray.add(gp.ui.dialogue3);
                        quesArray.add(ans);
                        touches++;
                        if(touches >= 1){ //if touching the paper
                            info = true;  //displays the text screen
                            //sets the 3 screen dialogues to the previous lines of the question from the array
                            gp.ui.dialogue1 = quesArray.get(0);
                            gp.ui.dialogue2 = quesArray.get(1);
                            gp.ui.dialogue3 = quesArray.get(2);
                        }
                    
                    break;
                case "Blue Button":
                    if(quesChecked){  //only if the user reads question first
                    
                        gp.obj[i] = null;
                        gp.ui.showMessage("You selected the blue choice");

                        //blue button is only for choice 'C'
                        if(quesArray.get(3).equals("C")){  //if the answer is correct
                            gp.obj[34] = new OBJ_Key();   //pops up a key
                            gp.ui.showMessage("You got it right!");
                            gp.obj[34].worldX = 49 * gp.tileSize;
                            gp.obj[34].worldY = 9 * gp.tileSize;
                            points += 10;
                        }
                        else{ //if user's answer is wrong they lose points
                            gp.ui.showMessage("Thats the wrong answer");
                            points -= 20;
                        }
                    }
                    else{
                        gp.ui.showMessage("Read the question first");
                    }
                    break;
                case "Red Button":
                    if(quesChecked){ //user must read question before answering
                        
                        gp.obj[i] = null;
                        gp.ui.showMessage("You selected the red choice");

                        //red is for only choice 'A'
                        if(quesArray.get(3).equals("A")){   //if user answer is correct
                            gp.obj[34] = new OBJ_Key(); //pops up key
                            gp.ui.showMessage("You got it right!");
                            gp.obj[34].worldX = 45 * gp.tileSize;
                            gp.obj[34].worldY = 9 * gp.tileSize;
                            points += 10;
                        }
                        else{ //if user's answer is wrong they lose points
                            gp.ui.showMessage("Thats the wrong answer");
                            points -= 20;
                        }
                    }
                    else{
                        gp.ui.showMessage("Read the question first");
                    }
                    break;
                case "Green Button":
                    if(quesChecked){ //user must read question before answering
                        
                        gp.obj[i] = null;
                        gp.ui.showMessage("You selected the blue choice");

                        //green is only for choice 'B'
                        if(quesArray.get(3).equals("B")){ //if user gets answer correct
                            gp.obj[34] = new OBJ_Key(); //pops up key
                            gp.ui.showMessage("You got it right!");
                            gp.obj[34].worldX = 47 * gp.tileSize;
                            gp.obj[34].worldY = 9 * gp.tileSize;
                            points += 10;
                        }
                        else{ //if user's answer is wrong they lose points
                            gp.ui.showMessage("Thats the wrong answer");
                            points -= 20;
                        }
                    }
                    else{
                        gp.ui.showMessage("Read the question first");
                    }
                    break;
                case "Door 3":
                    if(hasKey > 0){ //only if the user picked up the key from getting the answer right
                        hasKey--;  //brings num of keys back to 0
                        gp.obj[i] = null;
                        gp.ui.showMessage("Nice job, you passed level 3");  
                        gp.ui.inMine = true; //signals the start of the next level
                        lvl = 4;
                    }
                    else{ //if they haven't gotten the right answer yet
                        gp.ui.showMessage("Answer correctly and get a key to move on");  
                    }
                    break;              
                case "Brick":
                    if(houseMade == false){  //before the house is created
                        brickNum++;
                        gp.obj[i] = null;
                        gp.ui.showMessage("# of Bricks: " + brickNum);  //displays current number of brick
                        if(brickNum >= 8 && woodNum >= 8){ //if player has enough material for the house
                            buildHouse(); //builds the house
                            houseMade = true; 
                            gp.ui.showMessage("You made the house!"); 
                        }
                    }
                    break;
                case "Wood":
                    if(houseMade == false){ //before the house is created
                        woodNum++;
                        gp.obj[i] = null;
                        gp.ui.showMessage("# of Wood: " + woodNum); //displays the current number of wood
                        if(brickNum >= 8 && woodNum >= 8){ //if player has enough material for the house
                            buildHouse(); //builds the house
                            houseMade = true;
                            gp.ui.showMessage("You made the house!"); 
                        }
                    }
                    break;     
                case "Portal":
                    //if player reaches the portal, it will teleport them to the next level
                    worldX = 350;
                    worldY = 1000;
                    gp.ui.displayTime = 200;  //changes time message is displayed to less
                    gp.ui.showMessage("Level Completed!"); 
                    points += 25;
                    gp.ui.inMine = false; //shows last level is finished
                    lvl = 5; //signals next level
                    break;
                case "Wood Branch": //when player hits a broken branch
                    gp.obj[i] = null;
                    health -= 15;
                    points -= 10;
                                        
                    //creates new blocks to replace the branch with a broken one
                    gp.obj[77] = new OBJ_Grass();
                    gp.obj[77].worldX = 9 * gp.tileSize;
                    gp.obj[77].worldY = 26 * gp.tileSize;

                    gp.obj[78] = new OBJ_Grass();
                    gp.obj[78].worldX = 10 * gp.tileSize;
                    gp.obj[78].worldY = 27 * gp.tileSize;
                    
                    gp.obj[79] = new OBJ_StumpLeft();
                    gp.obj[79].worldX = 10 * gp.tileSize;
                    gp.obj[79].worldY = 26 * gp.tileSize;

                    gp.obj[81] = new OBJ_Grass();
                    gp.obj[81].worldX = 16 * gp.tileSize;
                    gp.obj[81].worldY = 23 * gp.tileSize;

                    //makes player fall to the ground
                    falling = true;  

                    if(falling){        //when player is falling down from tree branch
                        worldY = 1425;        //brings y value down
                        falling = false;
                    }

                    gp.ui.showMessage("You fell!");

                    break;
                case "Banana":
                    gp.obj[i] = null;
                    break;
                case "Apple":
                    
                    gp.obj[i] = null;
                    appleNum++;
                    gp.ui.showMessage("Apples: " + appleNum); //shows number of apples
                    points += 5;
                    health += 20;  //increases health per apple
                    
                    break;
                case "Pet":

                    if(doneTree){  //if tree level is over

                        if(numMonkHits >= 2){  //if monkey is hit three times
                            numMonkHits++;
                            gp.obj[i] = null; //monkey is tamed
                            gp.ui.showMessage("You tamed the monkey!");
                            doneTree = false; //signals level is over
                            points += 25;
                        }
                        
                        else if(numMonkHits == 1){ //if hit twice
                            //sets monkey to a random index
                            gp.obj[114].worldX = randMonkX2;   
                            gp.obj[114].worldY = randMonkY2;
                            gp.ui.showMessage("You hit 2!");
                            numMonkHits++;
                        }

                        else { //if hit once
                            //sets monkey to a random index
                            gp.obj[114].worldX = randMonkX;
                            gp.obj[114].worldY = randMonkY;
                            gp.ui.showMessage("You hit 1!");
                            numMonkHits++;
                        }
                    }
                                        
                    break;
                case "Door 4":
                    if(appleNum == 2){  //finished level if gotten enough apples
                        gp.obj[i] = null;
                        doneTree = true;
                        gp.ui.withMonkey = true;
                        lvl = 6;  //signals a new level
                    }            
                    else{
                        gp.ui.showMessage("You don't have enough fruit yet");    
                    } 
                    break;        
                case "Coin":
                    if(gp.ui.inMine){
                        try {
                            Thread.sleep(500);  //pauses screen to show it is picked up
                            keyH.upPressed = false;
                            keyH.downPressed = false;
                            keyH.leftPressed = false;
                            keyH.rightPressed = false;
    
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    gp.obj[i] = null;
                    points += 10;  //increases points every time a coin is collected
                    gp.ui.showMessage("+10 Points"); 
                    break;
                case "Health":
                    gp.obj[i] = null;
                    gp.ui.showMessage("+10 Health");
                    health += 10;  //increases health for health powerups
                    break; 
                case "Pause":
                    gp.ui.paused = true;  //pauses the timer and health decrement for 10 seconds
                    gp.obj[i] = null;
                    gp.ui.showMessage("Paused for 10 seconds");
                    break;
                case "Info":
                    //displays the info / directions for each level

                    //each dialogue is a new line for the text
                    if(lvl == 1){
                        info = true;
                        gp.ui.dialogue1 = "  You are stuck in bushy lands. Search";
                        gp.ui.dialogue2 = "the bushes to find a hidden bow & arrow";
                        gp.ui.dialogue3 = " and move on. Be careful of bear traps!";
                    }
                    else if(lvl == 2){
                        info = true;
                        gp.ui.dialogue1 = " Uh oh. You are trapped in with a tiger.";
                        gp.ui.dialogue2 = "Attack by approaching it 5 times to beat";
                        gp.ui.dialogue3 = "  it. Move quickly, you're losing health!";
                    }
                    else if(lvl == 3){
                        info = true;
                        gp.ui.dialogue1 = "  Ready for some jungle trivia? Answer";
                        gp.ui.dialogue2 = "the question by hitting the correct color";
                        gp.ui.dialogue3 = "  button. *Wrong answers lose points*"; 
                    }
                    else if(lvl == 4){
                        info = true;
                        gp.ui.dialogue1 = "    Mine 8 wood and 8 brick to build a";
                        gp.ui.dialogue2 = "shelter. Enter the house once you make ";
                        gp.ui.dialogue3 = "  it. Move quickly, you're losing health!";
                    }
                    else if(lvl == 5){
                        info = true;
                        gp.ui.dialogue1 = " It's time to eat! Climb the tree from the";
                        gp.ui.dialogue2 = " bottom and collect enough fruit for you.";
                        gp.ui.dialogue3 = "Be careful.. some branches might break.";
                    }
                    else if(lvl == 6){
                        info = true;
                        gp.ui.dialogue1 = "  You find a monkey and want him as a";
                        gp.ui.dialogue2 = "pet. Feed it the apple 3 times to tame it.";
                        gp.ui.dialogue3 = "    Move quickly, you're losing health!";
                    }
                    else if(lvl == 7){
                        gp.ui.withMonkey = false;
                        info = true;
                        gp.ui.dialogue1 = "Complete this maze without running out";
                        gp.ui.dialogue2 = "  of health to escape the whole jungle. ";
                        gp.ui.dialogue3 = "Use power-ups to aid you along the way.";
                        gp.obj[144] = null;
                    }
                    
                    break;
                case "Door5":
                    if(numMonkHits >= 3){   //if completed the monkey level
                        gp.obj[i] = null;
                        gp.ui.withMonkey = false;
                        lvl = 7; //signals new level
                        gp.ui.inMaze = true;
                    }            
                    else{
                        gp.ui.showMessage("You haven't tamed the monkey yet");    
                    } 
                    break; 
                case "End":
                    gp.obj[i] = null;
                    gp.ui.gameFinished = true;  //finishes the game
                    break;
                case "Grass":
                    if(gp.ui.inMaze){
                        gp.ui.showMessage("Read the level info first");
                    }
                    break;
                
                

            }
        }
    }

   

    //chooses a random index for the question and assigns the corresponding question to that random number
    public void chooseQuestion(){
        int ques = gp.ui.showRandQuestion(); //gets random index
        if(ques == 1){
            gp.ui.dialogue1 = gp.ui.q1o1;
            gp.ui.dialogue2 = gp.ui.q1o2;
            gp.ui.dialogue3 = gp.ui.q1o3;
            ans = gp.ui.q1Ans;
        }
        else if(ques == 2){
            gp.ui.dialogue1 = gp.ui.q2o1;
            gp.ui.dialogue2 = gp.ui.q2o2;
            gp.ui.dialogue3 = gp.ui.q2o3;
            ans = gp.ui.q2Ans;
        }
        else if(ques == 3){
            gp.ui.dialogue1 = gp.ui.q3o1;
            gp.ui.dialogue2 = gp.ui.q3o2;
            gp.ui.dialogue3 = gp.ui.q3o3;
            ans = gp.ui.q3Ans;
        }
        else if(ques == 4){
            gp.ui.dialogue1 = gp.ui.q4o1;
            gp.ui.dialogue2 = gp.ui.q4o2;
            gp.ui.dialogue3 = gp.ui.q4o3;
            ans = gp.ui.q4Ans;
        }
        else if(ques == 5){
            gp.ui.dialogue1 = gp.ui.q5o1;
            gp.ui.dialogue2 = gp.ui.q5o2;
            gp.ui.dialogue3 = gp.ui.q5o3;
            ans = gp.ui.q5Ans;
        }
    }

    //builds the house with wood and brick blocks for the mining level
    //places the blocks into the assigned spots when called
    public void buildHouse(){
        gp.obj[100] = new OBJ_Brick();
        gp.obj[100].worldX = 71 * gp.tileSize;
        gp.obj[100].worldY = 10 * gp.tileSize;
        gp.obj[101] = new OBJ_Brick();
        gp.obj[101].worldX = 71 * gp.tileSize;
        gp.obj[101].worldY = 11 * gp.tileSize;
        gp.obj[102] = new OBJ_Brick();
        gp.obj[102].worldX = 71 * gp.tileSize;
        gp.obj[102].worldY = 12 * gp.tileSize;
        gp.obj[103] = new OBJ_Brick();
        gp.obj[103].worldX = 73 * gp.tileSize;
        gp.obj[103].worldY = 10 * gp.tileSize;
        gp.obj[104] = new OBJ_Brick();
        gp.obj[104].worldX = 73 * gp.tileSize;
        gp.obj[104].worldY = 11 * gp.tileSize;
        gp.obj[105] = new OBJ_Brick();
        gp.obj[105].worldX = 73 * gp.tileSize;
        gp.obj[105].worldY = 12 * gp.tileSize;
        gp.obj[106] = new OBJ_Wood();
        gp.obj[106].worldX = 74 * gp.tileSize;
        gp.obj[106].worldY = 10 * gp.tileSize;
        gp.obj[107] = new OBJ_Wood();
        gp.obj[107].worldX = 73 * gp.tileSize;
        gp.obj[107].worldY = 9 * gp.tileSize;
        gp.obj[108] = new OBJ_Wood();
        gp.obj[108].worldX = 72 * gp.tileSize;
        gp.obj[108].worldY = 9 * gp.tileSize;
        gp.obj[109] = new OBJ_Wood();
        gp.obj[109].worldX = 72 * gp.tileSize;
        gp.obj[109].worldY = 8 * gp.tileSize;
        gp.obj[110] = new OBJ_Brick();
        gp.obj[110].worldX = 72 * gp.tileSize;
        gp.obj[110].worldY = 10 * gp.tileSize;
        gp.obj[111] = new OBJ_Wood();
        gp.obj[111].worldX = 71 * gp.tileSize;
        gp.obj[111].worldY = 9 * gp.tileSize;
        gp.obj[112] = new OBJ_Wood();
        gp.obj[112].worldX = 70 * gp.tileSize;
        gp.obj[112].worldY = 10 * gp.tileSize;
        gp.obj[113] = new OBJ_Portal();
        gp.obj[113].worldX = 72 * gp.tileSize;
        gp.obj[113].worldY = 11 * gp.tileSize;
    }

    //draws the player sprite for each direction
    public void draw(Graphics2D g2){
   
       BufferedImage image = null;

       //assigns the player sprite 
       // (spriteNum will switch every 10 frames, so the sprite looks like it is moving)
      switch(direction){
        case "up":
            if(doneTree){
                image = apple;
            }
            else{
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }   
            }
            break;
        case "down":
            if(doneTree){
                image = apple;
            }
            else{
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }   
            }
            break;      
        case "right":
            if(doneTree){
                image = apple;
            }
            else{
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }   
            }
            break;       
        case "left":
            if(doneTree){
                image = apple;
            }
            else{
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }   
            }
            
            break;
        
       }

       g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); //draws sprite image of this size

    }  
    
}