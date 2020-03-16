package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.DAO.ClientDAO;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client createClient(Client client) {
        return clientDAO.create(client);
    }

    @Override
    public Optional<Client> getClientByClientId(String clientId) {
        return clientDAO.getCustomerByClientId(clientId);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDAO.update(client);
    }
}
