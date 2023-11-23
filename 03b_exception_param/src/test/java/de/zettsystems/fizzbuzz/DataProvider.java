package de.zettsystems.fizzbuzz;

import java.util.stream.IntStream;

public class DataProvider {

    static IntStream noFizzRange() {
        return IntStream.rangeClosed(1, 14).filter(p -> p % 3 != 0);
    }
}
