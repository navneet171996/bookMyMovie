package com.nabaneet.ticketingApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nabaneet.ticketingApp.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private Long firstName;

    @Column(name = "middle_name")
    private Long middleName;

    @Column(name = "last_name")
    private Long lastName;

    @Column(name = "gender")
    private Gender gender;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private List<Movie> movies;
}
