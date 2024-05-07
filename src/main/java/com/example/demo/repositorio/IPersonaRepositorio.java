package com.example.demo.repositorio;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonaRepositorio extends JpaRepository<Persona,Long> {
    Persona findByDni(Long dni);
}
