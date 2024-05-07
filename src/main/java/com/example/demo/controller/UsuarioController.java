package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuario;
import com.example.demo.service.PersonaService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PersonaService personaService;


    @GetMapping("/getUsuarios")
    public List<Usuario> listarUsers() {
        return usuarioService.getUsuarios();
    }

    @PostMapping("/postUsuario")
    public void guardarUsuarios(@RequestBody Usuario usuario) {
        usuarioService.postUsuarios(usuario);
    }

    @PutMapping("/putUsuarios/{idUsuario}")
    public void actualizarUsuario1(@PathVariable Long idUsuario,@RequestBody Usuario usuario) {
        usuarioService.putUsuarios(usuario, idUsuario);
    }

    @DeleteMapping("/deleteUser/{idUsuario}")
    public void actualizarUsuario1(@PathVariable Long idUsuario) {
        usuarioService.deleteUserByIdUsuario(idUsuario);
        ResponseEntity.ok("¡Eliminado con Exito!");
    }

    @PostMapping("/loginUsuario")
    public ResponseEntity<String> loginUsuario(@RequestBody Usuario usuario) {
        System.console().printf(String.valueOf(usuario));
        if (usuarioService.authUsuario(usuario.getUsuario(), usuario.getContrasena())) {
            return ResponseEntity.ok("¡Inicio de sesión exitoso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @GetMapping("/getUsersByRol/{idRol}")
    public List<Usuario> getUsuariosByRol(@PathVariable Long idRol) {
           return usuarioService.getUsuariosByRol(idRol);
    }

}
