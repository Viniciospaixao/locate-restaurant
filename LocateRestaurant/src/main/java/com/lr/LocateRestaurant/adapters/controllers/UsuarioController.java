package com.lr.LocateRestaurant.adapters.controllers;

import com.lr.LocateRestaurant.domain.entities.Usuario;
import com.lr.LocateRestaurant.domain.usecases.BuscarUsuarioPorEmail;
import com.lr.LocateRestaurant.domain.usecases.CadastrarUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final BuscarUsuarioPorEmail buscarUsuarioPorEmail;
    private final CadastrarUsuario cadastrarUsuario;

    public UsuarioController(BuscarUsuarioPorEmail buscarUsuarioPorEmail,CadastrarUsuario cadastrarUsuario) {
        this.buscarUsuarioPorEmail = buscarUsuarioPorEmail;
        this.cadastrarUsuario = cadastrarUsuario;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return cadastrarUsuario.executar(usuario);
    }

    @GetMapping("/email")
    public Optional<Usuario> buscarPorEmail(@RequestParam String email) {
        return buscarUsuarioPorEmail.executar(email);
    }
}
