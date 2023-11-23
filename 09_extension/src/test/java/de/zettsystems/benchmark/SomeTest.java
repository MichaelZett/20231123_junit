package de.zettsystems.benchmark;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

//@ExtendWith(BenchmarkExtension.class) - das oder die Annotation benutzen
public class SomeTest {

    @Benchmark // alternative zu direktem Extends
    @Test
    void showExtension() {
        List<String> testee = new ArrayList<>();

        testee.add("A");

        assertFalse(testee.isEmpty());
    }
}
