package com.example.demo.controller;

import com.example.demo.model.Rol;
import com.example.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping("/getRoles")
    public List<Rol> getRoles(){
        return rolService.getRoles();
    }
}
