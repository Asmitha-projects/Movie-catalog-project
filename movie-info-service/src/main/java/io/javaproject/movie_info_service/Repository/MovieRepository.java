package io.javaproject.movie_info_service.Repository;

import io.javaproject.movie_info_service.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
