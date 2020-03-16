package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.OverBookedException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.*;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.BookingService;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.FlightService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class BookingServiceImplTest {

    @Mock
    private FlightServiceImpl mockFlightService;

    @InjectMocks
    private BookingServiceImpl mockBookingService;


    @Test
    void ExpectOverBookingException() throws FlightNotFoundException {
        MockitoAnnotations.initMocks(this);
        doReturn(Optional.of(new Flight(
                new Company("", ""),
                new Route("", ""),
                new Airport("", "", ""),
                100,
                100,
                200d))).when(mockFlightService).findFlightById(1L);
        try {
            mockBookingService.buyTicket(new Client(), 1L);
        } catch (OverBookedException e) {
            assert (true);
        }
    }

}