package com.example.demo.service;

import com.example.demo.model.Pais;
import com.example.demo.repositorio.IPaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    IPaisRepositorio iPaisRepositorio;

    public List<Pais> getPaises(){
        return iPaisRepositorio.findAll();
    }

}
