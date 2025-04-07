//Nikhil Shokeen
//4/4/2025
//This class initializes all interactive blocks for the game

package jungle;

import jungle.GamePanel;


public class InteractiveObjPlacer{

    GamePanel gp;
    KeyHandler keyH;
    String direction;

    public InteractiveObjPlacer(GamePanel gp){
        this.gp = gp;
    } 

    public void setObject(){

        //random index creates random coordinates for each trap; places trap under random bush
        int rand1 = 2 * ((int) (Math.random()*4)+5) - 1;
        int rand2 = 2 * ((int) (Math.random()*4)+5) - 1;  //4 possible values: 9, 11, 13, 15
        int rand3 = 2 * ((int) (Math.random()*4)+5) - 1;
        int rand4 = 2 * ((int) (Math.random()*4)+5) - 1;
        int rand5 = 2 * ((int) (Math.random()*4)+3) + 1;
        int rand6 = 2 * ((int) (Math.random()*4)+3) + 1;  //4 possible values: 7, 9, 11, 13
        int rand7 = 2 * ((int) (Math.random()*4)+3) + 1;
        int rand8 = 2 * ((int) (Math.random()*4)+3) + 1;

       
        //does not let two objects fall under the same bush together:

        while((rand1 == rand2) || (rand2 == rand3) || (rand1 == rand3)){  //makes sure no x-coord are the same
            rand1 = 2 * ((int) (Math.random()*3)+5) - 1;
            rand2 = 2 * ((int) (Math.random()*3)+5) - 1;
            rand3 = 2 * ((int) (Math.random()*3)+5) - 1;
        }


        while((rand5 == rand6) || (rand6 == rand7) || (rand5 == rand7)){  //makes sure no y-coord are the same
            rand5 = 2 * ((int) (Math.random()*3)+3) + 1;
            rand6 = 2 * ((int) (Math.random()*3)+3) + 1;
            rand7 = 2 * ((int) (Math.random()*3)+3) + 1;
        }

        while((rand3 == rand4) || (rand2 == rand4) || (rand1 == rand4)){
            rand4 = 2 * ((int) (Math.random()*4)+5) - 1;
        }
        
        //places a new block object into the array
        //uses the specific array index to place it onto the screen:

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 25 * gp.tileSize;
        gp.obj[1].worldY = 39 * gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 20 * gp.tileSize;
        gp.obj[2].worldY = 10 * gp.tileSize;

        gp.obj[3] = new OBJ_Health();
        gp.obj[3].worldX = 58 * gp.tileSize;
        gp.obj[3].worldY = 31 * gp.tileSize;

        gp.obj[4] = new OBJ_Trap();
        gp.obj[4].worldX = rand1 * gp.tileSize;
        gp.obj[4].worldY = rand5 * gp.tileSize;

        gp.obj[5] = new OBJ_Trap();
        gp.obj[5].worldX = rand2 * gp.tileSize;
        gp.obj[5].worldY = rand6 * gp.tileSize;

        gp.obj[6] = new OBJ_Trap();
        gp.obj[6].worldX = rand3 * gp.tileSize;
        gp.obj[6].worldY = rand7 * gp.tileSize;

        gp.obj[7] = new OBJ_BowNArrow();
        gp.obj[7].worldX = rand4 * gp.tileSize;
        gp.obj[7].worldY = rand8 * gp.tileSize;

        gp.obj[8] = new OBJ_Bush();
        gp.obj[8].worldX = 9 * gp.tileSize;
        gp.obj[8].worldY = 7 * gp.tileSize;

        gp.obj[9] = new OBJ_Bush();
        gp.obj[9].worldX = 9 * gp.tileSize;
        gp.obj[9].worldY = 9 * gp.tileSize;

        gp.obj[10] = new OBJ_Bush();
        gp.obj[10].worldX = 9 * gp.tileSize;
        gp.obj[10].worldY = 11 * gp.tileSize;

        gp.obj[18] = new OBJ_Bush();
        gp.obj[18].worldX = 9 * gp.tileSize;
        gp.obj[18].worldY = 13 * gp.tileSize;

        gp.obj[11] = new OBJ_Bush();
        gp.obj[11].worldX = 11 * gp.tileSize;
        gp.obj[11].worldY = 7 * gp.tileSize;
        
        gp.obj[12] = new OBJ_Bush();
        gp.obj[12].worldX = 11 * gp.tileSize;
        gp.obj[12].worldY = 9 * gp.tileSize;

        gp.obj[13] = new OBJ_Bush();
        gp.obj[13].worldX = 11 * gp.tileSize;
        gp.obj[13].worldY = 11 * gp.tileSize;

        gp.obj[19] = new OBJ_Bush();
        gp.obj[19].worldX = 11 * gp.tileSize;
        gp.obj[19].worldY = 13 * gp.tileSize;

        gp.obj[14] = new OBJ_Bush();
        gp.obj[14].worldX = 13 * gp.tileSize;
        gp.obj[14].worldY = 7 * gp.tileSize;

        gp.obj[15] = new OBJ_Bush();
        gp.obj[15].worldX = 13 * gp.tileSize;
        gp.obj[15].worldY = 9 * gp.tileSize;

        gp.obj[16] = new OBJ_Bush();
        gp.obj[16].worldX = 13 * gp.tileSize;
        gp.obj[16].worldY = 11 * gp.tileSize;

        gp.obj[20] = new OBJ_Bush();
        gp.obj[20].worldX = 13 * gp.tileSize;
        gp.obj[20].worldY = 13 * gp.tileSize;

        gp.obj[21] = new OBJ_Bush();
        gp.obj[21].worldX = 15 * gp.tileSize;
        gp.obj[21].worldY = 7 * gp.tileSize;

        gp.obj[22] = new OBJ_Bush();
        gp.obj[22].worldX = 15 * gp.tileSize;
        gp.obj[22].worldY = 9 * gp.tileSize;

        gp.obj[23] = new OBJ_Bush();
        gp.obj[23].worldX = 15 * gp.tileSize;
        gp.obj[23].worldY = 11 * gp.tileSize;

        gp.obj[24] = new OBJ_Bush();
        gp.obj[24].worldX = 15 * gp.tileSize;
        gp.obj[24].worldY = 13 * gp.tileSize;

        //creates a random x and y coordinate for the tiger
        int tigerRandX = (int) (Math.random()*20) + 21;
        int tigerRandY = (int) (Math.random()*11) + 5;

        gp.obj[17] = new OBJ_Tiger();
        gp.obj[17].worldX = tigerRandX * gp.tileSize;
        gp.obj[17].worldY = tigerRandY * gp.tileSize;

        gp.obj[25] = new OBJ_Door2();
        gp.obj[25].worldX = 41 * gp.tileSize;
        gp.obj[25].worldY = 12 * gp.tileSize;

        gp.obj[27] = new OBJ_Paper();
        gp.obj[27].worldX = 47 * gp.tileSize;
        gp.obj[27].worldY = 7 * gp.tileSize;     
        
        gp.obj[28] = new OBJ_RedButtonSelect();
        gp.obj[28].worldX = 45 * gp.tileSize;
        gp.obj[28].worldY = 11 * gp.tileSize;  
        
        gp.obj[29] = new OBJ_GreenButtonSelect();
        gp.obj[29].worldX = 47 * gp.tileSize;
        gp.obj[29].worldY = 11 * gp.tileSize; 
        
        gp.obj[30] = new OBJ_BlueButtonSelect();
        gp.obj[30].worldX = 49 * gp.tileSize;
        gp.obj[30].worldY = 11 * gp.tileSize;

        gp.obj[31] = new OBJ_RedButton();
        gp.obj[31].worldX = 45 * gp.tileSize;
        gp.obj[31].worldY = 11 * gp.tileSize;  
        
        gp.obj[32] = new OBJ_GreenButton();
        gp.obj[32].worldX = 47 * gp.tileSize;
        gp.obj[32].worldY = 11 * gp.tileSize; 
        
        gp.obj[33] = new OBJ_BlueButton();
        gp.obj[33].worldX = 49 * gp.tileSize;
        gp.obj[33].worldY = 11 * gp.tileSize;  

        gp.obj[35] = new OBJ_Door3();
        gp.obj[35].worldX = 54 * gp.tileSize;
        gp.obj[35].worldY = 9 * gp.tileSize;  

        level4objects();

        gp.obj[80] = new OBJ_WoodBranch();
        gp.obj[80].worldX = 10 * gp.tileSize;
        gp.obj[80].worldY = 26 * gp.tileSize;

        gp.obj[75] = new OBJ_StumpRight();
        gp.obj[75].worldX = 15 * gp.tileSize;
        gp.obj[75].worldY = 23 * gp.tileSize;

        gp.obj[76] = new OBJ_WoodBranch();
        gp.obj[76].worldX = 15 * gp.tileSize;
        gp.obj[76].worldY = 23 * gp.tileSize;

        tree1Border(); 
        fruits();
        powerUps();    
        infoBlocks();
        
        gp.obj[138] = new OBJ_Door5();
        gp.obj[138].worldX = 46 * gp.tileSize;
        gp.obj[138].worldY = 24 * gp.tileSize;

        gp.obj[144] = new OBJ_Grass();
        gp.obj[144].worldX = 50 * gp.tileSize;
        gp.obj[144].worldY = 24 * gp.tileSize;
        
    }

