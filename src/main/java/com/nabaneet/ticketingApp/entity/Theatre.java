package com.nabaneet.ticketingApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String Address; // Change address to a new class later

    @OneToMany(mappedBy = "theatre")
    private Set<Screen> screens;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
}
