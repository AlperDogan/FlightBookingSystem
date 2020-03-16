package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.DAO.FlightDAO;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Flight;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightDAO flightDAO;

    @Override
    public Flight createFlight(Flight flight) {
        return flightDAO.create(flight);
    }

    @Override
    public Optional<Flight> findFlightById(Long id) {
        return flightDAO.findById(id);
    }

    @Override
    public Flight updateFlightBookingCountAndPrice(Long id) {
        Optional<Flight> flight = flightDAO.findById(id);
        if(flight.isPresent())
        {
            Flight flight1= flight.get();
            int tenPercentQuota=(flight1.getQuota_count()/100)*10;
            Double presentFlightPrice = flight1.getPrice();

            flight1.setBooking_count(flight1.getBooking_count()+1);

            if(flight1.getBooking_count()==1)
                flight1.setPrice(presentFlightPrice);
            else {
                double presentRaiseRate=Math.floor((flight1.getBooking_count()-1)/tenPercentQuota);
                double afterBookingPresentRate=Math.floor(flight1.getBooking_count()/tenPercentQuota);
                if(presentRaiseRate==afterBookingPresentRate)
                    flight1.setPrice(presentFlightPrice);
                else{
                    Double newPrice = presentFlightPrice+((presentFlightPrice/100)*(10));
                    flight1.setPrice(newPrice);
                }
            }
            return flightDAO.update(flight.get());
        }
        return flight.get();
    }

    @Override
    public Flight decrementFlightBookingCount(Long id) throws FlightNotFoundException {
        Flight decrementFlight = findFlightById(id).orElseThrow(FlightNotFoundException::new);
        decrementFlight.setBooking_count(decrementFlight.getBooking_count()-1);
        return flightDAO.update(decrementFlight);
    }
}
