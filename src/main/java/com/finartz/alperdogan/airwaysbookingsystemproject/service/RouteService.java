package com.finartz.alperdogan.airwaysbookingsystemproject.service;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Company;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    public List<Route> getRoutes();
    public Route createRoute(Route route);
    public Optional<Route> findRouteById(Long id);
    public List<Route> findRouteByName(String routeName);
}
