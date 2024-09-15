package com.nabaneet.ticketingApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;

    @OneToMany(mappedBy = "screen")
    private Set<Slot> slots;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}
