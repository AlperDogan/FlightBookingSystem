package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.DAO.FlightDAO;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Airport;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Company;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Flight;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Route;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl mockFlightService;

    @Mock
    private FlightDAO mockFlightDAO;

    @Test
    void priceIncrementAfterTenPercentTest()
    {
        MockitoAnnotations.initMocks(this);
        doReturn(Optional.of(new Flight(
                new Company("", ""),
                new Route("", ""),
                new Airport("", "", ""),
                100,
                9,
                200d))).when(mockFlightDAO).findById(1L);
        ArgumentCaptor<Flight> argument = ArgumentCaptor.forClass(Flight.class);
        mockFlightService.updateFlightBookingCountAndPrice(1L);
        Mockito.verify(mockFlightDAO).update(argument.capture());
        assertEquals(10, argument.getValue().getBooking_count());
        assertEquals(220, argument.getValue().getPrice());
    }

}