package de.zettsystems.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
class FizzBuzzGameTest {
    FizzBuzzGame testee;

    @BeforeEach
    void setup() {
        testee = new FizzBuzzGame();
    }

    @Test
    void shouldReturnFizzForThree() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000L);
        assertEquals("Fizz", testee.determineWord(3));
    }

    @Test
    void shouldReturnBuzzForFive() {
        System.out.println(Thread.currentThread().getName());
        assertEquals("Buzz", testee.determineWord(5));
    }

    @Test
    void shouldReturnFizzBuzzForthirty() {
        System.out.println(Thread.currentThread().getName());
        assertEquals("FizzBuzz", testee.determineWord(30));
    }

    @Test
    void shouldReturnOneForOne() {
        System.out.println(Thread.currentThread().getName());
        assertEquals("1", testee.determineWord(1));
    }

}
