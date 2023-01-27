import org.w3c.dom.events.Event;
import tiles.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ReadLayout {
    public static final int LENGTH = 40;
    public static final int HEIGHT = 20;
    public static Tile[][] read(String path){
        Tile[][] tileMap= new Tile[HEIGHT][LENGTH];
        List<String> list;
        String[] splitLine;


        try {
            list = Files.lines(Path.of(path)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException();
        }

        for (int i = 0; i < HEIGHT; i++) {
            splitLine = list.get(i).split("(?!^)");
            for (int j = 0; j < LENGTH; j++) {
                tileMap[i][j] = switch (splitLine[j]){
                    case "#" -> new Tile(TileType.Wall);
                    case "*" -> new Tile(TileType.WeakWall);
                    case "." -> new Tile(TileType.InsideWall);
                    case "!" -> new Tile(TileType.Event);
                    case "S" -> new Tile(TileType.Treasure);
                    case "@" -> new Tile(TileType.Player);
                    case " " -> new Tile(TileType.Empty);
                    default -> null;
                };
            }
        }
        return tileMap;
    }
}
