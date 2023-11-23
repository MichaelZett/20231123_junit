package de.zettsystems.netzfilm.rent.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseRentTest {

    @Test
    void shouldHaveWorkingGettersAndConstructor() {
        ResponseRent testee = new ResponseRent("rentId", "customerId", "movieId");

        assertThat(testee.getRentId()).isEqualTo("rentId");
        assertThat(testee.getMovieId()).isEqualTo("movieId");
        assertThat(testee.getCustomerId()).isEqualTo("customerId");
    }
}