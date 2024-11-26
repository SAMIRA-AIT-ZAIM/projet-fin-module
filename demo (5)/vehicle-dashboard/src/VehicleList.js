import React, { useState, useEffect } from 'react';
import axios from 'axios';

const VehicleList = () => {
    const [vehicles, setVehicles] = useState([]);
    const [error, setError] = useState(null);

    // Utilisation de useEffect pour charger les véhicules au démarrage
    useEffect(() => {
        axios.get('http://localhost:8080/api/vehicles') // URL de votre API
            .then(response => {
                setVehicles(response.data);
            })
            .catch(error => {
                setError("Erreur de chargement des véhicules");
            });
    }, []); // Le tableau vide signifie que l'effet est exécuté une seule fois au démarrage

    return (
        <div>
            <h1>Liste des Véhicules</h1>
            {error && <div>{error}</div>}
            <ul>
                {vehicles.map(vehicle => (
                    <li key={vehicle.id}>
                        <strong>Modèle:</strong> {vehicle.model}<br />
                        <strong>Type:</strong> {vehicle.type}<br />
                        <strong>Vitesse:</strong> {vehicle.speed} km/h<br />
                        <strong>Position:</strong> {vehicle.position} km<br />
                        <strong>Statut:</strong> {vehicle.status}<br />
                        <strong>Route actuelle:</strong> {vehicle.currentRoute ? vehicle.currentRoute.id : 'Non défini'}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default VehicleList;
