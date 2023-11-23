package fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzGameTest {
    FizzBuzzGame testee = new FizzBuzzGame();

    @Test
    void shouldSayFizz() {
        assertEquals("Fizz", testee.doOneNumber(3));
    }

}
