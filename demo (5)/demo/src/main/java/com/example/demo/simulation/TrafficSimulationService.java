package com.example.demo.simulation;

import com.example.demo.entites.Route;
import com.example.demo.entites.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrafficSimulationService {
    public void simulateTraffic(List<Vehicle> vehicles, List<Route> routes) {
        for (Route route : routes) {
            int trafficDensity = route.getTrafficDensity();

            for (Vehicle vehicle : vehicles) {
                if (vehicle.getCurrentRoute().equals(route)) {
                    // Simuler le ralentissement si la densité de trafic est élevée
                    if (trafficDensity > 70) {
                        vehicle.setSpeed(vehicle.getSpeed() * 0.8); // Réduire la vitesse
                    }
                }
            }
        }
    }
    public void moveVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if ("MOVING".equals(vehicle.getStatus())) {
                vehicle.setPosition(vehicle.getPosition() + vehicle.getSpeed());
            }
        }
    }

}

