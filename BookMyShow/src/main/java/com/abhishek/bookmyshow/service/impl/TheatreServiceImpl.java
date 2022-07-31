package com.abhishek.bookmyshow.service.impl;

import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.model.Theatre;
import com.abhishek.bookmyshow.repository.MovieRepository;
import com.abhishek.bookmyshow.repository.TheatreRepository;
import com.abhishek.bookmyshow.service.AbstractService;
import com.abhishek.bookmyshow.service.TheatreService;
import org.springframework.stereotype.Service;


@Service
public class TheatreServiceImpl extends AbstractService<Theatre, TheatreRepository> implements TheatreService {

    public TheatreServiceImpl(TheatreRepository repository) {
        super(repository, Theatre.class);
    }

}
