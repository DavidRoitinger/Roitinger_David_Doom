import tiles.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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
                    case "#" -> new Wall();
                    case "*" -> new WeakWall();
                    case "." -> new InsideWall();
                    case "!" -> new Event();
                    case "S" -> new Treasure();
                    case "@" -> new Player();
                    case " " -> new Empty();
                    default -> null;
                };
            }
        }
        return tileMap;
    }
}
