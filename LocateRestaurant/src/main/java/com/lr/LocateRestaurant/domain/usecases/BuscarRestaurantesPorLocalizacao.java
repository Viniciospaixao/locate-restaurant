package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.repositories.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarRestaurantesPorLocalizacao {
    private final RestauranteRepository restauranteRepository;

    public BuscarRestaurantesPorLocalizacao(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> executar(String localizacao) {
        return restauranteRepository.findByLocalizacao(localizacao);
    }
}
