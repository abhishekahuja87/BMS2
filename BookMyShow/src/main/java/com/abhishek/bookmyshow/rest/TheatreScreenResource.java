package com.abhishek.bookmyshow.rest;

import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.model.MovieShow;
import com.abhishek.bookmyshow.model.Screen;
import com.abhishek.bookmyshow.model.Theatre;
import com.abhishek.bookmyshow.service.MovieService;
import com.abhishek.bookmyshow.service.MovieShowService;
import com.abhishek.bookmyshow.service.ScreenService;
import com.abhishek.bookmyshow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
@CrossOrigin(origins = "http://localhost:3000")
public class TheatreScreenResource {
    @Autowired
    TheatreService theatreService;
    @Autowired
    ScreenService screenService;
    @Autowired
    MovieShowService movieShowService;
    @Autowired
    MovieService movieService;

    @PostMapping(value = "/add")
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre){
        return ResponseEntity.ok(theatreService.save(theatre));
    }

    @GetMapping(value = "/{theatreId}/screen")
    public ResponseEntity<List<Screen>> getScreens(@PathVariable("theatreId") Long theatreId){
        Theatre theatre = theatreService.getById(theatreId);
        if (theatre != null) {
            return ResponseEntity.ok(theatre.getScreens());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping(value = "/{theatreId}/screen/add")
    public ResponseEntity<Screen> addScreen(@PathVariable("theatreId") Long theatreId, @RequestBody Screen screen){
        Theatre theatre = theatreService.getById(theatreId);
        if (theatre != null) {
            screen.setTheatre(theatre);
            return ResponseEntity.ok(screenService.save(screen));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/screen/{screenId}/movie/{movieId}/add")
    public ResponseEntity<MovieShow> addMovieShow(@PathVariable("screenId") Long screenId,
                                                  @PathVariable("movieId") Long movieId,
                                                  @RequestBody MovieShow movieShow){
        Screen screen = screenService.getById(screenId);
        Movie movie = movieService.getById(movieId);
        if (movie != null && screen != null) {
            movieShow.setMovie(movie);
            movieShow.setScreen(screen);
            return ResponseEntity.ok(movieShowService.save(movieShow));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
