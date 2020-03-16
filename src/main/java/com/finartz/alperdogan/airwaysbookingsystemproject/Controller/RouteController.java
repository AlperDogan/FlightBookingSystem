package com.finartz.alperdogan.airwaysbookingsystemproject.Controller;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Route;
import com.finartz.alperdogan.airwaysbookingsystemproject.impl.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteServiceImpl routeService;


    @GetMapping
    public List<Route> getCompanies() {
        return routeService.getRoutes();
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route){
        return routeService.createRoute(route);
    }

    @GetMapping(value = "/byId/{routeId}")
    public Optional<Route> findRouteById(@PathVariable("routeId")Long routeId)
    {
        return routeService.findRouteById(routeId);
    }

    @GetMapping(value = "/byName/{routeName}")
    public List<Route> findRouteByName(@PathVariable("routeName")String routeName)
    {
        return routeService.findRouteByName(routeName);
    }
    
}
