package de.zettsystems;

import de.zettsystems.fizzbuzz.FizzBuzzGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoreTest {
    private FizzBuzzGame testee;

    @BeforeEach
    void setup() {
        testee = new FizzBuzzGame();
    }

    @Test
    void shouldSayFizzForMultipleOfThree() {
        String result = testee.determineWord(3);

        assertEquals("Fizz", result);

        result = testee.determineWord(27);

        assertEquals("Fizz", result);
    }
}
