package com.example.demo.service;

import com.example.demo.model.Matricula;
import com.example.demo.model.Usuario;
import com.example.demo.repositorio.IMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    IMatriculaRepository iMatriculaRepository;

    public List<Matricula> getMatriculas(){
        return iMatriculaRepository.findAll();
    }
    public List<Matricula> getMatriculaByEstudiante(Usuario usuario){
        return iMatriculaRepository.findByUsuario(usuario);
    }
    public void postMatricula(Matricula matricula){
         iMatriculaRepository.save(matricula);
    }
    public void deleteMatriculaById(Long Id){
        iMatriculaRepository.deleteById(Id);
    }

}