    //level information blocks 
    public void infoBlocks(){
        gp.obj[132] = new OBJ_Info();
        gp.obj[132].worldX = 7 * gp.tileSize;
        gp.obj[132].worldY = 10 * gp.tileSize;

        gp.obj[133] = new OBJ_Info();
        gp.obj[133].worldX = 23 * gp.tileSize;
        gp.obj[133].worldY = 10 * gp.tileSize;

        gp.obj[134] = new OBJ_Info();
        gp.obj[134].worldX = 43 * gp.tileSize;
        gp.obj[134].worldY = 8 * gp.tileSize;

        gp.obj[135] = new OBJ_Info();
        gp.obj[135].worldX = 56 * gp.tileSize;
        gp.obj[135].worldY = 9 * gp.tileSize;

        gp.obj[136] = new OBJ_Info();
        gp.obj[136].worldX = 7 * gp.tileSize;
        gp.obj[136].worldY = 24 * gp.tileSize;

        gp.obj[137] = new OBJ_Info();
        gp.obj[137].worldX = 24 * gp.tileSize;
        gp.obj[137].worldY = 23 * gp.tileSize;
        
        gp.obj[129] = new OBJ_Info();
        gp.obj[129].worldX = 48 * gp.tileSize;
        gp.obj[129].worldY = 21 * gp.tileSize;
    }

