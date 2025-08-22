package io.javaproject.rating_data_service.Resources;

import io.javaproject.rating_data_service.Model.Rating;
import io.javaproject.rating_data_service.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/{movieId}")
    public List<Rating> getRatingsByMovie(@PathVariable("movieId") Long movieId) {
        return ratingRepository.findByMovieId(movieId);
    }

    @GetMapping("/all")
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
