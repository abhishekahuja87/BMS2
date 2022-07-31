package com.abhishek.bookmyshow.service;

import com.abhishek.bookmyshow.dto.MovieShowDto;
import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.model.MovieShow;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieShowService extends BaseService<MovieShow> {
    // Find movies playing in theatres within a date range
    MovieShowDto getShowsByMovie(Long movieId);

}
