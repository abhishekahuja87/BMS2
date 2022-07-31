package com.abhishek.bookmyshow.rest;

import com.abhishek.bookmyshow.dto.MovieShowDto;
import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.service.MovieService;
import com.abhishek.bookmyshow.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieShowResource {
    @Autowired
    private MovieShowService movieShowService;
    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/nowplaying")
    public ResponseEntity<List<Movie>> getNowPlaying(){
        return ResponseEntity.ok(movieService.getAllNowShowingMovies());
    }

    @PostMapping (value = "/add")
    public ResponseEntity<Movie> getAllBookings(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.save(movie));
    }

    @GetMapping(value = "/shows/{movieId}")
    public ResponseEntity<MovieShowDto> getAllScreens(@PathVariable("movieId") Long movieId){
        return ResponseEntity.ok(movieShowService.getShowsByMovie(movieId));
    }

}
