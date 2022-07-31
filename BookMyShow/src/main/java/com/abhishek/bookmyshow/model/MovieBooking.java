package com.abhishek.bookmyshow.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MovieBooking implements UniquelyIdentifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "showId", referencedColumnName = "id")
    private MovieShow movieShow;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    private Integer ticketCount;
    private Double totalCost;
}
