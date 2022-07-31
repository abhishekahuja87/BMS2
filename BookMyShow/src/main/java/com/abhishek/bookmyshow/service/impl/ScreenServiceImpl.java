package com.abhishek.bookmyshow.service.impl;

import com.abhishek.bookmyshow.model.Screen;
import com.abhishek.bookmyshow.model.Theatre;
import com.abhishek.bookmyshow.repository.ScreenRepository;
import com.abhishek.bookmyshow.repository.TheatreRepository;
import com.abhishek.bookmyshow.service.AbstractService;
import com.abhishek.bookmyshow.service.ScreenService;
import com.abhishek.bookmyshow.service.TheatreService;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImpl extends AbstractService<Screen, ScreenRepository> implements ScreenService {

    public ScreenServiceImpl(ScreenRepository repository) {
        super(repository, Screen.class);
    }

}
