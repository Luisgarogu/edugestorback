package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "calificacion")

public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_calificacion;

    @Column(name = "nota")
    private Double nota;

    @OneToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;

    public Calificacion(Long id_calificacion, Double nota, Matricula matricula) {
        this.id_calificacion = id_calificacion;
        this.nota = nota;
        this.matricula = matricula;
    }

    public Calificacion() {
    }

    public Long getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Long id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}
