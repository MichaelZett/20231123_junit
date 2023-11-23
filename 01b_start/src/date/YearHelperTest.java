package date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests for YearHelper.") // Ändern des Namens der Suite, default: Klassenname
class YearHelperTest {

    @DisplayName("2021 should not be a leap year.") // Ändern des Namens des Tests, default: Methodenname
    @Test
        // Die annotierte Methode ist ein Test
    void _2021ShouldNotBeSchaltjahr() {
        assertFalse(YearHelper.isSchaltjahr(2021));
    }

    @Test
    void _1900ShouldNotBeSchaltjahr() {
        assertFalse(YearHelper.isSchaltjahr(1900));
    }

    @Test
    void _1896ShouldBeSchaltjahr() {
        assertTrue(YearHelper.isSchaltjahr(1896));
    }

    @Test
    void _2020ShouldBeSchaltjahr() {
        assertTrue(YearHelper.isSchaltjahr(2020));
    }

    @DisplayName("2000 should be a leap year.")
    @Test
    void _2000ShouldBeSchaltjahr() {
        assertTrue(YearHelper.isSchaltjahr(2000));
    }
}
