package assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {
    private List<String> testee;

    @BeforeEach
    void setup() {
        testee = new LinkedList<>();
    }

    @Test
    void shouldBeEmpty() {
        //Given + When
        final boolean result = testee.isEmpty();

        //Then
        assertTrue(result);
    }

    @Test
    void shouldAddElements() {
        //Given + When
        List<String> expected = Arrays.asList("A", "B");
        testee.add("A");
        testee.add("B");

        //Then
        assertEquals(2, testee.size());
        assertIterableEquals(expected, testee);
    }

    @Test
    void shouldRemoveElements() {
        //Given
        testee.add("A");
        testee.add("B");

        //When
        testee.remove("A");

        //Then
        assertEquals(1, testee.size());
        assertFalse(testee.contains("A"));
    }
}
