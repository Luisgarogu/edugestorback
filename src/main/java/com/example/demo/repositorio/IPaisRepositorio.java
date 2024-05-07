package com.example.demo.repositorio;

import com.example.demo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepositorio extends JpaRepository<Pais,Long> {
}
