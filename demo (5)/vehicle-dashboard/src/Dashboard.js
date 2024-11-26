import React, { useState, useEffect } from "react";

const Dashboard = () => {
    const [vehicles, setVehicles] = useState([]);
    const [error, setError] = useState(false);

    useEffect(() => {
        fetch("http://localhost:8080/api/vehicles")
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Erreur de chargement");
                }
                return response.json();
            })
            .then((data) => setVehicles(data))
            .catch(() => setError(true));
    }, []);

    return (
        <div>
            <h1>Bienvenue sur le tableau de bord des véhicules</h1>
            <h2>Liste des Véhicules</h2>
            {error ? (
                <p>Erreur de chargement des véhicules</p>
            ) : (
                <ul>
                    {vehicles.map((vehicle) => (
                        <li key={vehicle.id}>
                            {vehicle.model} - {vehicle.type}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default Dashboard;
