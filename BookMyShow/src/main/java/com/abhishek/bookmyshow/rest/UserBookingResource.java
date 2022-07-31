package com.abhishek.bookmyshow.rest;


import com.abhishek.bookmyshow.model.MovieBooking;
import com.abhishek.bookmyshow.model.MovieShow;
import com.abhishek.bookmyshow.model.User;
import com.abhishek.bookmyshow.service.MovieBookingService;
import com.abhishek.bookmyshow.service.MovieShowService;
import com.abhishek.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserBookingResource {
    @Autowired
    private UserService userService;
    @Autowired
    private MovieShowService movieShowService;
    @Autowired
    private MovieBookingService movieBookingService;

    @PostMapping(value = "/add")
    public ResponseEntity<User> bookTicket(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping(value = "/{userMobile}/bookings")
    public ResponseEntity<List<MovieBooking>> getAllBookings(@PathVariable("userMobile") String userMobile){
        User user = userService.getByMobileNumber(userMobile);
        if (user != null) {
            return ResponseEntity.ok(user.getBookings());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/{userMobile}/show/{showId}/book/{ticketCount}")
    public ResponseEntity<MovieBooking> bookTicket(@PathVariable("userMobile") String userMobile,
                                                  @PathVariable("showId") Long showId,
                                                  @PathVariable("ticketCount")Integer ticketCount){
        User user = userService.getByMobileNumber(userMobile);
        MovieShow movieShow = movieShowService.getById(showId);
        if (movieShow != null) {
            if (movieBookingService.getAvailableTicketCount(movieShow) - ticketCount < 0){
                return ResponseEntity.badRequest().build();
            }
            if (user == null){
                user= new User();
                user.setMobile(userMobile);
                userService.save(user);
            }
            MovieBooking movieBooking = new MovieBooking();
            movieBooking.setUser(user);
            movieBooking.setMovieShow(movieShow);
            movieBooking.setTicketCount(ticketCount);
            movieBooking.setTotalCost(movieShow.getTicketPrice() * ticketCount);
            return ResponseEntity.ok(movieBookingService.save(movieBooking));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}