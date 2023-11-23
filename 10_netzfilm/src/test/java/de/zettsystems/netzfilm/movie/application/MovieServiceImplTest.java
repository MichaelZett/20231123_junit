package de.zettsystems.netzfilm.movie.application;

import de.zettsystems.netzfilm.movie.domain.Movie;
import de.zettsystems.netzfilm.movie.domain.MovieRepository;
import de.zettsystems.netzfilm.movie.values.ResponseMovie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl testee;

    @Test
    void createMovie() {
        final String filmtitel = "Filmtitel";
        final LocalDate publicationDate = LocalDate.of(2011, 7, 23);

        when(movieRepository.save(any(Movie.class))).then(AdditionalAnswers.returnsFirstArg());

        final ResponseMovie result = testee.createMovie(filmtitel, publicationDate);

        assertThat(result.getPublicationDate()).isEqualTo(publicationDate);
        assertThat(result.getTitle()).isEqualTo(filmtitel);
    }

    @Test
    void receiveAllMovies() {
        final String filmtitel1 = "Filmtitel";
        final LocalDate publicationDate1 = LocalDate.of(2011, 7, 23);
        final Movie movie1 = new Movie(filmtitel1, publicationDate1);
        final String filmtitel2 = "Filmtitel2";
        final LocalDate publicationDate2 = LocalDate.of(2011, 7, 24);
        final Movie movie2 = new Movie(filmtitel2, publicationDate2);

        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));

        final List<ResponseMovie> result = testee.receiveAllMovies();

        assertThat(result).isNotEmpty().hasSize(2);
        final ResponseMovie responseMovie1 = new ResponseMovie(publicationDate1, filmtitel1, movie1.getMovieId());
        final ResponseMovie responseMovie2 = new ResponseMovie(publicationDate2, filmtitel2, movie2.getMovieId());

        assertThat(result).containsExactly(responseMovie1, responseMovie2);
    }
}