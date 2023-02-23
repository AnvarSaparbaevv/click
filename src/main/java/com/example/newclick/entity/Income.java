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
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    Card cardFrom;

    @OneToOne
    Card cardTo;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    LocalDateTime data;
}
