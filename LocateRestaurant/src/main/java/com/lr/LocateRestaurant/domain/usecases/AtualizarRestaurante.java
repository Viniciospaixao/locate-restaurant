package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.repositories.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarRestaurante {
    private final RestauranteRepository restauranteRepository;

    public AtualizarRestaurante(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante executar(Long id, Restaurante restauranteAtualizado) {
        Optional<Restaurante> restauranteExistente = restauranteRepository.findById(id);

        if (restauranteExistente.isPresent()) {
            Restaurante restaurante = restauranteExistente.get();
            restaurante.setNome(restauranteAtualizado.getNome());
            restaurante.setLocalizacao(restauranteAtualizado.getLocalizacao());
            restaurante.setTipoCozinha(restauranteAtualizado.getTipoCozinha());
            restaurante.setHorarioFuncionamento(restauranteAtualizado.getHorarioFuncionamento());
            restaurante.setCapacidade(restauranteAtualizado.getCapacidade());

            return restauranteRepository.save(restaurante);
        } else {
            throw new RuntimeException("Restaurante não encontrado");
        }
    }
}
