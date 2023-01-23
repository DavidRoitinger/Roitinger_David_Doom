import tiles.Tile;

public class PrintManager {
    public static void printCurrentMap(Tile[][] tilemap){
        for (Tile[] tileRow:tilemap) {
            for (Tile tile:tileRow) {
                System.out.print(tile);
            }
            System.out.print("\n");
        }
    }
}
