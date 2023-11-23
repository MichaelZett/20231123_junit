package de.zettsystems.fizzbuzz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzGameTest {
    private static FizzBuzzGame testee;

    @BeforeAll
    static void setup() {
        testee = new FizzBuzzGame();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18})
    void shouldDetermineFizz(int number) {
        String result = testee.determineWord(number);

        assertEquals("Fizz", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 35})
    void shouldDetermineBuzz(int number) {
        String result = testee.determineWord(number);

        assertEquals("Buzz", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 90})
    void shouldDetermineFizzBuzz(int number) {
        String result = testee.determineWord(number);

        assertEquals("FizzBuzz", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 8, 41})
    void shouldDetermineNumber(int number) {
        String result = testee.determineWord(number);

        assertEquals(String.valueOf(number), result);
    }

    @ParameterizedTest
    @MethodSource("intRange")
    void shouldNotDetermineFizzBuzz(int number) {
        String result = testee.determineWord(number);

        assertNotEquals("FizzBuzz", result);
    }

    @ParameterizedTest
    @MethodSource("de.zettsystems.fizzbuzz.DataProvider#noFizzRange")
    void shouldNotDetermineFizz(int number) {
        String result = testee.determineWord(number);

        assertNotEquals("Fizz", result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/fizzbuzz.csv")
    void shouldUseCsv(int number, String expected) {
        String result = testee.determineWord(number);

        assertEquals(expected, result);
    }

    static IntStream intRange() {
        return IntStream.rangeClosed(1, 14);
    }
}