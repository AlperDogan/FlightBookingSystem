package com.finartz.alperdogan.airwaysbookingsystemproject.service;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Airport;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Company;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    public List<Airport> getAirports();
    public Airport createAirport(Airport airport);
    public Optional<Airport> findAirportById(Long id);
    public List<Airport> findAirportByName(String airportName);
}
