package com.abhishek.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@ToString
@RequiredArgsConstructor
public class MovieShow implements UniquelyIdentifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "screenId", referencedColumnName = "id")
    @JsonIgnore
    Screen screen;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime showtime;
    @OneToOne
    @JoinColumn(name = "movieId", referencedColumnName = "id")
    private Movie movie;
    private Double ticketPrice;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "showId", referencedColumnName = "id")
    private List<MovieBooking> bookings;

    public Theatre getTheatre(){ // For grouping Show by Theatre
        if(this.screen != null){
            return screen.getTheatre();
        } else return null;
    }
}
