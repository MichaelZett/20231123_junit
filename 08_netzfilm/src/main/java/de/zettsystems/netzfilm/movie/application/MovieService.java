package de.zettsystems.netzfilm.movie.application;

import de.zettsystems.netzfilm.movie.values.ResponseMovie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    ResponseMovie createMovie(String title, LocalDate publicationDate);

    List<ResponseMovie> receiveAllMovies();
}
