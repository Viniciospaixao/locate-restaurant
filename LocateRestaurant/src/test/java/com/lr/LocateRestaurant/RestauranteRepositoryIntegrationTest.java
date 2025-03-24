package com.lr.LocateRestaurant;

import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.repositories.RestauranteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class RestauranteRepositoryIntegrationTest {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    void deveBuscarRestaurantesPorTipoCozinha() {
        // Arrange
        Restaurante restaurante = new Restaurante();
        restaurante.setTipoCozinha("Italiana");
        restauranteRepository.save(restaurante);

        // Act
        List<Restaurante> restaurantes = restauranteRepository.findByTipoCozinha("Italiana");

        // Assert
        assertEquals(1, restaurantes.size());
        assertEquals("Italiana", restaurantes.get(0).getTipoCozinha());
    }
}