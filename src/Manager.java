import tiles.Player;
import tiles.Tile;

import java.util.Arrays;
import java.util.Scanner;

public class Manager {
    private Scanner s = new Scanner(System.in);
    public void startGame(){

        boolean start = false;
        while (!start){
            PrintManager.printStartScreen();
            switch (s.nextLine()) {
                case "1" -> {
                    System.out.println("Starting Game");
                    start = true;
                }
                case "9" -> {
                    System.out.println("Ending Game");
                    System.exit(0);
                }
                default -> System.out.println("Wrong Input!");
            }

        }

        Data.level = 1;
        Data.TileMap1 = ReadLayout.read("Layout1.txt");
        Data.currentTileMap = Data.TileMap1;
        for (int i = 0; i < Data.currentTileMap.length; i++) {
            for (int j = 0; j < Data.currentTileMap[i].length; j++) {
                if (Data.currentTileMap[i][j] instanceof Player) {
                    Data.playerXPos = i;
                    Data.playerYPos = j;
                }
            }
        }
        startStage();


    }

    public void startStage(){
        System.out.println("Start of the "+Data.level+".level");
        PrintManager.printCurrentMap();


        PrintManager.printMovementOptions();
        switch (s.nextLine()){
            case "1" -> System.out.println("1");
            case "2" -> System.out.println("2");
            case "3" -> System.out.println("3");
            case "4" -> System.out.println("4");
            default -> System.out.println("Wrong Input!");
        }

    }
}
