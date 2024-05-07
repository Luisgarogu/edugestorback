package com.example.demo.repositorio;

import com.example.demo.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRolRepositorio extends JpaRepository<Rol,Long> {
}