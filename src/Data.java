import tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static Tile[][] currentTileMap;

    public static Tile[][] tileMap1;
    public static List<Skill> allSkills = new ArrayList<>();
    public static List<String> enemyNames = new ArrayList<>();

    public static int level;

    public static int playerXPos;
    public static int playerYPos;
    public static int playerHealth = 20;
    public static int playerMaxHealth = 20;
    public static int playerMana = 20;
    public static int playerMaxMana = 20;
    public static int playerGold = 20;
    public static List<Skill> learnedSkills = new ArrayList<>();
}
