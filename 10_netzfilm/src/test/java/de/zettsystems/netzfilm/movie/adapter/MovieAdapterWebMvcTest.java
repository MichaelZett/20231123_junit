package de.zettsystems.netzfilm.movie.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.zettsystems.netzfilm.movie.application.MovieService;
import de.zettsystems.netzfilm.movie.values.MovieRequest;
import de.zettsystems.netzfilm.movie.values.ResponseMovie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MovieAdapter.class)
class MovieAdapterWebMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MovieService movieService;

    @Test
    void whenValidInput_thenReturns201() throws Exception {
        // Given
        MovieRequest requestMovie = MovieAdapterTest.createMovieRequest();
        ResponseMovie responseMovie = MovieAdapterTest.createResponseMovie();
        when(movieService.createMovie(MovieAdapterTest.TITLE, MovieAdapterTest.SOME_DATE)).thenReturn(responseMovie);

        //When
        mockMvc.perform(post("/movies/")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestMovie)))
                // Then
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(MovieAdapterTest.MOVIE_ID)));
    }

}