package date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YearHelperTest {

    @Test
    void _2024ShouldBeSchaltjahr() {
        assertTrue(YearHelper.isSchaltjahr(2024));
    }

    @Test
    void _2023ShouldNotBeSchaltjahr() {
        assertFalse(YearHelper.isSchaltjahr(2023));
    }

    @Test
    void _2100ShouldNotBeSchaltjahr() {
        assertFalse(YearHelper.isSchaltjahr(2100));
    }

    @Test
    void _2000ShouldBeSchaltjahr() {
        assertTrue(YearHelper.isSchaltjahr(2000));
    }
}
