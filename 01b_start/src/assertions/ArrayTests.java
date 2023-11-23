package assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayTests {

    @Test
    void shouldBeSameArrays() {
        int[] arrayOne = new int[]{1, 2, 3};
        int[] arrayTwo = new int[]{1, 2, 3};

        assertArrayEquals(arrayOne, arrayTwo,
                "Arrays nicht gleich (immer erzeugt)");

        assertArrayEquals(arrayOne, arrayTwo,
                () -> "Arrays nicht gleich (nur wenn gebraucht erzeugt)");
    }
}
