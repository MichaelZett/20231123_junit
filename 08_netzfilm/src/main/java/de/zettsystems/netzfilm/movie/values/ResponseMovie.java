package de.zettsystems.netzfilm.movie.values;

import java.time.LocalDate;
import java.util.Objects;

public class ResponseMovie {

    private final LocalDate publicationDate;
    private final String title;
    private final String movieId;

    public ResponseMovie(LocalDate publicationDate, String title, String movieId) {
        super();
        this.publicationDate = publicationDate;
        this.title = title;
        this.movieId = movieId;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getMovieId() {
        return movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseMovie that = (ResponseMovie) o;
        return movieId.equals(that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }
}