    //maze powerups
    public void powerUps(){
        gp.obj[117] = new OBJ_Coin();
        gp.obj[117].worldX = 57 * gp.tileSize;
        gp.obj[117].worldY = 21 * gp.tileSize;

        gp.obj[118] = new OBJ_Coin();
        gp.obj[118].worldX = 55 * gp.tileSize;
        gp.obj[118].worldY = 22 * gp.tileSize;

        gp.obj[119] = new OBJ_Coin();
        gp.obj[119].worldX = 56 * gp.tileSize;
        gp.obj[119].worldY = 29 * gp.tileSize;

        gp.obj[120] = new OBJ_Coin();
        gp.obj[120].worldX = 63 * gp.tileSize;
        gp.obj[120].worldY = 22 * gp.tileSize;

        gp.obj[121] = new OBJ_Coin();
        gp.obj[121].worldX = 67 * gp.tileSize;
        gp.obj[121].worldY = 31 * gp.tileSize;

        gp.obj[122] = new OBJ_Coin();
        gp.obj[122].worldX = 68 * gp.tileSize;
        gp.obj[122].worldY = 28 * gp.tileSize;

        gp.obj[123] = new OBJ_Pause();
        gp.obj[123].worldX = 72 * gp.tileSize;
        gp.obj[123].worldY = 30 * gp.tileSize;

        gp.obj[124] = new OBJ_Coin();
        gp.obj[124].worldX = 76 * gp.tileSize;
        gp.obj[124].worldY = 26 * gp.tileSize;

        gp.obj[125] = new OBJ_Coin();
        gp.obj[125].worldX = 72 * gp.tileSize;
        gp.obj[125].worldY = 25 * gp.tileSize;

        gp.obj[126] = new OBJ_Pause();
        gp.obj[126].worldX = 60 * gp.tileSize;
        gp.obj[126].worldY = 28 * gp.tileSize;

        gp.obj[127] = new OBJ_Health();
        gp.obj[127].worldX = 75 * gp.tileSize;
        gp.obj[127].worldY = 31 * gp.tileSize;

        gp.obj[128] = new OBJ_Health();
        gp.obj[128].worldX = 65 * gp.tileSize;
        gp.obj[128].worldY = 24 * gp.tileSize;

        gp.obj[131] = new OBJ_End();
        gp.obj[131].worldX = 71 * gp.tileSize;
        gp.obj[131].worldY = 33 * gp.tileSize;


    }

