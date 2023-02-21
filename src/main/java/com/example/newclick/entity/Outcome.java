package com.example.newclick.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    Card from_cord_id;

    @OneToOne
    Card to_cord_id;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    LocalDateTime data;

    @Column(nullable = false)
    private double commision_amount;
}
