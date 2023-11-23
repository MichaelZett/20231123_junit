package de.zettsystems.common;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("animal")
class AnimalTest {

    @Test
    void shouldBark() {
        Animal testee = new Animal("Bello", AnimalType.DOG);

        assertEquals("Wau", testee.talk());
    }

    @Test
    void shouldMiau() {
        Animal testee = new Animal("Clara", AnimalType.CAT);

        assertEquals("Miau", testee.talk());
    }
}