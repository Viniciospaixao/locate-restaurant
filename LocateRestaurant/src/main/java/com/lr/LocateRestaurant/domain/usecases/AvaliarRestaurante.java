package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Avaliacao;
import com.lr.LocateRestaurant.domain.repositories.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliarRestaurante {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliarRestaurante(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao executar(Avaliacao avaliacao) {
        // Validações podem ser adicionadas aqui (ex: verificar se o usuário já avaliou)
        return avaliacaoRepository.save(avaliacao);
    }
}