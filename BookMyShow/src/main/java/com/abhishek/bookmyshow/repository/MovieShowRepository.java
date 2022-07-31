package com.abhishek.bookmyshow.repository;

import com.abhishek.bookmyshow.model.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
    @Query(value = "SELECT ms.*  FROM movie_show ms where ms.movie_id = :movieId and ms.showtime > now()", nativeQuery = true)
    List<MovieShow> getShowsByMovie(@Param("movieId")Long movieId);
}
