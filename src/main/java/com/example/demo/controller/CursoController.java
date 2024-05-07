package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping("/getCursos")
    public List<Curso> getCursos(){
        return cursoService.getCursos();
    }

    @PostMapping("/postCurso")
    public void postCurso(@RequestBody Curso curso){
        cursoService.postCursos(curso);
    }

    @PutMapping("/putCurso/{idCurso}")
    public void putCurso(@PathVariable Long idCurso,@RequestBody Curso curso){
        cursoService.putCurso(curso,idCurso);
    }
    @DeleteMapping("/deleteCursoById/{idCurso}")
    public ResponseEntity<String> deleteCurso(@PathVariable Long idCurso){
        try {
            cursoService.deleteCurso(idCurso);
            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body("creado");
        } catch (Exception e){
             ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el curso: " + e.getMessage());
        }
        return null;
    }

}
