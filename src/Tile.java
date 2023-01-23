public abstract class Tile {
    private TileType tileType;

    @Override
    public String toString() {

        return switch (tileType){
            case Enemy -> "X";
            case Wall -> "#";
            case Empty -> " ";
            case Treasure -> "S";
            case Player -> "@";
            case Trader -> "€";
            case Event -> "!";
            default -> "?";
        };
    }
}
