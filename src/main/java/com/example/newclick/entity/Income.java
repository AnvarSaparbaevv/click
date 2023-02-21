package com.example.newclick.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    Card from_cord_id;

    @OneToOne
    Card to_cord_id;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    LocalDate data;
}
