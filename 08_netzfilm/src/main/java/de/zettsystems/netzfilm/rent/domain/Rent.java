package de.zettsystems.netzfilm.rent.domain;

import de.zettsystems.netzfilm.customer.domain.Customer;
import de.zettsystems.netzfilm.movie.domain.Movie;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Rent {
    @Id
    @GeneratedValue
    private Long technicalKey;
    @Version
    private Long version;
    private String rentId;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Movie movie;

    Rent() {
        super();
    }

    public Rent(Customer customer, Movie movie) {
        this();
        this.customer = customer;
        this.movie = movie;
        this.rentId = UUID.randomUUID().toString();
    }

    public Long getTechnicalKey() {
        return technicalKey;
    }

    public Long getVersion() {
        return version;
    }

    public String getRentId() {
        return rentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }
}