    //creates fruits for the tree
    public void fruits(){
        gp.obj[93] = new OBJ_Apple();
        gp.obj[93].worldX = 16 * gp.tileSize;
        gp.obj[93].worldY = 26 * gp.tileSize;

        gp.obj[94] = new OBJ_Apple();
        gp.obj[94].worldX = 10 * gp.tileSize;
        gp.obj[94].worldY = 23 * gp.tileSize;

        gp.obj[95] = new OBJ_Banana();
        gp.obj[95].worldX = 10 * gp.tileSize;
        gp.obj[95].worldY = 26 * gp.tileSize;

        gp.obj[96] = new OBJ_Banana();
        gp.obj[96].worldX = 15 * gp.tileSize;
        gp.obj[96].worldY = 23 * gp.tileSize;
    }

    //places transparent objects around the tree so you cannot enter it from anywhere except the bottom
    public void tree1Border(){
        gp.obj[82] = new OBJ_Grass();
        gp.obj[82].worldX = 9 * gp.tileSize;
        gp.obj[82].worldY = 24 * gp.tileSize;

        gp.obj[83] = new OBJ_Grass();
        gp.obj[83].worldX = 10 * gp.tileSize;
        gp.obj[83].worldY = 25 * gp.tileSize;

        gp.obj[84] = new OBJ_Grass();
        gp.obj[84].worldX = 11 * gp.tileSize;
        gp.obj[84].worldY = 28 * gp.tileSize;

        gp.obj[85] = new OBJ_Grass();
        gp.obj[85].worldX = 14 * gp.tileSize;
        gp.obj[85].worldY = 28 * gp.tileSize;
        
        gp.obj[86] = new OBJ_Grass();
        gp.obj[86].worldX = 15 * gp.tileSize;
        gp.obj[86].worldY = 27 * gp.tileSize;

        gp.obj[87] = new OBJ_Grass();
        gp.obj[87].worldX = 16 * gp.tileSize;
        gp.obj[87].worldY = 27 * gp.tileSize;

        gp.obj[88] = new OBJ_Grass();
        gp.obj[88].worldX = 17 * gp.tileSize;
        gp.obj[88].worldY = 26 * gp.tileSize;

        gp.obj[89] = new OBJ_Grass();
        gp.obj[89].worldX = 16 * gp.tileSize;
        gp.obj[89].worldY = 24 * gp.tileSize;

        gp.obj[90] = new OBJ_Grass();
        gp.obj[90].worldX = 15 * gp.tileSize;
        gp.obj[90].worldY = 22 * gp.tileSize;

        gp.obj[91] = new OBJ_Grass();
        gp.obj[91].worldX = 14 * gp.tileSize;
        gp.obj[91].worldY = 26 * gp.tileSize;

        gp.obj[92] = new OBJ_Grass();
        gp.obj[92].worldX = 15 * gp.tileSize;
        gp.obj[92].worldY = 26 * gp.tileSize;

        gp.obj[97] = new OBJ_Grass();
        gp.obj[97].worldX = 14 * gp.tileSize;
        gp.obj[97].worldY = 22 * gp.tileSize;

        gp.obj[98] = new OBJ_Grass();
        gp.obj[98].worldX = 14 * gp.tileSize;
        gp.obj[98].worldY = 24 * gp.tileSize;

        gp.obj[99] = new OBJ_Grass();
        gp.obj[99].worldX = 11 * gp.tileSize;
        gp.obj[99].worldY = 23 * gp.tileSize;

        gp.obj[130] = new OBJ_Grass();
        gp.obj[130].worldX = 11 * gp.tileSize;
        gp.obj[130].worldY = 25 * gp.tileSize;
    }


