package io.javaproject.movie_info_service.Resources;

import io.javaproject.movie_info_service.Model.Movie;
import io.javaproject.movie_info_service.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        return movie.orElse(new Movie(movieId, "Movie not found"));
    }

    // Extra endpoint to check if DB is working
    @GetMapping("/all")
    public java.util.List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
