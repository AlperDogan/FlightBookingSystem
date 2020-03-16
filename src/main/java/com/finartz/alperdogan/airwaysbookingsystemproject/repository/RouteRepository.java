package com.finartz.alperdogan.airwaysbookingsystemproject.repository;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
