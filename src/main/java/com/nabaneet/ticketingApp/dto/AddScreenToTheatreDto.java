package com.nabaneet.ticketingApp.dto;

import com.nabaneet.ticketingApp.enums.SeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddScreenToTheatreDto {
    private String screenName;
    private Long theatreId;
    private List<SeatTypeDto> seatTypes;
    private Integer seatsInOneRow;
}
