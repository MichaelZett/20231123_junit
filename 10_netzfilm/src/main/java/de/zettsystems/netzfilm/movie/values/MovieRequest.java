package de.zettsystems.netzfilm.movie.values;

import java.time.LocalDate;

public class MovieRequest {
    private LocalDate publicationDate;
    private String title;

    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
