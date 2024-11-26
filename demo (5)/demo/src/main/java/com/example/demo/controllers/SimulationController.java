package com.example.demo.controllers;

import com.example.demo.entites.Route;
import com.example.demo.entites.Vehicle;
import com.example.demo.services.RouteService;
import com.example.demo.services.VehicleService;
import com.example.demo.simulation.TrafficSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/simulation")
public class SimulationController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TrafficSimulationService simulationService; // Déclarez et injectez le service manquant

    @PostMapping("/start")
    public ResponseEntity<String> startSimulation() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<Route> routes = routeService.getAllRoutes();

        simulationService.simulateTraffic(vehicles, routes);
        return new ResponseEntity<>("Simulation démarrée avec succès.", HttpStatus.OK);
    }
}

