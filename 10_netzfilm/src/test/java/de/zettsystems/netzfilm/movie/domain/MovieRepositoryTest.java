package de.zettsystems.netzfilm.movie.domain;

import de.zettsystems.netzfilm.configuration.TestContainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // we don't want in memory DB
@Import(TestContainersConfiguration.class)
class MovieRepositoryTest {
    @Autowired
    private MovieRepository testee;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findByMovieId() {
        // Given
        Movie movie = new Movie("Film", LocalDate.now());
        Movie persisted = testEntityManager.persist(movie);

        // When
        Optional<Movie> found = testee.findByMovieId(persisted.getMovieId());

        // Then
        assertThat(found).isPresent();
        assertThat(found.get()).isEqualTo(persisted);
    }
}
