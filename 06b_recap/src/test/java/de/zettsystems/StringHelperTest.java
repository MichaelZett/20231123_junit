package de.zettsystems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringHelperTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/isNullOrEmpty.csv", numLinesToSkip = 1)
    void testIsNullOrEmpty(String input, boolean expected) {
        assertEquals(expected, StringHelper.isNullOrEmpty(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/reverse.csv", numLinesToSkip = 1)
    void testReverse(String input, String expected) {
        assertEquals(expected, StringHelper.reverse(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv", numLinesToSkip = 1)
    void testIsPalindrome(String input, boolean expected) {
        assertEquals(expected, StringHelper.isPalindrome(input));
    }
}