    //level 4's blocks
    public void level4objects(){    
        gp.obj[37] = new OBJ_Brick();
        gp.obj[37].worldX = 63 * gp.tileSize;
        gp.obj[37].worldY = 8 * gp.tileSize;  

        gp.obj[39] = new OBJ_Brick();
        gp.obj[39].worldX = 61 * gp.tileSize;
        gp.obj[39].worldY = 8 * gp.tileSize; 

        gp.obj[40] = new OBJ_Brick();
        gp.obj[40].worldX = 65 * gp.tileSize;
        gp.obj[40].worldY = 10 * gp.tileSize; 

        gp.obj[41] = new OBJ_Brick();
        gp.obj[41].worldX = 60 * gp.tileSize;
        gp.obj[41].worldY = 6 * gp.tileSize; 

        gp.obj[42] = new OBJ_Brick();
        gp.obj[42].worldX = 59 * gp.tileSize;
        gp.obj[42].worldY = 9 * gp.tileSize; 

        gp.obj[43] = new OBJ_Brick();
        gp.obj[43].worldX = 58 * gp.tileSize;
        gp.obj[43].worldY = 11 * gp.tileSize; 

        gp.obj[44] = new OBJ_Brick();
        gp.obj[44].worldX = 58 * gp.tileSize;
        gp.obj[44].worldY = 14 * gp.tileSize; 

        gp.obj[45] = new OBJ_Brick();
        gp.obj[45].worldX = 65 * gp.tileSize;
        gp.obj[45].worldY = 14 * gp.tileSize; 

        gp.obj[47] = new OBJ_Wood();
        gp.obj[47].worldX = 68 * gp.tileSize;
        gp.obj[47].worldY = 6 * gp.tileSize;
        
        gp.obj[48] = new OBJ_Wood();
        gp.obj[48].worldX = 68 * gp.tileSize;
        gp.obj[48].worldY = 6 * gp.tileSize;

        gp.obj[48] = new OBJ_Wood();
        gp.obj[48].worldX = 68 * gp.tileSize;
        gp.obj[48].worldY = 9 * gp.tileSize;

        gp.obj[49] = new OBJ_Wood();
        gp.obj[49].worldX = 67 * gp.tileSize;
        gp.obj[49].worldY = 10 * gp.tileSize;

        gp.obj[50] = new OBJ_Wood();
        gp.obj[50].worldX = 66 * gp.tileSize;
        gp.obj[50].worldY = 8 * gp.tileSize;

        gp.obj[51] = new OBJ_Wood();
        gp.obj[51].worldX = 62 * gp.tileSize;
        gp.obj[51].worldY = 8 * gp.tileSize;

        gp.obj[52] = new OBJ_Wood();
        gp.obj[52].worldX = 61 * gp.tileSize;
        gp.obj[52].worldY = 14 * gp.tileSize;

        gp.obj[53] = new OBJ_Wood();
        gp.obj[53].worldX = 62 * gp.tileSize;
        gp.obj[53].worldY = 14 * gp.tileSize;

        gp.obj[54] = new OBJ_Wood();
        gp.obj[54].worldX = 58 * gp.tileSize;
        gp.obj[54].worldY = 9 * gp.tileSize;

        gp.obj[55] = new OBJ_Water();
        gp.obj[55].worldX = 61 * gp.tileSize;
        gp.obj[55].worldY = 10 * gp.tileSize;

        gp.obj[56] = new OBJ_Water();
        gp.obj[56].worldX = 62 * gp.tileSize;
        gp.obj[56].worldY = 10 * gp.tileSize;

        gp.obj[57] = new OBJ_Water();
        gp.obj[57].worldX = 62 * gp.tileSize;
        gp.obj[57].worldY = 11 * gp.tileSize;
        
        gp.obj[58] = new OBJ_Water();
        gp.obj[58].worldX = 63 * gp.tileSize;
        gp.obj[58].worldY = 14 * gp.tileSize;

        gp.obj[59] = new OBJ_Water();
        gp.obj[59].worldX = 65 * gp.tileSize;
        gp.obj[59].worldY = 6 * gp.tileSize;

        gp.obj[60] = new OBJ_Water();
        gp.obj[60].worldX = 65 * gp.tileSize;
        gp.obj[60].worldY = 7 * gp.tileSize;

        gp.obj[61] = new OBJ_Water();
        gp.obj[61].worldX = 66 * gp.tileSize;
        gp.obj[61].worldY = 7 * gp.tileSize;
        
        gp.obj[62] = new OBJ_Water();
        gp.obj[62].worldX = 68 * gp.tileSize;
        gp.obj[62].worldY = 12 * gp.tileSize;

        gp.obj[63] = new OBJ_Water();
        gp.obj[63].worldX = 59 * gp.tileSize;
        gp.obj[63].worldY = 7 * gp.tileSize;

        gp.obj[64] = new OBJ_Water();
        gp.obj[64].worldX = 59 * gp.tileSize;
        gp.obj[64].worldY = 8 * gp.tileSize;

        gp.obj[65] = new OBJ_Bush();
        gp.obj[65].worldX = 59 * gp.tileSize;
        gp.obj[65].worldY = 11 * gp.tileSize;

        gp.obj[66] = new OBJ_Bush();
        gp.obj[66].worldX = 61 * gp.tileSize;
        gp.obj[66].worldY = 11 * gp.tileSize;

        gp.obj[67] = new OBJ_Bush();
        gp.obj[67].worldX = 64 * gp.tileSize;
        gp.obj[67].worldY = 12 * gp.tileSize;

        gp.obj[68] = new OBJ_Bush();
        gp.obj[68].worldX = 64 * gp.tileSize;
        gp.obj[68].worldY = 13 * gp.tileSize;

        gp.obj[140] = new OBJ_Bush();
        gp.obj[140].worldX = 66 * gp.tileSize;
        gp.obj[140].worldY = 10 * gp.tileSize;

        gp.obj[69] = new OBJ_Coin();
        gp.obj[69].worldX = 66 * gp.tileSize;
        gp.obj[69].worldY = 10 * gp.tileSize;

        gp.obj[139] = new OBJ_Bush();
        gp.obj[139].worldX = 66 * gp.tileSize;
        gp.obj[139].worldY = 13 * gp.tileSize;

        gp.obj[70] = new OBJ_Coin();
        gp.obj[70].worldX = 66 * gp.tileSize;
        gp.obj[70].worldY = 13 * gp.tileSize;

        gp.obj[71] = new OBJ_Bush();
        gp.obj[71].worldX = 61 * gp.tileSize;
        gp.obj[71].worldY = 6 * gp.tileSize;

        gp.obj[72] = new OBJ_Bush();
        gp.obj[72].worldX = 61 * gp.tileSize;
        gp.obj[72].worldY = 7 * gp.tileSize;

        gp.obj[73] = new OBJ_Bush();
        gp.obj[73].worldX = 67 * gp.tileSize;
        gp.obj[73].worldY = 9 * gp.tileSize;

        gp.obj[74] = new OBJ_Bush();
        gp.obj[74].worldX = 68 * gp.tileSize;
        gp.obj[74].worldY = 8 * gp.tileSize;

        gp.obj[114] = new Pet();
        gp.obj[114].worldX = 25 * gp.tileSize;
        gp.obj[114].worldY = 22 * gp.tileSize;
        
        gp.obj[116] = new OBJ_Door4();
        gp.obj[116].worldX = 21 * gp.tileSize;
        gp.obj[116].worldY = 23 * gp.tileSize;
    }

}