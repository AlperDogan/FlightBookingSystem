package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.DAO.AirportDAO;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Airport;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDAO airportDAO;

    @Override
    public List<Airport> getAirports() {
        return airportDAO.getAirports();
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportDAO.create(airport);
    }

    @Override
    public Optional<Airport> findAirportById(Long id) {
        return airportDAO.findById(id);
    }

    @Override
    public List<Airport> findAirportByName(String airportName) {
        return airportDAO.findByName(airportName);
    }
}
