package com.example.demo.repositorio;

import com.example.demo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepositorio extends JpaRepository<Curso,Long> {
}
