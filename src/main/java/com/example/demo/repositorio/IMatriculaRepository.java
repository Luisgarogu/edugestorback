package com.example.demo.repositorio;

import com.example.demo.model.Matricula;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByUsuario(Usuario usuario);
}


