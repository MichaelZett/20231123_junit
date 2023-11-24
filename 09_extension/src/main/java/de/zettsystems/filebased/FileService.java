package de.zettsystems.filebased;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileService {
    private File myDir;
    private File letters;

    // ExternalisiertesProperty z.B, @Value, PropertyResolver....path.to.my.dir
    public FileService(String path) {
        myDir = new File(path);
        letters = new File(myDir, "letters.txt");
        List<String> lines = Arrays.asList("x", "y", "z");

        try {
            Files.write(letters.toPath(), lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readFile() throws IOException {
        return Files.readAllLines(myDir.toPath());
    }
}
