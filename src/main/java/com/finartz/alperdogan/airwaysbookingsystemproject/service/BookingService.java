package com.finartz.alperdogan.airwaysbookingsystemproject.service;

import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.OverBookedException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Booking;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;

import java.util.Optional;

public interface BookingService {

     Optional<Booking> findBookingByBookingId(Long bookingId);
     Booking buyTicket(Client client, Long flightId) throws FlightNotFoundException, OverBookedException;
     boolean deleteBookingByBookingId(Long bookingId);
}
