package com.example.demo.controller;

import com.example.demo.model.Pais;
import com.example.demo.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PaisController {
    @Autowired
    PaisService paisService;


    @GetMapping("/getPaises")
    public List<Pais> getPaises(){
        return paisService.getPaises();
    }
}
