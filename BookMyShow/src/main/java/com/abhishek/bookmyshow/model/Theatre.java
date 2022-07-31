package com.abhishek.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@RequiredArgsConstructor
public class Theatre implements UniquelyIdentifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "theatreId", referencedColumnName = "id")
    private List<Screen> screens;
}
