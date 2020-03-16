package com.finartz.alperdogan.airwaysbookingsystemproject.repository;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
