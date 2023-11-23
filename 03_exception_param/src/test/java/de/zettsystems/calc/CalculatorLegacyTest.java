package de.zettsystems.calc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorLegacyTest {
    private Calculator testee;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        testee = new Calculator();
    }

    //expected(DoNotDivideByZero.class)
    @Test()
    public void divide() {
        expectedException.expect(DoNotDivideByZero.class);
        expectedException.expectMessage("Do not divide by zero");

        testee.divide(1, 0);

    }
}