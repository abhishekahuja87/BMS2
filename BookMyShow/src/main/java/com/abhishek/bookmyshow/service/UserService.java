package com.abhishek.bookmyshow.service;

import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.model.Theatre;
import com.abhishek.bookmyshow.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService extends BaseService<User> {
    User getByMobileNumber(String mobile);
}
