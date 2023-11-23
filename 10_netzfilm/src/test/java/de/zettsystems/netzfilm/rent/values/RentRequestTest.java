package de.zettsystems.netzfilm.rent.values;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentRequestTest {

    @Test
    void shouldHaveWorkingGettersAndSetters() {
        RentRequest testee = new RentRequest();

        testee.setCustomerId("ID");
        assertEquals("ID", testee.getCustomerId());

        testee.setMovieId("ID2");
        assertEquals("ID2", testee.getMovieId());
    }

}