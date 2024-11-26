package com.example.demo.services;

import com.example.demo.entites.Vehicle;
import com.example.demo.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    // Méthode pour récupérer tous les véhicules
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Méthode pour récupérer un véhicule par son ID
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    // Méthode pour sauvegarder un véhicule
    public Vehicle saveVehicle(Vehicle vehicle) {
        // Ajoutez des validations si nécessaire avant de sauvegarder
        if (vehicle.getModel() == null || vehicle.getModel().isEmpty()) {
            throw new IllegalArgumentException("Le modèle du véhicule est obligatoire.");
        }
        return vehicleRepository.save(vehicle);
    }

    // Méthode pour mettre à jour un véhicule
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        // Vérifie si le véhicule existe avant de le mettre à jour
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
        if (existingVehicle.isPresent()) {
            vehicle.setId(id); // Assurez-vous que l'ID est celui de l'entité existante
            return vehicleRepository.save(vehicle);
        } else {
            throw new IllegalArgumentException("Le véhicule avec l'ID " + id + " n'existe pas.");
        }
    }

    // Méthode pour supprimer un véhicule
    public void deleteVehicle(Long id) {
        // Vérifie si le véhicule existe avant de le supprimer
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
        if (existingVehicle.isPresent()) {
            vehicleRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Le véhicule avec l'ID " + id + " n'existe pas.");
        }
    }

}
