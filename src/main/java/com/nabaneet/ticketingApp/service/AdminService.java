package com.nabaneet.ticketingApp.service;

import com.nabaneet.ticketingApp.dto.AddScreenToTheatreDto;
import com.nabaneet.ticketingApp.dto.AddTheatreDTO;
import com.nabaneet.ticketingApp.entity.City;
import com.nabaneet.ticketingApp.entity.Theatre;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    City addCity(String cityName);
    Theatre addTheatre(AddTheatreDTO addTheatreDTO) throws Exception;

    Long addScreenToTheatre(AddScreenToTheatreDto addScreenToTheatreDto);

}
