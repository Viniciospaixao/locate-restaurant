package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.repositories.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarRestaurante {
    private final RestauranteRepository restauranteRepository;

    public CadastrarRestaurante(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante executar(Restaurante restaurante) {

        return restauranteRepository.save(restaurante);
    }
}