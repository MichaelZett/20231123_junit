package de.zettsystems.netzfilm.movie.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create", "spring.datasource.url=jdbc:h2:mem:testdb"
})
class MovieRepositoryTest {
    @Autowired
    private MovieRepository testee;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findByMovieId() {
        // Given
        Movie movie = new Movie("Film", LocalDate.now());
        Movie persisted = testEntityManager.persistAndFlush(movie);

        // When
        Optional<Movie> found = testee.findByMovieId(persisted.getMovieId());

        // Then
        assertThat(found).isPresent();
        assertThat(found.get()).isEqualTo(persisted);
    }
}
