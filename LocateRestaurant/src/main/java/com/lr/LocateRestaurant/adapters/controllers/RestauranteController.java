package com.lr.LocateRestaurant.adapters.controllers;


import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.usecases.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    private final CadastrarRestaurante cadastrarRestaurante;
    private final BuscarRestaurantesPorCozinha buscarRestaurantesPorCozinha;
    private final BuscarRestaurantesPorLocalizacao buscarRestaurantesPorLocalizacao;
    private final AtualizarRestaurante atualizarRestaurante;
    private final ListarTodosRestaurantes listarTodosRestaurantes;

    public RestauranteController(CadastrarRestaurante cadastrarRestaurante,
                                 BuscarRestaurantesPorCozinha buscarRestaurantesPorCozinha,
                                 BuscarRestaurantesPorLocalizacao buscarRestaurantesPorLocalizacao,
                                 AtualizarRestaurante atualizarRestaurante,
                                 ListarTodosRestaurantes listarTodosRestaurantes) {
        this.cadastrarRestaurante = cadastrarRestaurante;
        this.buscarRestaurantesPorCozinha = buscarRestaurantesPorCozinha;
        this.buscarRestaurantesPorLocalizacao = buscarRestaurantesPorLocalizacao;
        this.atualizarRestaurante = atualizarRestaurante;
        this.listarTodosRestaurantes = listarTodosRestaurantes;
    }

    // Cadastrar um novo restaurante
    @PostMapping
    public Restaurante cadastrar(@RequestBody Restaurante restaurante) {
        return cadastrarRestaurante.executar(restaurante);
    }

    // Buscar restaurantes por tipo de cozinha
    @GetMapping("/cozinha")
    public List<Restaurante> buscarPorCozinha(@RequestParam String tipoCozinha) {
        return buscarRestaurantesPorCozinha.executar(tipoCozinha);
    }

    // Buscar restaurantes por localização
    @GetMapping("/localizacao")
    public List<Restaurante> buscarPorLocalizacao(@RequestParam String localizacao) {
        return buscarRestaurantesPorLocalizacao.executar(localizacao);
    }

    // Atualizar um restaurante existente
    @PutMapping("/{id}")
    public Restaurante atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return atualizarRestaurante.executar(id, restaurante);
    }

    // Listar todos os restaurantes
    @GetMapping
    public List<Restaurante> listarTodos() {
        return listarTodosRestaurantes.executar();
    }
}