package com.abhishek.bookmyshow.service;

import com.abhishek.bookmyshow.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieService extends BaseService<Movie> {
    // Find movies playing in theatres within a date range
    List<Movie> getAllNowShowingMovies();

}
