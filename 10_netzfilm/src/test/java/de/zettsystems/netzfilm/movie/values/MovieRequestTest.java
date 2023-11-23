package de.zettsystems.netzfilm.movie.values;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieRequestTest {

    @Test
    void shouldHaveWorkingGettersAndSetters() {
        MovieRequest testee = new MovieRequest();

        LocalDate someDate = LocalDate.of(2019, 11, 26);
        testee.setPublicationDate(someDate);
        assertEquals(someDate, testee.getPublicationDate());
        testee.setTitle("Title");
        assertEquals("Title", testee.getTitle());
    }
}