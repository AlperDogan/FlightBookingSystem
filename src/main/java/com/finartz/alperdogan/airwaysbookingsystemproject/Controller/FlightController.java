package com.finartz.alperdogan.airwaysbookingsystemproject.Controller;

import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Flight;
import com.finartz.alperdogan.airwaysbookingsystemproject.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @PostMapping
    public Flight insertFlight(@RequestBody Flight flight)
    {
        return flightService.createFlight(flight);
    }

    @GetMapping(value = "/{flightId}")
    public Optional<Flight> findAirportById(@PathVariable("flightId")Long flightId) throws FlightNotFoundException {
        return flightService.findFlightById(flightId);
    }
}
