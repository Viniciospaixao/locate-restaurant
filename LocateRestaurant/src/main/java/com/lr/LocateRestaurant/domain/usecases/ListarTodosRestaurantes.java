package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.repositories.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTodosRestaurantes {
    private final RestauranteRepository restauranteRepository;

    public ListarTodosRestaurantes(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> executar() {
        return restauranteRepository.findAll();
    }
}
