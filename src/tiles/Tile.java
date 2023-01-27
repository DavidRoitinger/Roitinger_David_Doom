package tiles;

public class Tile {
    public TileType tileType;

    public Tile(TileType tileType) {
        this.tileType = tileType;
    }

    @Override
    public String toString() {

        return switch (tileType){
            case Enemy -> "X";
            case Wall -> "#";
            case WeakWall -> "*";
            case InsideWall -> ".";
            case Empty -> " ";
            case Treasure -> "S";
            case Player -> "ඞ";
            case Trader -> "€";
            case Event -> "!";
            default -> "?";
        };
    }
}
