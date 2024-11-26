package com.example.demo.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String type;
    private double speed;
    private double position;
    private String status;

    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonBackReference
    private Route currentRoute;
}
