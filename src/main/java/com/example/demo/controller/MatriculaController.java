package com.example.demo.controller;

import com.example.demo.model.Matricula;
import com.example.demo.model.Usuario;
import com.example.demo.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @GetMapping("/getMatriculas")
    public List<Matricula> getMatriculas(){
        return matriculaService.getMatriculas();
    }

    @PostMapping("/getMatriculasByUsuario")
    public List<Matricula> getMatriculasByEstudiante(@RequestBody Usuario usuario){
        return matriculaService.getMatriculaByEstudiante(usuario);
    }

    @PostMapping("/postMatricula")
    public void postMatricula(@RequestBody Matricula matricula){
        matriculaService.postMatricula(matricula);
    }

    @DeleteMapping("/deleteMatricula/{idMatricula}")
    public void actualizarUsuario1(@PathVariable Long idMatricula) {
        matriculaService.deleteMatriculaById(idMatricula);
        ResponseEntity.ok("¡Eliminado con Exito!");
    }
}
