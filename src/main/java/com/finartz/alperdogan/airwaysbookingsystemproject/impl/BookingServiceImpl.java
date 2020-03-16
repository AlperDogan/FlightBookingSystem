package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.DAO.BookingDAO;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.OverBookedException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Booking;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Flight;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.BookingService;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private FlightService flightService;

    @Override
    public Optional<Booking> findBookingByBookingId(Long bookingId) {
        return bookingDAO.findBookingByBookingId(bookingId);
    }

    @Override
    public Booking buyTicket(Client client, Long flightId) throws FlightNotFoundException, OverBookedException {
        Random rand = new Random();
        Booking bookingRec =  new Booking();
        Flight requestedFlight= flightService.findFlightById(flightId)
                .orElseThrow(FlightNotFoundException::new);
        if(requestedFlight.getBooking_count()<requestedFlight.getQuota_count())
        {
            bookingRec.setClient_id(client.getId_number());
            bookingRec.setFlight(requestedFlight);
            bookingRec.setSeat_no(rand.nextInt(requestedFlight.getQuota_count()));
            bookingRec.setPrice(requestedFlight.getPrice());

            flightService.updateFlightBookingCountAndPrice(requestedFlight.getFlight_id());
            return bookingDAO.createBooking(bookingRec);
        }else{
            throw new OverBookedException();
        }

    }

    @Override
    public boolean deleteBookingByBookingId(Long bookingId) {
        bookingDAO.deleteBooking(bookingId);
        return true;
    }
}
