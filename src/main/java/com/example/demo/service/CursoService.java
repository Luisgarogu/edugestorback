package com.example.demo.service;

import com.example.demo.model.Curso;
import com.example.demo.model.Usuario;
import com.example.demo.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    ICursoRepositorio iCursoRepositorio;

    public List<Curso> getCursos(){
        return iCursoRepositorio.findAll();
    }

    public void postCursos(Curso curso){
         iCursoRepositorio.save(curso);
    }

    public void deleteCurso(Long idCurso) {
        iCursoRepositorio.deleteById(idCurso);
    }

    public void putCurso(Curso curso, Long idCurso){
        Optional<Curso> cursoEx = iCursoRepositorio.findById(idCurso);

        if (cursoEx.isPresent()) {
            Curso cursoNew = cursoEx.get();
            // Actualizar los campos del usuario existente con los valores del nuevo usuario
            cursoNew.setNombre_curso(curso.getNombre_curso());

            iCursoRepositorio.save(cursoNew);
        } else {
            throw new IllegalArgumentException("No se encontró un curso con el ID especificado.");
        }
    };
}
