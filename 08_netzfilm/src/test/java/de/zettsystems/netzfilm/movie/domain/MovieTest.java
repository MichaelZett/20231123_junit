package de.zettsystems.netzfilm.movie.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {

    @Test
    void shouldHaveWorkingGetters() {
        // Given
        final LocalDate publicationDate = LocalDate.of(2011, 7, 23);
        final String filmtitel = "Filmtitel";

        Movie testee = new Movie(filmtitel, publicationDate);

        //When + Then
        assertThat(testee.getPublicationDate()).isEqualTo(publicationDate);
        assertThat(testee.getTitle()).isEqualTo(filmtitel);
    }

    @Test
    void shouldUpdate() {
        final LocalDate publicationDate = LocalDate.of(2011, 7, 23);
        final String filmtitel = "Filmtitel";

        Movie testee = new Movie(filmtitel, publicationDate);

        final LocalDate newPublicationDate = LocalDate.of(2021, 7, 23);
        final String neuerFilmtitel = "Neuer Filmtitel";
        testee.updateData(neuerFilmtitel, newPublicationDate);

        //When + Then
        assertThat(testee.getPublicationDate()).isEqualTo(newPublicationDate);
        assertThat(testee.getTitle()).isEqualTo(neuerFilmtitel);
    }

}