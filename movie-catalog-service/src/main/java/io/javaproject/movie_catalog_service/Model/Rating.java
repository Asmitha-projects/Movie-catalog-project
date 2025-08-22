package io.javaproject.movie_catalog_service.Model;

public class Rating {

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
