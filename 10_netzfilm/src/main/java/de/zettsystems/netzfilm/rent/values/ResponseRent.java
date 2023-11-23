package de.zettsystems.netzfilm.rent.values;

public class ResponseRent {
    private final String rentId;
    private final String customerId;
    private final String movieId;

    public ResponseRent(String rentId, String customerId, String movieId) {
        super();
        this.rentId = rentId;
        this.customerId = customerId;
        this.movieId = movieId;
    }

    public String getRentId() {
        return rentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMovieId() {
        return movieId;
    }
}
