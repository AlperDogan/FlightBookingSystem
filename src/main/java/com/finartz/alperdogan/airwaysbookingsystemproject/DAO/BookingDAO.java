package com.finartz.alperdogan.airwaysbookingsystemproject.DAO;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Booking;
import com.finartz.alperdogan.airwaysbookingsystemproject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingDAO {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking (Booking booking){
        return bookingRepository.save(booking);
    }

    public Optional<Booking> findBookingByBookingId(Long bookingId){
        return bookingRepository.findById(bookingId);
    }

    public void deleteBooking(Long bookingId)
    {
         bookingRepository.deleteById(bookingId);
    }

}
