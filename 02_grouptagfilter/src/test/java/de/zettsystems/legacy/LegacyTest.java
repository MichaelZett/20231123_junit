package de.zettsystems.legacy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LegacyTest {
    List<String> testee;

    @Before
    public void setup() {
        testee = new ArrayList<>();
    }

    @Test
    public void shouldAdd() {
        testee.add("A");

        assertTrue(testee.contains("A"));
    }
}
