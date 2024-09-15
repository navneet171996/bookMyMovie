package com.nabaneet.ticketingApp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddTheatreDTO {
    private String theatreName;
    private String theatreAddress;
    private Long cityId;

}
