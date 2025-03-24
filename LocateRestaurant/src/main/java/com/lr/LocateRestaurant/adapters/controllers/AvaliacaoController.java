package com.lr.LocateRestaurant.adapters.controllers;

import com.lr.LocateRestaurant.domain.entities.Avaliacao;
import com.lr.LocateRestaurant.domain.usecases.AvaliarRestaurante;
import com.lr.LocateRestaurant.domain.usecases.ListarAvaliacoesPorRestaurante;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    private final AvaliarRestaurante avaliarRestaurante;
    private final ListarAvaliacoesPorRestaurante listarAvaliacoesPorRestaurante;

    public AvaliacaoController(AvaliarRestaurante avaliarRestaurante,
                               ListarAvaliacoesPorRestaurante listarAvaliacoesPorRestaurante) {
        this.avaliarRestaurante = avaliarRestaurante;
        this.listarAvaliacoesPorRestaurante = listarAvaliacoesPorRestaurante;
    }

    @PostMapping
    public Avaliacao avaliarRestaurante(@RequestBody Avaliacao avaliacao) {
        return avaliarRestaurante.executar(avaliacao);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<Avaliacao> listarAvaliacoesPorRestaurante(@PathVariable Long restauranteId) {
        return listarAvaliacoesPorRestaurante.executar(restauranteId);
    }
}
