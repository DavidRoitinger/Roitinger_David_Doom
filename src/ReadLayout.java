import tiles.Tile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ReadLayout {
    public static Tile[][] read(String path){
        Tile[][] tileMap= new Tile[20][40];
        try {
            Files.lines(Path.of(path)).forEach(line ->{

            });
        } catch (IOException e) {

        }
    }
}
