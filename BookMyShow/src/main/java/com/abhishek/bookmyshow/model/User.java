package com.abhishek.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User implements UniquelyIdentifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(nullable = false, unique = true)
    private String mobile;
    @OneToMany
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonIgnore
    private List<MovieBooking> bookings;
}
