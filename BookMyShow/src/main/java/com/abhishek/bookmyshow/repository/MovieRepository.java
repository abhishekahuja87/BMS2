package com.abhishek.bookmyshow.repository;

import com.abhishek.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT distinct m.id, m.name  FROM movie_show ms left join movie m on movie_id = m.id where ms.showtime > now()", nativeQuery = true)
    List<Movie> getAllNowShowingMovies();
}
