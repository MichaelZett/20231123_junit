package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnabledOnOs(OS.WINDOWS)
class CalculatorTest {
    private Calculator testee = new Calculator();

    @Test
    void multiply() {
        assertEquals(12, testee.multiply(3, 4));
    }

    @Test
    void substract() {
        assertEquals(7, testee.substract(11, 4));
    }

    @Test
    void modulo() {
        assertEquals(7, testee.modulo(71, 8));
    }

    @Test
    void add() {
        assertEquals(7, testee.add(3, 4));
    }

    @Test
    void divide() {
        assertEquals(1.5, testee.divide(3, 2));
    }
}