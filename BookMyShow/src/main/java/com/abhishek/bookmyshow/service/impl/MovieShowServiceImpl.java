package com.abhishek.bookmyshow.service.impl;

import com.abhishek.bookmyshow.dto.MovieDto;
import com.abhishek.bookmyshow.dto.MovieShowDto;
import com.abhishek.bookmyshow.dto.ScreenDto;
import com.abhishek.bookmyshow.dto.TheatreDto;
import com.abhishek.bookmyshow.model.Movie;
import com.abhishek.bookmyshow.model.MovieShow;
import com.abhishek.bookmyshow.model.Screen;
import com.abhishek.bookmyshow.model.Theatre;
import com.abhishek.bookmyshow.repository.MovieRepository;
import com.abhishek.bookmyshow.repository.MovieShowRepository;
import com.abhishek.bookmyshow.service.AbstractService;
import com.abhishek.bookmyshow.service.MovieBookingService;
import com.abhishek.bookmyshow.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieShowServiceImpl extends AbstractService<MovieShow, MovieShowRepository> implements MovieShowService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieBookingService movieBookingService;

    public MovieShowServiceImpl(MovieShowRepository repository) {
        super(repository, MovieShow.class);
    }

    @Override
    public MovieShowDto getShowsByMovie(Long movieId){
        MovieShowDto movieShowDto = new MovieShowDto();
        List<MovieShow> shows = repository.getShowsByMovie(movieId);
        // convert list of MovieShow to MovieShowDto
        if (!ListUtils.isEmpty(shows)){
            Optional<Movie> movie = movieRepository.findById(movieId);
            movieShowDto.setMovie(new MovieDto(movie.get().getId(), movie.get().getName()));
            movieShowDto.setShowDate(LocalDateTime.now());//TODO: get date from user
            List<TheatreDto> theatreDtos = new ArrayList<>();
            Map<Theatre,List<MovieShow>> mapShowsByTheatre = shows.stream().collect(Collectors.groupingBy(MovieShow::getTheatre));
            mapShowsByTheatre.keySet().forEach( theatre -> {
                List<MovieShow> showsByTheatre = mapShowsByTheatre.get(theatre);
                Map<Screen,List<MovieShow>> mapShowsByScreen = showsByTheatre.stream().collect(Collectors.groupingBy(MovieShow::getScreen));
                TheatreDto theatreDto = new TheatreDto().builder().theatreId(theatre.getId())
                        .theatreName(theatre.getName()).build();
                List<ScreenDto> screenDtos = new ArrayList<>();
                mapShowsByScreen.keySet().forEach( screen -> {
                    List<MovieShow> showsByScreen = mapShowsByScreen.get(screen);
                    List<LocalDateTime> dates = showsByScreen.stream()
                            .filter(s -> movieBookingService.getAvailableTicketCount(s) > 0)
                            .map(s -> s.getShowtime()).
                            collect(Collectors.toList());
                    ScreenDto screenDto = new ScreenDto().builder().screenId(screen.getId())
                            .screenName(screen.getName())
                            .ticketPrice(showsByScreen.get(0).getTicketPrice())
                            .showtimes(dates).build();
                    screenDtos.add(screenDto);
                });
                theatreDto.setScreens(screenDtos);
                theatreDtos.add(theatreDto);
            });
            movieShowDto.setTheatres(theatreDtos);
        }
        return movieShowDto;
    }
}
