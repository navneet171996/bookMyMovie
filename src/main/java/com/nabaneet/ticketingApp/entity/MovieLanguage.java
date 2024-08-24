package com.nabaneet.ticketingApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nabaneet.ticketingApp.enums.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class MovieLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "language")
    private Language language;

    @ManyToMany(mappedBy = "languages")
    @JsonIgnore
    private List<Movie> movies;
}
