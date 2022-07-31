package com.abhishek.bookmyshow.service.impl;

import com.abhishek.bookmyshow.model.MovieBooking;
import com.abhishek.bookmyshow.model.MovieShow;
import com.abhishek.bookmyshow.repository.MovieBookingRepository;
import com.abhishek.bookmyshow.service.AbstractService;
import com.abhishek.bookmyshow.service.MovieBookingService;
import org.springframework.stereotype.Service;


@Service
public class MovieBookingServiceImpl extends AbstractService<MovieBooking, MovieBookingRepository> implements MovieBookingService {

    public MovieBookingServiceImpl(MovieBookingRepository repository) {
        super(repository, MovieBooking.class);
    }

    public Integer getAvailableTicketCount(MovieShow movieShow){
      return movieShow.getScreen().getCapacity() - movieShow.getBookings().stream().mapToInt(mb -> mb.getTicketCount()).sum();
    }
}
