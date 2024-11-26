package com.example.demo.controllers;

import com.example.demo.entites.Route;
import com.example.demo.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    // Méthode pour récupérer toutes les routes
    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        if (routes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Retourne 204 si aucune route
        }
        return new ResponseEntity<>(routes, HttpStatus.OK);  // Retourne 200 avec la liste des routes
    }

    // Méthode pour créer une nouvelle route
    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        // Vous pouvez ajouter des validations ici avant de sauvegarder
        if (route.getName() == null || route.getName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Retourne 400 si les données sont invalides
        }
        Route savedRoute = routeService.saveRoute(route);
        return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);  // Retourne 201 avec la route créée
    }
}
