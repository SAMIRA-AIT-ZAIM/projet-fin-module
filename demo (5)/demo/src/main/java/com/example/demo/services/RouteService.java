package com.example.demo.services;

import com.example.demo.entites.Route;
import com.example.demo.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    // Méthode pour récupérer toutes les routes
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    // Méthode pour sauvegarder une nouvelle route
    public Route saveRoute(Route route) {
        // Vérifier si les données sont valides
        if (route.getName() == null || route.getName().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la route est obligatoire.");
        }

        try {
            return routeRepository.save(route);
        } catch (DataIntegrityViolationException e) {
            // Si l'enregistrement viole une contrainte d'intégrité, gérer l'exception
            throw new RuntimeException("Erreur lors de l'enregistrement de la route : " + e.getMessage(), e);
        }
    }

    // Exemple de méthode pour trouver une route par son ID
    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    // Exemple de méthode pour mettre à jour une route
    public Route updateRoute(Long id, Route route) {
        // Vérifier si la route existe avant de la mettre à jour
        Optional<Route> existingRoute = routeRepository.findById(id);
        if (existingRoute.isPresent()) {
            route.setId(id);  // Assurez-vous que l'ID est le bon pour la mise à jour
            return routeRepository.save(route);
        } else {
            throw new IllegalArgumentException("La route avec l'ID " + id + " n'existe pas.");
        }
    }

    // Exemple de méthode pour supprimer une route
    public void deleteRoute(Long id) {
        // Vérifier si la route existe avant de la supprimer
        Optional<Route> existingRoute = routeRepository.findById(id);
        if (existingRoute.isPresent()) {
            routeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("La route avec l'ID " + id + " n'existe pas.");
        }
    }
}
