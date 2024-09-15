package com.nabaneet.ticketingApp.controller;

import com.nabaneet.ticketingApp.dto.AddScreenToTheatreDto;
import com.nabaneet.ticketingApp.dto.AddTheatreDTO;
import com.nabaneet.ticketingApp.entity.Theatre;
import com.nabaneet.ticketingApp.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path = "/addCity/{cityName}")
    public ResponseEntity<?> addCity(@PathVariable String cityName){
        return new ResponseEntity<>(adminService.addCity(cityName), HttpStatus.OK);
    }

    @PostMapping(path = "/addTheatre")
    public ResponseEntity<?> addTheatre(@RequestBody AddTheatreDTO addTheatreDTO){
        try{
            Theatre theatre = adminService.addTheatre(addTheatreDTO);
            return new ResponseEntity<>(theatre, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An unexpected error occurred");
        }

    }

    @PostMapping(path = "/addScreenToTheatre")
    public ResponseEntity<Long> addScreenToTheatre(@RequestBody AddScreenToTheatreDto addScreenToTheatreDto){
        try{
            Long screenId = adminService.addScreenToTheatre(addScreenToTheatreDto);
            return new ResponseEntity<>(screenId, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
