package com.example.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double length;
    private int trafficDensity;

    @OneToMany(mappedBy = "currentRoute", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Vehicle> vehicles;
}
