package de.zettsystems.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvSourceDemo {

    @ParameterizedTest
    @CsvSource({"peter,peter",
            "maria,maria"})
    void testSomething(String a, String b) {
        assertEquals(a, b);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void testSomethingInFile(String a, String b) {
        assertEquals(a, b);
    }
}
