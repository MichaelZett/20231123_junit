package de.zettsystems.calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

//@Execution(ExecutionMode.SAME_THREAD)
class CalculatorTest {
    private Calculator testee;

    @BeforeEach
    void setUp() {
        testee = new Calculator();
    }


    @Test
    void shouldNotTimeout() {
        System.out.printf("Calculator Test %s%n", Thread.currentThread().getName());
        assertTimeout(Duration.ofSeconds(8), () -> testee.nextPrime());
    }


   @Test
    void secondTest() {
        System.out.printf("2nd Calculator Test %s%n", Thread.currentThread().getName());
        assertTimeout(Duration.ofSeconds(8), () -> testee.nextPrime());
    }

    // @Test(timeout = 8000) - JUnit 4 style
    @Timeout(value = 8)
    @Test
    void thirdTest() {
        System.out.printf("3rd Calculator Test %s%n", Thread.currentThread().getName());
        assertEquals(Long.MAX_VALUE, testee.nextPrime());
    }
}