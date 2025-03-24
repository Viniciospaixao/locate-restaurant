package com.lr.LocateRestaurant;

import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.repositories.RestauranteRepository;
import com.lr.LocateRestaurant.domain.usecases.CadastrarRestaurante;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CadastrarRestauranteTest {


    @Test
    void deveCadastrarRestauranteComSucesso() {
        // Arrange
        RestauranteRepository restauranteRepository = Mockito.mock(RestauranteRepository.class);
        CadastrarRestaurante cadastrarRestaurante = new CadastrarRestaurante(restauranteRepository);
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");

        when(restauranteRepository.save(restaurante)).thenReturn(restaurante);

        // Act
        Restaurante resultado = cadastrarRestaurante.executar(restaurante);

        // Assert
        assertEquals(restaurante, resultado);
        verify(restauranteRepository, times(1)).save(restaurante);
    }
}