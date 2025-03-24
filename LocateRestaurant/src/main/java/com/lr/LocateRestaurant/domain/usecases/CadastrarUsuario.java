package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Usuario;
import com.lr.LocateRestaurant.domain.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuario {
    private final UsuarioRepository usuarioRepository;

    public CadastrarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario executar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }
}
