package com.nabaneet.ticketingApp.dto;

import com.nabaneet.ticketingApp.enums.SeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatTypeDto {
    private SeatType seatType;
    private Integer noOfSeats;
}
