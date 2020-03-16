package com.finartz.alperdogan.airwaysbookingsystemproject.repository;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {
}
