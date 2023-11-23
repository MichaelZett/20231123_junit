package de.zettsystems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    void testIsNullOrEmpty() {
        assertTrue(StringHelper.isNullOrEmpty(null));
        assertTrue(StringHelper.isNullOrEmpty(""));
        assertFalse(StringHelper.isNullOrEmpty("text"));
    }

    @Test
    void testReverse() {
        assertEquals("cba", StringHelper.reverse("abc"));
        assertNull(StringHelper.reverse(null));
        assertEquals("", StringHelper.reverse(""));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringHelper.isPalindrome("radar"));
        assertFalse(StringHelper.isPalindrome("hello"));
        assertFalse(StringHelper.isPalindrome(null));
        assertTrue(StringHelper.isPalindrome(""));
    }
}