package com.finartz.alperdogan.airwaysbookingsystemproject.Controller;

import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.BookingNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.OverBookedException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Booking;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.BookingService;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ClientService clientService;


    @GetMapping(value="/{bookingId}")
    public Optional<Booking> findBookingByBookingId(@PathVariable("bookingId")Long bookingId)
    {
        return bookingService.findBookingByBookingId(bookingId);
    }

    @PostMapping(value="/{flightId}")
    public Booking buyTicket(@RequestBody Client client, @PathVariable("flightId") Long flightId) throws FlightNotFoundException, OverBookedException {
        if(!clientService.getClientByClientId(client.getId_number()).isPresent())
        {
            clientService.createClient(client);
        }
        else
        {
            clientService.updateClient(client);
        }
        return bookingService.buyTicket(client,flightId);
    }

    @DeleteMapping(value="/{bookingId}")
    public boolean cancelTicket(@PathVariable("bookingId")Long bookingId) throws BookingNotFoundException {
        if(bookingService.findBookingByBookingId(bookingId).isPresent())
        {

            return bookingService.deleteBookingByBookingId(bookingId);
        }
        throw new BookingNotFoundException();
    }
}
