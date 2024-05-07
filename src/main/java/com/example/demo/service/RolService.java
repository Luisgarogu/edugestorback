package com.example.demo.service;

import com.example.demo.model.Rol;
import com.example.demo.repositorio.IRolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    IRolRepositorio iRolRepositorio;

    public List<Rol> getRoles(){
        return  iRolRepositorio.findAll();
    }
}
