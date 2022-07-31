package com.abhishek.bookmyshow.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@RequiredArgsConstructor
public class Screen implements UniquelyIdentifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int Capacity;
    @OneToMany
    @JoinColumn(name = "screenId")
    private List<MovieShow> shows;
    @ManyToOne
    @JoinColumn(name = "theatreId")
    private Theatre theatre;
}
