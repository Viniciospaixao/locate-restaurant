package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Usuario;
import com.lr.LocateRestaurant.domain.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarUsuarioPorEmail {
    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioPorEmail(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> executar(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
