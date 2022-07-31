package com.abhishek.bookmyshow.service;

import com.abhishek.bookmyshow.model.MovieBooking;
import com.abhishek.bookmyshow.model.MovieShow;

public interface MovieBookingService extends BaseService<MovieBooking> {
   Integer getAvailableTicketCount(MovieShow movieShow);
}
