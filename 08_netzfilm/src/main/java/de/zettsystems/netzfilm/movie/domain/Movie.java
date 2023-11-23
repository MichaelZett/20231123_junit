package de.zettsystems.netzfilm.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long technicalKey;
    @Version
    private Long version;
    private String movieId;
    private String title;
    private LocalDate publicationDate;

    // needed for JPA
    Movie() {
        super();
    }

    public Movie(String title, LocalDate publicationDate) {
        this();
        this.title = title;
        this.publicationDate = publicationDate;
        this.movieId = UUID.randomUUID().toString();
    }

    public Long getTechnicalKey() {
        return technicalKey;
    }

    public Long getVersion() {
        return version;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void updateData(String title, LocalDate publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }
}
