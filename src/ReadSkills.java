
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import java.util.stream.Collectors;

public class ReadSkills {
    public static List<Skill> read(String path){

        List<Skill> list;


        try {
            list = Files.lines(Path.of(path)).skip(1).map(Skill::deserialize).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException();
        }

       return list;
    }
}
