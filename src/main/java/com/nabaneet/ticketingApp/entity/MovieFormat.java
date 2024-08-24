package com.nabaneet.ticketingApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nabaneet.ticketingApp.enums.Format;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "formats")
public class MovieFormat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "format")
    private Format format;

    @ManyToMany(mappedBy = "formats")
    @JsonIgnore
    private Set<Movie> movies;
}
