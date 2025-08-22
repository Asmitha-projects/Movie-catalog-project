package io.javaproject.rating_data_service.Repository;

import io.javaproject.rating_data_service.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findByMovieId(Long movieId);
}
