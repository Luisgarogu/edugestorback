package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "calificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_calificacion;

    @Column(name = "nota")
    private Double nota;

    @OneToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;
}
