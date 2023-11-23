package de.zettsystems.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnotherTest {
    private FizzBuzzGame testee;

    @BeforeEach
    void setup() {
        testee = new FizzBuzzGame();
    }

    @Test
    void shouldSayNumberforOthers() {
        String result = testee.determineWord(14);

        assertEquals("14", result);

        result = testee.determineWord(7);

        assertEquals("7", result);
    }
}
