import tiles.*;

public class PrintManager {
    public static void printCurrentMap(){
        for (Tile[] tiles:Data.currentTileMap) {
            for (Tile tile:tiles) {
                System.out.print(tile);
            }
            System.out.print("\n");
        }
    }
    public static void printStartScreen(){
        System.out.println("""
                +--------------------------------+
                |                                |
                |              Doom              |
                |                                |
                |   1. Start                     |
                |   9. End                       |
                |                                |
                +--------------------------------+
                """);
    }
    public static void printMovementOptions(){
        System.out.print("""
                +--------------------------------+
                |                                |
                |              Move?             |
                |                                |
                 """);
        controlTile(-1, 0, 1, "Top");


        controlTile(1, 0, 2, "Bottom");


        controlTile(0, 1, 3,"Right");


        controlTile(0, -1, 3, "Left");


        System.out.print("""
                |                                |
                +--------------------------------+
                 """);
    }

    private static void controlTile(int xOffset, int yOffset, int option, String side) {
        if (isBlocked(xOffset, yOffset)){
            System.out.printf("|  x. %1$6s is Blocked          |\n",side);
        }else if (isInteractable(xOffset, yOffset)){
            System.out.printf("|  %1$1s. Interact with %2$6s       |\n",option, side);
        }else {
            System.out.printf("|  %1$1s. Move direction: %2$6s     |\n",option, side);
        }
    }

    private static boolean isBlocked(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset] instanceof Wall ||
                Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset] instanceof WeakWall;
    }
    private static boolean isInteractable(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset] instanceof Event ||
                Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset] instanceof Trader ||
                Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset] instanceof Treasure;
    }
}
