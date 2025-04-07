//This class checks if two objects are in collision

package jungle;


public class Collisions{

    GamePanel gp;

    public Collisions(GamePanel gp){
        this.gp = gp;
    }

    //checks if a tile is in collision with another 
    public void checkTile(Entity entity){

        //boundaries for the character
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        
        //columns and rows for the character
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){    //sets the collision for any tiles you cannot pass through for each direction
           
            //based on which way the player touches the block, it will collide with it and stop
           
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                //if the collision for that tile is on
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true; //make the player solid
                }

                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }

                break;      
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;       
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }

                break;
           }
        
    }


    //checks if character is touching an object, then returns the index of that object if touching
    public int checkObject(Entity entity, boolean character){

        int index = 999;

        for (int i = 0; i < gp.obj.length; i++){

            if(gp.obj[i] != null){

                //get entity pos:
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                //get objects pos:
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction){

                    //collision based on which direction the player collides from:

                    case "up":
                        entity.solidArea.y -= entity.speed;

                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){   //if the player hitbox touches the object hitbox

                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;     //it will collide and not pass through
                            }
                            if(character == true){ //makes sure that it is a playable character first
                                index = i;
                            }

                        }

                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;

                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){

                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(character == true){ //makes sure that it is a playable character first
                                index = i;
                            }
                    
                        }

                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;

                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){

                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(character == true){ //makes sure that it is a playable character first
                                index = i;
                            }

                        }

                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;

                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){

                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(character == true){ //makes sure that it is a playable character first
                                index = i;
                            }

                        break;
                        }
                }

                //resets all values after iterating
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

            }
        }

        return index;
    }

}