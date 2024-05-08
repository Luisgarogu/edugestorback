package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "matricula")

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

    public Matricula(Long id_matricula, Date fecha, Curso curso, Usuario usuario) {
        this.id_matricula = id_matricula;
        this.fecha = fecha;
        this.curso = curso;
        this.usuario = usuario;
    }

    public Matricula() {
    }

    public Long getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(Long id_matricula) {
        this.id_matricula = id_matricula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
