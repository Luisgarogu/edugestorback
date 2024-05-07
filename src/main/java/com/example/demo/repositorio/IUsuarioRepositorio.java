package com.example.demo.repositorio;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepositorio extends JpaRepository<Usuario,Long> {
    Usuario findByUsuario(String usuario);
    Usuario findByContrasena(String contrasena);
    List<Usuario> findByRolId(Long idRol);
    List<Usuario> findByCorreo(String correo);
    @Query("SELECT u FROM Usuario u WHERE u.correo LIKE CONCAT(?1, '%')")
    List<Usuario> findByCorreoStartingWith(String correoBase);

}

