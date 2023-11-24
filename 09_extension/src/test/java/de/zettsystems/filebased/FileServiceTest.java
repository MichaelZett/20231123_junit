package de.zettsystems.filebased;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileServiceTest {
    @TempDir
    File anotherTempDir;

    FileService testee;

    @Disabled
    @Test
    void useTempDirFeature() throws IOException {
        testee = new FileService(anotherTempDir.getPath());
        List<String> lines = Arrays.asList("x", "y", "z");

        List<String> result = testee.readFile();

        assertThat(result).isEqualTo(lines);
    }

}