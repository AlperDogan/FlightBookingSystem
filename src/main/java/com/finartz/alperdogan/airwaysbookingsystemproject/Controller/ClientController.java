package com.finartz.alperdogan.airwaysbookingsystemproject.Controller;

import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.FlightNotFoundException;
import com.finartz.alperdogan.airwaysbookingsystemproject.Exception.OverBookedException;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Booking;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;
import com.finartz.alperdogan.airwaysbookingsystemproject.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

}
