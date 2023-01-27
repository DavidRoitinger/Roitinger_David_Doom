import tiles.*;

import java.util.*;

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
        Data.allSkills = ReadSkills.read("Skills.csv");
        Data.learnedSkills.addAll(Data.allSkills);
        Data.enemyNames.add("Obama");
        Data.level = 1;
        Data.tileMap1 = ReadLayout.read("Layout1.txt");
        Data.currentTileMap = Data.tileMap1;
        for (int i = 0; i < Data.currentTileMap.length; i++) {
            for (int j = 0; j < Data.currentTileMap[i].length; j++) {
                if (Data.currentTileMap[i][j].tileType.equals(TileType.Player)) {
                    Data.playerXPos = i;
                    Data.playerYPos = j;
                }
            }
        }
        populateMap();
        startStage();


    }

    private static void populateMap() {
        Random rand = new Random();
        for (int i = 0; i < Data.currentTileMap.length; i++) {
            for (int j = 0; j < Data.currentTileMap[i].length; j++) {
                if(Data.currentTileMap[i][j].tileType.equals(TileType.Empty) && rand.nextInt((int)(75/(1+(float)Data.level/10f)))==0){
                    Data.currentTileMap[i][j]=new Tile(TileType.Enemy);
                }
            }
        }
    }

    public void startStage(){
        System.out.println("Start of the "+Data.level+".level");

        boolean finished = false;
        while (!finished){
            PrintManager.printCurrentMap();
            PrintManager.printMovementOptions();
            switch (s.nextLine().toUpperCase()){
                case "W" -> PlayerMovementManager.move(-1,0);
                case "S" -> PlayerMovementManager.move(1,0);
                case "D" -> PlayerMovementManager.move(0,1);
                case "A" -> PlayerMovementManager.move(0,-1);
                case "E" -> {
                    PrintManager.printSkills();
                    s.nextLine();
                }
                default -> {
                    System.out.println("Wrong Input!");
                    s.nextLine();
                }
            }
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();



            for (int i = 0; i < Data.currentTileMap.length; i++) {
                for (int j = 0; j < Data.currentTileMap[i].length; j++) {
                    if(Data.currentTileMap[i][j].tileType.equals(TileType.Enemy)){
                        x.add(i);
                        y.add(j);
                    }
                }
            }

            for (int i = 0; i < x.size(); i++) {
                EnemyMovementManager.move(x.get(i), y.get(i));
            }

            if(enemyIsClose()){
                FightManager fightManager = new FightManager();

                if(!fightManager.startFight()){
                    PrintManager.printDefeat();
                    s.nextLine();
                    System.exit(0);
                }
                for (int i = 0; i < x.size(); i++) {
                    if(tileIsClose(x.get(i),y.get(i))){
                        Data.currentTileMap[x.get(i)][y.get(i)] = new Tile(TileType.Empty);
                    }
                }
            }



        }

    }

    private boolean enemyIsClose() {
        return Data.currentTileMap[Data.playerXPos - 1][Data.playerYPos].tileType.equals(TileType.Enemy) ||
                Data.currentTileMap[Data.playerXPos + 1][Data.playerYPos].tileType.equals(TileType.Enemy) ||
                Data.currentTileMap[Data.playerXPos][Data.playerYPos + 1].tileType.equals(TileType.Enemy) ||
                Data.currentTileMap[Data.playerXPos][Data.playerYPos - 1].tileType.equals(TileType.Enemy);
    }
    private boolean tileIsClose(int x, int y) {

        //Math.abs(expected - actual) <= epsilon
        return Math.abs(Data.playerXPos - x) <= 1 &&  Math.abs(Data.playerYPos - y) <= 1;
    }
}
