package de.zettsystems.netzfilm.movie.adapter;

import de.zettsystems.netzfilm.movie.application.MovieService;
import de.zettsystems.netzfilm.movie.values.MovieRequest;
import de.zettsystems.netzfilm.movie.values.ResponseMovie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieAdapter {
    private final MovieService movieService;

    public MovieAdapter(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/movies/")
    public ResponseEntity<String> createMovie(@RequestBody MovieRequest movie) {
        ResponseMovie newMovie = movieService.createMovie(movie.getTitle(), movie.getPublicationDate());
        return new ResponseEntity<>(newMovie.getMovieId(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/movies/")
    public List<ResponseMovie> listMovies() {
        return movieService.receiveAllMovies();
    }
}
