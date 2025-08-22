package io.javaproject.movie_catalog_service.Model;

public class Movie {

    private Long movieId;
    private String name;
    private String description;
    private int year;
    private String genre;

    public Movie() {}

    public Movie(Long movieId, String name, String description, int year, String genre) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.year = year;
        this.genre = genre;
    }

    public Movie(Long movieId, String movieNotFound) {
    }

    // Getters and setters
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }


    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
