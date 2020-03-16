package com.finartz.alperdogan.airwaysbookingsystemproject.DAO;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Flight;
import com.finartz.alperdogan.airwaysbookingsystemproject.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FlightDAO {

    @Autowired
    private FlightRepository flightRepository;

    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }
    public Flight update (Flight flight){return flightRepository.save(flight);}
}
