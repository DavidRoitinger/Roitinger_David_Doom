import tiles.*;

import java.util.Scanner;

public class PlayerMovementManager {

    public static void move(int xOffset, int yOffset){
        Scanner scanner = new Scanner(System.in);
        if (isBlocked(xOffset, yOffset)){
            System.out.println("Is Blocked!");
            scanner.nextLine();
        }else if (isTreasure(xOffset,yOffset)){
            System.out.println("You won!");
            scanner.nextLine();
            System.exit(69);
        }else if (isEvent(xOffset,yOffset)){
            System.out.println("wow!");
            scanner.nextLine();
        }else if (isTrader(xOffset,yOffset)){
            System.out.println("wow!");
            scanner.nextLine();
        }else {
            movePlayer(Data.playerXPos+xOffset,Data.playerYPos+yOffset);
        }
    }




    private static boolean isBlocked(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Wall) ||
                Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.WeakWall);
    }
    private static boolean isTreasure(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Treasure);
    }
    private static boolean isEvent(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Event);
    }
    private static boolean isTrader(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Trader);
    }


    private static void movePlayer(int xNew, int yNew){
        Data.currentTileMap[Data.playerXPos][Data.playerYPos] = new Tile(TileType.Empty);
        Data.currentTileMap[xNew][yNew] = new Tile(TileType.Player);
        Data.playerXPos = xNew;
        Data.playerYPos = yNew;
    }
}
