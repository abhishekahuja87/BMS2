package com.abhishek.bookmyshow.service.impl;

import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.repository.MovieRepository;
import com.abhishek.bookmyshow.service.AbstractService;
import com.abhishek.bookmyshow.service.MovieService;
import com.abhishek.bookmyshow.service.MovieShowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl extends AbstractService<Movie, MovieRepository> implements MovieService {

    public MovieServiceImpl(MovieRepository repository) {
        super(repository, Movie.class);
    }

    @Override
    public List<Movie> getAllNowShowingMovies() {
        return repository.getAllNowShowingMovies();
    }
}
