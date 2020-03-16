package com.finartz.alperdogan.airwaysbookingsystemproject.repository;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {
}
