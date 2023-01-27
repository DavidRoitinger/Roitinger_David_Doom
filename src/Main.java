import tiles.Tile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread music = new Thread(new Sound());
        music.start();
        Manager manager = new Manager();
        manager.startGame();
    }
}