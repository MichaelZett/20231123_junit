package de.zettsystems.netzfilm.rent.application;

import de.zettsystems.netzfilm.customer.domain.Customer;
import de.zettsystems.netzfilm.customer.domain.CustomerRepository;
import de.zettsystems.netzfilm.movie.domain.Movie;
import de.zettsystems.netzfilm.movie.domain.MovieRepository;
import de.zettsystems.netzfilm.rent.domain.Rent;
import de.zettsystems.netzfilm.rent.domain.RentRepository;
import de.zettsystems.netzfilm.rent.values.ResponseRent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RentServiceImplTest {
    private static final String MOVIE_ID = "movieId";
    private static final String CUSTOMER_ID = "customerId";
    @Mock
    private RentRepository rentRepository;
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private RentServiceImpl testee;

    @Test
    void shouldCreateRent() {
        Movie movie = mock(Movie.class);
        when(movie.getMovieId()).thenReturn(MOVIE_ID);

        Customer customer = mock(Customer.class);
        when(customer.getCustomerId()).thenReturn(CUSTOMER_ID);

        doReturn(Optional.of(movie)).when(movieRepository).findByMovieId(MOVIE_ID);
        doReturn(Optional.of(customer)).when(customerRepository).findByCustomerId(CUSTOMER_ID);
        when(rentRepository.save(any(Rent.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());

        ResponseRent result = testee.createRent(MOVIE_ID, CUSTOMER_ID);

        verify(rentRepository).save(any(Rent.class));

        assertThat(result.getRentId()).isNotNull();
        assertThat(result.getMovieId()).isEqualTo(MOVIE_ID);
        assertThat(result.getCustomerId()).isEqualTo(CUSTOMER_ID);
    }

    @Test
    void shouldThrowExceptionForWrongCustomerId() {
        Movie movie = mock(Movie.class);
        doReturn(Optional.of(movie)).when(movieRepository).findByMovieId(MOVIE_ID);

        assertThrows(IllegalArgumentException.class,
                () -> testee.createRent(MOVIE_ID, CUSTOMER_ID));

    }

    @Test
    void shouldThrowExceptionForWrongMovieId() {
        assertThrows(IllegalArgumentException.class,
                () -> testee.createRent(MOVIE_ID, CUSTOMER_ID));
    }

    @Test
    void shouldReturnAllRents() {
        Movie movie = mock(Movie.class);
        when(movie.getMovieId()).thenReturn(MOVIE_ID);

        Customer customer = mock(Customer.class);
        when(customer.getCustomerId()).thenReturn(CUSTOMER_ID);

        when(rentRepository.findAll()).thenReturn(Arrays.asList(new Rent(customer, movie)));

        List<ResponseRent> responseRents = testee.receiveAllRents();

        ResponseRent result = responseRents.get(0);

        assertThat(result.getRentId()).isNotNull();
        assertThat(result.getMovieId()).isEqualTo(MOVIE_ID);
        assertThat(result.getCustomerId()).isEqualTo(CUSTOMER_ID);
    }
}