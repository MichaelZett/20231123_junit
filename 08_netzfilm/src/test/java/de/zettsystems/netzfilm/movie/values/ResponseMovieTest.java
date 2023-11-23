package de.zettsystems.netzfilm.movie.values;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseMovieTest {

    @Test
    void shouldHaveWorkingGetters() {
        // Given
        final LocalDate publicationDate = LocalDate.of(2011, 7, 23);
        final String filmtitel = "Filmtitel";
        final String movieId = "movieId";

        ResponseMovie testee = new ResponseMovie(publicationDate, filmtitel, movieId);

        //When + Then
        assertThat(testee.getPublicationDate()).isEqualTo(publicationDate);
        assertThat(testee.getTitle()).isEqualTo(filmtitel);
        assertThat(testee.getMovieId()).isEqualTo(movieId);
        assertThat(testee.getMovieId()).isNotEmpty();

    }

}