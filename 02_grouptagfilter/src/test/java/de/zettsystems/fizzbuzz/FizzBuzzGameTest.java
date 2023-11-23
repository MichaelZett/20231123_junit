package de.zettsystems.fizzbuzz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzGameTest {
    FizzBuzzGame testee = new FizzBuzzGame();

    @Test
    @Fizz
    @Order(4)
    void shouldSayFizzForMultipleOfThree(TestReporter testReporter) {
        String message = "Test 4 running...";
        testReporter.publishEntry(message);
        System.out.println(message);
        String result = testee.determineWord(3);

        assertEquals("Fizz", result);

        result = testee.determineWord(27);

        assertEquals("Fizz", result);
    }

    @Test
    @Buzz
    @Order(3)
    void shouldSayBuzzForMultipleOfFive(TestReporter testReporter) {
        String message = "Test 3 running...";
        testReporter.publishEntry(message);
        System.out.println(message);
        String result = testee.determineWord(5);

        assertEquals("Buzz", result);

        result = testee.determineWord(25);

        assertEquals("Buzz", result);
    }

    @Test
    @Fizz
    @Buzz
    @Order(2)
    void shouldSayFizzBuzzForMultipleOfFiveAndThree(TestReporter testReporter) {
        String message = "Test 2 running...";
        testReporter.publishEntry(message);
        System.out.println(message);
        String result = testee.determineWord(15);

        assertEquals("FizzBuzz", result);

        result = testee.determineWord(45);

        assertEquals("FizzBuzz", result);
    }


}
