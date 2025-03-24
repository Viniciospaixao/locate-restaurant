package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Avaliacao;
import com.lr.LocateRestaurant.domain.repositories.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarAvaliacoesPorRestaurante {
    private final AvaliacaoRepository avaliacaoRepository;

    public ListarAvaliacoesPorRestaurante(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> executar(Long restauranteId) {
        return avaliacaoRepository.findByRestauranteId(restauranteId);
    }
}

