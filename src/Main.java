import tiles.Tile;

public class Main {
    public static void main(String[] args) {
        Tile[][] tiles = ReadLayout.read("Layout.txt");
        PrintManager.printCurrentMap(tiles);
    }
}