package io.javaproject.movie_catalog_service.Resource;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.javaproject.movie_catalog_service.Model.CatalogItem;
import io.javaproject.movie_catalog_service.Model.Movie;
import io.javaproject.movie_catalog_service.Model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "moviecatalog", fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") Long userId) {
//[{"name":"Avengers: Endgame","desc":"Superheroes team up to defeat Thanos.","rating":"5"},{"name":"Inception","desc":"A thief steals corporate secrets through dream-sharing technology.","rating":"4"},{"name":"Titanic","desc":"A romance blossoms aboard the ill-fated RMS Titanic.","rating":"5"}]
        // Fetch all ratings from rating-data-service
        Rating[] ratings = restTemplate.getForObject(
                "http://rating-data-service/ratings/all",
                Rating[].class
        );

        return Arrays.stream(ratings).map(rating -> {
            // Fetch movie details for each movie
            Movie movie = restTemplate.getForObject(
                    "http://movie-info-service/movies/" + rating.getMovieId(),
                    Movie.class
            );
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }

    public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") Long userId) {
        return Arrays.asList(new CatalogItem("No movie", "Service unavailable", "0"));
    }
}
