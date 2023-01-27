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
                +--------------------------------+--------------------------------+
                |                                |                                |
                |              Move?             |             Player             |
                |                                |                                |
                """);
        controlTile(-1, 0, "W", "Top");
        System.out.printf("      HP: %1$3s \\ %2$3s             |\n", Data.playerHealth, Data.playerMaxHealth);

        controlTile(1, 0, "S", "Bottom");
        System.out.printf("      MP: %1$3s \\ %2$3s             |\n", Data.playerMana, Data.playerMaxMana);

        controlTile(0, 1, "D","Right");
        System.out.printf("      Gold: %1$4s                |\n", Data.playerGold);

        controlTile(0, -1, "A", "Left");
        System.out.println("      E. acquired Skills        |");

        System.out.print("""
                |                                |                                |
                +--------------------------------+--------------------------------+
                 """);
    }

    private static void controlTile(int xOffset, int yOffset, String option, String side) {
        if (isBlocked(xOffset, yOffset)){
            System.out.printf("|  x. %1$6s is Blocked          |",side);
        }else if (isInteractable(xOffset, yOffset)){
            System.out.printf("|  %1$1s. Interact with %2$6s       |",option, side);
        }else {
            System.out.printf("|  %1$1s. Move direction: %2$6s     |",option, side);
        }
    }

    private static boolean isBlocked(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Wall) ||
                Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.WeakWall);
    }
    private static boolean isInteractable(int xOffset, int yOffset) {
        return Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Event)  ||
                Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Trader) ||
                Data.currentTileMap[Data.playerXPos+xOffset][Data.playerYPos+yOffset].tileType.equals(TileType.Treasure);
    }

    public static void printFightingStart(Enemy enemy){
        System.out.println("""
                +-----------------------------------+-----------------------------------+
                |                                   |                                   |
                |       A Enemy has appeared!       |                                   |""");
        System.out.printf("|         %1$10s!               |              Player               |\n", enemy.getEnemyName());
        System.out.printf("|      HP: %1$3s      Dmg.: %2$3s       |      HP: %3$3s      Mana: %4$3s       |\n", enemy.getEnemyHealth(), enemy.getEnemyDamage(),Data.playerHealth, Data.playerMana);
        System.out.println("""
                |                                   |                                   |
                +-----------------------------------+-----------------------------------+
                """);
    }
    public static void printFightingInfo(Enemy enemy){
        System.out.println("""
                +-----------------------------------+-----------------------------------+
                |                                   |                                   |""");
        System.out.printf("|         %1$10s!               |              Player               |\n", enemy.getEnemyName());
        System.out.printf("|      HP: %1$3s      Dmg.: %2$3s       |      HP: %3$3s      Mana: %4$3s       |\n", enemy.getEnemyHealth(), enemy.getEnemyDamage(),Data.playerHealth, Data.playerMana);
        System.out.println("""
                |                                   |                                   |
                +-----------------------------------+-----------------------------------+
                """);
    }
    public static void printFighting(){
        System.out.println("""
                +------------------------------------------+
                |                                          |
                |                  Attac                   |""");
        for (int i = 0; i < Data.learnedSkills.size(); i++) {
            System.out.printf("|  %1$2s. %2$30s      |\n", i+1, Data.learnedSkills.get(i).getName());
        }

        System.out.println("""
                |                                          |
                +------------------------------------------+
                """);
    }
    public static void printSkills(){
        System.out.println("""
                +------------------------------------------------------------------------------------------------------+
                |                                                                                                      |
                |                                                 Skills                                               |""");
        for (int i = 0; i < Data.learnedSkills.size(); i++) {
            System.out.printf("|  %1$2s. %2$85s           |\n", i+1, Data.learnedSkills.get(i));
        }

        System.out.println("""
                |                                                                                                      |
                +------------------------------------------------------------------------------------------------------+
                """);
    }
    public static void printDefeat(){
        System.out.println("""
                +--------------------------------+
                |                                |
                |           Defeat! :'(          |
                |                                |
                |        Press any Button        |
                |          to give up!           |
                |                                |
                +--------------------------------+
                """);
    }

}
