package com.abhishek.bookmyshow.repository;


import com.abhishek.bookmyshow.model.MovieBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieBookingRepository extends JpaRepository<MovieBooking, Long> {

}
