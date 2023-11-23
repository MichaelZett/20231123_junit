package de.zettsystems.parameter;

import de.zettsystems.alchemie.Alchemist;
import de.zettsystems.alchemie.Gold;
import de.zettsystems.alchemie.Rohstoff;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTests {
    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertNull(input);
    }

    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
        assertTrue(input.isBlank());
    }

    @ParameterizedTest
    @EnumSource(Month.class) // passing all 12 months
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, input.isBlank());
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource("rohstoffToGoldDataProvider")
    void testConvertToGold(Rohstoff input, Gold expected) {
        Gold actual = new Alchemist().convertToGold(input);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> rohstoffToGoldDataProvider() {
        return Stream.of(
                Arguments.of(new Rohstoff(7, "Eisen"), new Gold(7)),
                Arguments.of(new Rohstoff(13, "Glas"), new Gold(13))
        );
    }

}
