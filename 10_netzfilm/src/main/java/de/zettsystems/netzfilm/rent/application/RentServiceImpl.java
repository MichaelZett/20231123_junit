package de.zettsystems.netzfilm.rent.application;

import de.zettsystems.netzfilm.customer.domain.Customer;
import de.zettsystems.netzfilm.customer.domain.CustomerRepository;
import de.zettsystems.netzfilm.movie.domain.Movie;
import de.zettsystems.netzfilm.movie.domain.MovieRepository;
import de.zettsystems.netzfilm.rent.domain.Rent;
import de.zettsystems.netzfilm.rent.domain.RentRepository;
import de.zettsystems.netzfilm.rent.values.ResponseRent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;

    public RentServiceImpl(RentRepository rentRepository, MovieRepository movieRepository,
                           CustomerRepository customerRepository) {
        this.rentRepository = rentRepository;
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseRent createRent(String movieId, String customerId) {
        Movie movie = movieRepository.findByMovieId(movieId).orElseThrow(IllegalArgumentException::new);
        Customer customer = customerRepository.findByCustomerId(customerId).orElseThrow(IllegalArgumentException::new);

        final Rent rent = rentRepository.save(new Rent(customer, movie));
        return createResponseFromRent(rent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseRent> receiveAllRents() {
        return rentRepository.findAll().stream().map(RentServiceImpl::createResponseFromRent).collect(Collectors.toList());
    }

    private static ResponseRent createResponseFromRent(Rent rent) {
        return new ResponseRent(rent.getRentId(), rent.getCustomer().getCustomerId(), rent.getMovie().getMovieId());
    }

}
