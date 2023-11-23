package de.zettsystems.netzfilm.movie.adapter;

import de.zettsystems.netzfilm.movie.application.MovieService;
import de.zettsystems.netzfilm.movie.values.MovieRequest;
import de.zettsystems.netzfilm.movie.values.ResponseMovie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieAdapterTest {
    static final String TITLE = "Title";
    static final LocalDate SOME_DATE = LocalDate.of(2019, 11, 26);
    static final String MOVIE_ID = "ID";
    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieAdapter testee;

    @Test
    void createMovie() {
        final String filmtitel = "Filmtitel";
        final LocalDate publicationDate = LocalDate.of(2011, 7, 23);

        final MovieRequest movie = new MovieRequest();
        movie.setTitle(filmtitel);
        movie.setPublicationDate(publicationDate);

        ResponseMovie response = mock(ResponseMovie.class);
        when(response.getMovieId()).thenReturn("id");
        when(movieService.createMovie(filmtitel, publicationDate)).thenReturn(response);

        final ResponseEntity<String> result = testee.createMovie(movie);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody()).isEqualTo("id");
    }

    @Test
    void listMovies() {
        List<ResponseMovie> listMock = mock(List.class);
        when(movieService.receiveAllMovies()).thenReturn(listMock);

        final List<ResponseMovie> responseMovies = testee.listMovies();

        assertSame(listMock, responseMovies);
    }

    static ResponseMovie createResponseMovie() {
        return new ResponseMovie(SOME_DATE, TITLE, MOVIE_ID);
    }

    static MovieRequest createMovieRequest() {
        MovieRequest movie = new MovieRequest();
        movie.setPublicationDate(SOME_DATE);
        movie.setTitle(TITLE);
        return movie;
    }
}