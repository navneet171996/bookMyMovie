package com.nabaneet.ticketingApp.entity;

import com.nabaneet.ticketingApp.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "seat_no")
    private String seatNo;

    @Column(name = "seat_type")
    private SeatType seatType;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "screen", referencedColumnName = "id")
    private Screen screen;
}
