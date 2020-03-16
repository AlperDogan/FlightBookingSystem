package com.finartz.alperdogan.airwaysbookingsystemproject.DAO;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;
import com.finartz.alperdogan.airwaysbookingsystemproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class ClientDAO  {

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client)
    {
       return clientRepository.save(client);
    }

    public Optional<Client> getCustomerByClientId(String clientId){
        return clientRepository.findById(clientId);
    }

    public Client update(Client client) {return clientRepository.save(client); }

}
