package com.nabaneet.ticketingApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nabaneet.ticketingApp.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class MovieGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genre")
    private Genre genre;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private Set<Movie> movies;
}
