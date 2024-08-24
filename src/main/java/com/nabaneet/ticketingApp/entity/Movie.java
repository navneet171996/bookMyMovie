package com.nabaneet.ticketingApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")
    private Double rating;

    @ManyToMany
    @JoinTable(name = "movie_language",
                joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id"))
    private Set<MovieLanguage> languages;

    @ManyToMany
    @JoinTable(name = "movie_format",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "format_id", referencedColumnName = "id"))
    private Set<MovieFormat> formats;

    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToMany
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(name = "movie_crew",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "crew_id", referencedColumnName = "id"))
    private List<Crew> crews;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<Review> reviews;

    @Column(name = "thumbnail_url")
    private String thumbnail;

    @Column(name = "trailer_url")
    private String trailer;

    @ManyToMany
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<MovieGenre> genres;
}
