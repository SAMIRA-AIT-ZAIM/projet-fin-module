package com.example.demo.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrafficLight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state; // "RED", "GREEN", "YELLOW"

    @OneToOne
    @JoinColumn(name = "route_id")
    private Route route;
}

