package com.lr.LocateRestaurant;

import com.lr.LocateRestaurant.adapters.controllers.RestauranteController;
import com.lr.LocateRestaurant.domain.entities.Restaurante;
import com.lr.LocateRestaurant.domain.usecases.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestauranteController.class)
class RestauranteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CadastrarRestaurante cadastrarRestaurante;

    @MockBean
    private BuscarRestaurantesPorCozinha buscarRestaurantesPorCozinha;

    @MockBean
    private BuscarRestaurantesPorLocalizacao buscarRestaurantesPorLocalizacao;

    @MockBean
    private AtualizarRestaurante atualizarRestaurante;

    @MockBean // Adicione esta linha
    private ListarTodosRestaurantes listarTodosRestaurantes;

    @Test
    void deveCadastrarRestauranteComSucesso() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");

        when(cadastrarRestaurante.executar(restaurante)).thenReturn(restaurante);

        MvcResult result =  mockMvc.perform(post("/restaurantes")
                        .contentType("application/json")
                        .content("{\"nome\": \"Restaurante Teste\"}"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        System.out.println("Response Body: " + responseBody);
    }

    @Test
    void deveBuscarRestaurantesPorCozinhaComSucesso() throws Exception {
        String tipoCozinha = "Italiana";
        Restaurante restaurante = new Restaurante();
        restaurante.setTipoCozinha(tipoCozinha);

        when(buscarRestaurantesPorCozinha.executar(tipoCozinha)).thenReturn(Collections.singletonList(restaurante));

        mockMvc.perform(get("/restaurantes/cozinha")
                        .param("tipoCozinha", tipoCozinha))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipoCozinha").value(tipoCozinha));
    }

    @Test
    void deveListarTodosRestaurantesComSucesso() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");

        when(listarTodosRestaurantes.executar()).thenReturn(List.of(restaurante));

        mockMvc.perform(get("/restaurantes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Restaurante Teste"));
    }
}