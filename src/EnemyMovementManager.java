import tiles.*;

import java.util.Random;

public class EnemyMovementManager {
    public static void move(int xEnPos, int yEnPos){

        if(Math.abs(Data.playerXPos-xEnPos) <= 4 && Math.abs(Data.playerYPos-yEnPos) <= 4){
            if(Data.playerXPos-xEnPos == 0){
                if(Data.playerYPos-yEnPos > 0){
                    if (!isBlocked(xEnPos,yEnPos,0, 1)){
                        moveEnemy(xEnPos,yEnPos,0,1);
                    }else{
                        moveRandom(xEnPos, yEnPos);
                    }
                }else if(Data.playerYPos-yEnPos < 0){
                    if (!isBlocked(xEnPos,yEnPos,0, -1)){
                        moveEnemy(xEnPos,yEnPos,0,-1);
                    }else{
                        moveRandom(xEnPos, yEnPos);
                    }
                }

            }else if(Data.playerXPos-xEnPos > 0){
                if (!isBlocked(xEnPos,yEnPos,1, 0)){
                    moveEnemy(xEnPos,yEnPos,1,0);
                }else{
                    moveRandom(xEnPos, yEnPos);
                }
            }else if(Data.playerXPos-xEnPos < 0){
                if (!isBlocked(xEnPos,yEnPos,-1, 0)){
                    moveEnemy(xEnPos,yEnPos,-1,0);
                }else{
                    moveRandom(xEnPos, yEnPos);
                }
            }

        }else {
            moveRandom(xEnPos, yEnPos);
        }

    }

    private static void moveRandom(int xEnPos, int yEnPos) {
        Random rand = new Random();
        switch (rand.nextInt(4)){
            case 0:
                if (!isBlocked(xEnPos, yEnPos,-1, 0)){
                    moveEnemy(xEnPos, yEnPos,-1,0);
                    break;
                }
            case 1:
                if (!isBlocked(xEnPos, yEnPos,1, 0)){
                    moveEnemy(xEnPos, yEnPos,1,0);
                    break;
                }
            case 2:
                if (!isBlocked(xEnPos, yEnPos,0, 1)){
                    moveEnemy(xEnPos, yEnPos,0,1);
                    break;
                }
            case 3:
                if (!isBlocked(xEnPos, yEnPos,0, -1)){
                    moveEnemy(xEnPos, yEnPos,0,-1);
                    break;
                }
        }
    }


    private static boolean isBlocked(int xEnPos, int yEnPos, int xOffset, int yOffset) {
        return !(Data.currentTileMap[xEnPos+xOffset][yEnPos+yOffset].tileType.equals(TileType.Empty));
    }

    private static void moveEnemy(int xEnPos, int yEnPos, int xOffset, int yOffset){
        Data.currentTileMap[xEnPos][yEnPos] = new Tile(TileType.Empty);
        Data.currentTileMap[xEnPos+xOffset][yEnPos+yOffset] = new Tile(TileType.Enemy);
    }
}
