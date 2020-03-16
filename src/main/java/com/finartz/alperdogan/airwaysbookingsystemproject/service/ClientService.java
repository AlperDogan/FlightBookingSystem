package com.finartz.alperdogan.airwaysbookingsystemproject.service;

import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.OverBookedException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Booking;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;

import java.util.Optional;

public interface ClientService {

    public Client createClient(Client client);
    public Optional<Client> getClientByClientId(String clientId);
    public Client updateClient(Client client);
}
