package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuario;
import com.example.demo.repositorio.IPersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    IPersonaRepositorio iPersonaRepositorio;

    public List<Persona> getPersona(){
        return iPersonaRepositorio.findAll();
    };

    public Long postPersona(@RequestBody Persona persona){
        Persona personaCreada = iPersonaRepositorio.save(persona);
        return personaCreada.getId_persona();
    };

    public Persona getPersonaPorDdi(Long dni){
         return iPersonaRepositorio.findByDni(dni);
    };


    public void putPersona(Persona persona, Long idPersona){
        Optional<Persona> personaEx = iPersonaRepositorio.findById(idPersona);

        if (personaEx.isPresent()) {
            Persona personaExistente = personaEx.get();
            // Actualizar los campos del usuario existente con los valores del nuevo usuario
            personaExistente.setDni(persona.getDni());
            personaExistente.setNombre(persona.getNombre());
            personaExistente.setApellido(persona.getApellido());
            personaExistente.setTelefono(persona.getTelefono());
            personaExistente.setDireccion(persona.getDireccion());
            personaExistente.setFecha_nacimiento(persona.getFecha_nacimiento());
            personaExistente.setPais(persona.getPais());

            iPersonaRepositorio.save(personaExistente);
        } else {
            throw new IllegalArgumentException("No se encontró la persona con el ID especificado.");
        }
    };
}
