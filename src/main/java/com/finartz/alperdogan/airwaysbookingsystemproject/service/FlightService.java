package com.finartz.alperdogan.airwaysbookingsystemproject.service;

import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Flight;

import java.util.Optional;


public interface FlightService {

    public Flight createFlight(Flight flight);
    public Optional<Flight> findFlightById(Long id);
    public Flight updateFlightBookingCountAndPrice(Long id);
    public Flight decrementFlightBookingCount(Long id) throws FlightNotFoundException;
}
