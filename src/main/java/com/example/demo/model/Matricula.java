package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "matricula")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matricula;

    @Column(name = "fecha")
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
