package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuario;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/getPersona")
    public List<Persona> listarPersona() {
        return personaService.getPersona();
    }

    @PostMapping("/postPersona")
    public void guardarPersona(@RequestBody Persona persona) {
        personaService.postPersona(persona);
    }

    @GetMapping("/getPersonByDni/{dni}")
    public Persona encontrarPersonaPorDni(@PathVariable Long dni) {
        return personaService.getPersonaPorDdi(dni);
    }
    @PutMapping("/putPersona/{idPersona}")
    public void actuPersona(@PathVariable Long idPersona,@RequestBody Persona persona
    ) {
        personaService.putPersona(persona, idPersona);
    }

}
