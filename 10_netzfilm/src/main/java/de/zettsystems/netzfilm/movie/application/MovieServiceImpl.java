package de.zettsystems.netzfilm.movie.application;

import de.zettsystems.netzfilm.movie.domain.Movie;
import de.zettsystems.netzfilm.movie.domain.MovieRepository;
import de.zettsystems.netzfilm.movie.values.ResponseMovie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public ResponseMovie createMovie(String title, LocalDate publicationDate) {
        final Movie movie = movieRepository.save(new Movie(title, publicationDate));
        return createResponseFromMovie(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseMovie> receiveAllMovies() {
        return movieRepository.findAll().stream().map(this::createResponseFromMovie).collect(Collectors.toList());
    }

    private ResponseMovie createResponseFromMovie(Movie movie) {
        return new ResponseMovie(movie.getPublicationDate(), movie.getTitle(), movie.getMovieId());
    }
}
