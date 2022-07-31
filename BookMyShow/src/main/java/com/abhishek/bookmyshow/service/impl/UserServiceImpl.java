package com.abhishek.bookmyshow.service.impl;

import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.model.Theatre;
import com.abhishek.bookmyshow.model.User;
import com.abhishek.bookmyshow.repository.TheatreRepository;
import com.abhishek.bookmyshow.repository.UserRepository;
import com.abhishek.bookmyshow.service.AbstractService;
import com.abhishek.bookmyshow.service.TheatreService;
import com.abhishek.bookmyshow.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends AbstractService<User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository, User.class);
    }

    public User getByMobileNumber(String mobile){
        return repository.getByMobileNumber(mobile);
    }

}
