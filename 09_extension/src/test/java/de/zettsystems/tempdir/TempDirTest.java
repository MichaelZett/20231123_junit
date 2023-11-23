package de.zettsystems.tempdir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TempDirTest {
    @TempDir
    File anotherTempDir;

    @Test
    void useTempDirFeature() throws IOException {
        assertTrue(this.anotherTempDir.isDirectory(), "Should be a directory ");

        File letters = new File(anotherTempDir, "letters.txt");
        List<String> lines = Arrays.asList("x", "y", "z");

        Files.write(letters.toPath(), lines);

        assertAll(
                () -> assertTrue(Files.exists(letters.toPath()), "File should exist"),
                () -> assertLinesMatch(lines, Files.readAllLines(letters.toPath())));
    }
}
