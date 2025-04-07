//Nikhil Shokeen
//4/4/2025
//This class handles the non-interactive png tiles and allows it to be loaded into the game map

package jungle;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;


public class TileManager{

    jungle.GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];  //2D array to store the non-interactive tiles in the map


    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[20];  //gives the array 20 slots to allow for enough tile spaces

        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap();
    }

    //assigns a new non-interactive tile to each index of the array
    public void getTileImage(){

        //assigns a new png for each tile

        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("bush.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("tree.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("road1.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File("cobblestone.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File("stonewall.png"));
            tile[5].collision = true;
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(new File("trap.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(new File("treeTrunk.png"));
            tile[7].collision = false;;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(new File("treeWood.png"));
            tile[10].collision = false;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(new File("A.png"));
            tile[11].collision = false;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(new File("B.png"));
            tile[12].collision = false;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(new File("C.png"));
            tile[13].collision = false;

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //loads the map from the text file
    public void loadMap(){

        try{

            //loads the map txt file and gets all the numbers
            InputStream is = new FileInputStream("map2.txt");

            //reads the numbers from the map
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            
            //reads through all rows and columns of the map array
            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col < gp.maxWorldCol){
                    String[] numbers = line.split(" ");   //splits the line with each space to get only the numbers

                    int num = Integer.parseInt(numbers[col]);  //parses to an int

                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }

            br.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //draws the tile map with each of the matching tiles from the map
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;
        

        //makes sure the current column/row is within the range of the maximums
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            //gets the tile number from the array
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.character.worldX + gp.character.screenX;
            int screenY = worldY - gp.character.worldY + gp.character.screenY;

            //if currently on the screen (not off-screen)

            if(worldX + gp.tileSize > gp.character.worldX - gp.character.screenX 
                && worldX - gp.tileSize < gp.character.worldX + gp.character.screenX
                && worldY + gp.tileSize > gp.character.worldY - gp.character.screenY 
                && worldY - gp.tileSize < gp.character.worldY + gp.character.screenY){

                //draws the tile in the specified screen placement
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
               
            }

            worldCol++;

            //resets the column to zero once it reaches the final col to read the next row
            if (worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow ++;
            }
        }

    }


}