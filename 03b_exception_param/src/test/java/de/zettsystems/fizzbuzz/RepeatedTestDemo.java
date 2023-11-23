package de.zettsystems.fizzbuzz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedTestDemo {
    private static FizzBuzzGame testee;

    @BeforeAll
    static void setup() {
        testee = new FizzBuzzGame();
    }

    @RepeatedTest(value = 3, name = "{currentRepetition} / {totalRepetitions}")
    void testFizz(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
        System.out.println(repetitionInfo.getTotalRepetitions());
        System.out.println(testInfo.getTestMethod());
        assertEquals("Fizz", testee.determineWord(3));
    }
}
