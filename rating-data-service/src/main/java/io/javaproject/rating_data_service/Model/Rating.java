package io.javaproject.rating_data_service.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long ratingId;

    private Long movieId;

    private String rating;

    // Constructors
    public Rating() {}

    public Rating(Long movieId, String rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    // Getters & setters
    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
