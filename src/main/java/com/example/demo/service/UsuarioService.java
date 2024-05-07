package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;

    public List<Usuario> getUsuarios() {
        return iUsuarioRepositorio.findAll();
    }

    ;

    public void postUsuarios(Usuario usuario) {

        String primerNombre = usuario.getPersona().getNombre().split(" ")[0];
        String primerApellido = usuario.getPersona().getApellido().split(" ")[0];

        String correoBase = primerNombre.toLowerCase() + "." + primerApellido.toLowerCase();
        String correoFinal = correoBase + "@fasttrack.com." + (usuario.getPersona().getPais().getPais()).toLowerCase();

        int contador = 0;
        List<Usuario> usuarios = iUsuarioRepositorio.findByCorreoStartingWith(correoBase);
        System.out.println(usuarios);

        while (usuarios.size() >= contador)  {
            correoFinal = correoBase + "." + (contador+1) + "@fasttrack.com." + (usuario.getPersona().getPais().getPais()).toLowerCase();
            contador++;
            usuarios = iUsuarioRepositorio.findByCorreoStartingWith(correoBase);
        }

        if (contador == 1) {
            correoFinal = correoBase + ".@fasttrack.com." + (usuario.getPersona().getPais().getPais()).toLowerCase();
        }

        usuario.setCorreo(correoFinal);
        iUsuarioRepositorio.save(usuario);
    }

    ;

    public void putUsuarios(Usuario usuario, Long idUsuario) {
        Optional<Usuario> usuarioExistenteOptional = iUsuarioRepositorio.findById(idUsuario);

        if (usuarioExistenteOptional.isPresent()) {
            Usuario usuarioExistente = usuarioExistenteOptional.get();
            // Actualizar los campos del usuario existente con los valores del nuevo usuario
            usuarioExistente.setUsuario(usuario.getUsuario());
            usuarioExistente.setContrasena(usuario.getContrasena());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setPersona(usuario.getPersona());
            usuarioExistente.setRol(usuario.getRol());

            iUsuarioRepositorio.save(usuarioExistente);
        } else {
            throw new IllegalArgumentException("No se encontró un usuario con el ID especificado.");
        }
    }

    ;

    public boolean authUsuario(String usuario, String contrasena) {
        Usuario usuarioEncontrado = iUsuarioRepositorio.findByUsuario(usuario);
        return usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contrasena);
    }

    ;

    public List<Usuario> getUsuariosByRol(Long idRol) {
        return iUsuarioRepositorio.findByRolId(idRol);
    }

    public void deleteUserByIdUsuario(Long Id) {
        iUsuarioRepositorio.deleteById(Id);
    }
}
