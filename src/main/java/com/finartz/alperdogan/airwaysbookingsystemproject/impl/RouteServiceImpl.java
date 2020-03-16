package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.DAO.RouteDAO;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Route;
import com.finartz.alperdogan.airwaysbookingsystemproject.repository.RouteRepository;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDAO routeDAO;

    @Override
    public List<Route> getRoutes() {
        return routeDAO.getRoutes();
    }

    @Override
    public Route createRoute(Route route) {
        return routeDAO.create(route);
    }

    @Override
    public Optional<Route> findRouteById(Long id) {
        return routeDAO.findById(id);
    }

    @Override
    public List<Route> findRouteByName(String routeName) {
        return routeDAO.findByName(routeName);
    }
}
