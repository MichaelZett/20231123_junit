package de.zettsystems.calc;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator testee;

    @BeforeEach
    void setUp() {
        testee = new Calculator();
    }

    @Test
    void shouldDivide() {
        final DoNotDivideByZero result = assertThrows(DoNotDivideByZero.class, () -> testee.divide(1, 0));

        assertEquals("Do not divide by zero", result.getMessage());
    }


}