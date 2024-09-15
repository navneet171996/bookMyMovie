package com.nabaneet.ticketingApp.service.impl;

import com.nabaneet.ticketingApp.dto.AddScreenToTheatreDto;
import com.nabaneet.ticketingApp.dto.AddTheatreDTO;
import com.nabaneet.ticketingApp.entity.City;
import com.nabaneet.ticketingApp.entity.Screen;
import com.nabaneet.ticketingApp.entity.Seat;
import com.nabaneet.ticketingApp.entity.Theatre;
import com.nabaneet.ticketingApp.enums.SeatType;
import com.nabaneet.ticketingApp.repositories.CityRepository;
import com.nabaneet.ticketingApp.repositories.ScreenRepository;
import com.nabaneet.ticketingApp.repositories.SeatRepository;
import com.nabaneet.ticketingApp.repositories.TheatreRepository;
import com.nabaneet.ticketingApp.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final CityRepository cityRepository;
    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final SeatRepository seatRepository;

    public AdminServiceImpl(CityRepository cityRepository, TheatreRepository theatreRepository, ScreenRepository screenRepository, SeatRepository seatRepository) {
        this.cityRepository = cityRepository;
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public City addCity(String cityName) {
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    @Override
    public Theatre addTheatre(AddTheatreDTO addTheatreDTO) throws Exception {
        Theatre theatre = new Theatre();
        theatre.setName(addTheatreDTO.getTheatreName());
        theatre.setAddress(addTheatreDTO.getTheatreAddress());
        Optional<City> city = cityRepository.findById(addTheatreDTO.getCityId());
        if(city.isPresent()){
            theatre.setCity(city.get());
        }else {
            throw new Exception("City :"+addTheatreDTO.getCityId()+" not found");
        }
        return theatreRepository.save(theatre);
    }

    @Override
    public Long addScreenToTheatre(AddScreenToTheatreDto addScreenToTheatreDto) {
        Optional<Theatre> theatreOptional = theatreRepository.findById(addScreenToTheatreDto.getTheatreId());
        if(theatreOptional.isPresent()){
            Theatre theatre = theatreOptional.get();
            Screen screen = new Screen();
            screen.setName(addScreenToTheatreDto.getScreenName());
            addScreenToTheatreDto.getSeatTypes().forEach(seatType -> {
                if(seatType.getNoOfSeats() % addScreenToTheatreDto.getSeatsInOneRow() != 0){
                    throw new RuntimeException("Seat arrangement is not possible");
                }
                List<Seat> seats = new ArrayList<>();
                int noOfRows = seatType.getNoOfSeats() % addScreenToTheatreDto.getSeatsInOneRow();
                char seatRow = 'A';
                int seatNo=1;
                for(int i=1;i<=noOfRows;i++) {
                    Seat seat = new Seat();
                    seat.setSeatType(seatType.getSeatType());
                    seat.setScreen(screen);
                    if (seatType.getSeatType() == SeatType.RECLINER) {
                        seat.setSeatNo("R_" + seatRow + seatNo);
                        seatNo++;
                    } else if (seatType.getSeatType() == SeatType.PREMIUM) {
                        seat.setSeatNo("P_" + seatRow + seatNo);
                        seatNo++;
                    } else if (seatType.getSeatType() == SeatType.CLASSIC) {
                        seat.setSeatNo("C_" + seatRow + seatNo);
                        seatNo++;
                    } else if (seatType.getSeatType() == SeatType.BASE) {
                        seat.setSeatNo("B_" + seatRow + seatNo);
                        seatNo++;
                    }
                    seats.add(seat);
                    seatRow++;
                }
                seatRepository.saveAll(seats);
            });
            theatre.getScreens().add(screen);
            screen.setTheatre(theatre);
            Screen retVal = screenRepository.save(screen);
            theatreRepository.save(theatre);
            return retVal.getId();
        }else {
            throw new RuntimeException("Theatre is not present in DB");
        }
    }
}
