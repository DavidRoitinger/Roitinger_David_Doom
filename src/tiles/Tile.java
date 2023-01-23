package tiles;

public abstract class Tile {
    public TileType tileType;

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
