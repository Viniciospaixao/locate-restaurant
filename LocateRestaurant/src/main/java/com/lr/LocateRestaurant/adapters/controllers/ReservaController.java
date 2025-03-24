package com.lr.LocateRestaurant.adapters.controllers;


import com.lr.LocateRestaurant.domain.entities.Reserva;
import com.lr.LocateRestaurant.domain.usecases.CancelarReserva;
import com.lr.LocateRestaurant.domain.usecases.FazerReserva;
import com.lr.LocateRestaurant.domain.usecases.ListarReservasPorRestaurante;
import com.lr.LocateRestaurant.domain.usecases.ListarReservasPorUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final FazerReserva fazerReserva;
    private final CancelarReserva cancelarReserva;
    private final ListarReservasPorRestaurante listarReservasPorRestaurante;

    private final ListarReservasPorUsuario listarReservasPorUsuario;

    public ReservaController(FazerReserva fazerReserva,
                             CancelarReserva cancelarReserva,
                             ListarReservasPorRestaurante listarReservasPorRestaurante,
                             ListarReservasPorUsuario listarReservasPorUsuario) {
        this.fazerReserva = fazerReserva;
        this.cancelarReserva = cancelarReserva;
        this.listarReservasPorRestaurante = listarReservasPorRestaurante;
        this.listarReservasPorUsuario = listarReservasPorUsuario;
    }

    @PostMapping
    public Reserva fazerReserva(@RequestBody Reserva reserva) {
        return fazerReserva.executar(reserva);
    }

    @DeleteMapping("/{id}")
    public void cancelarReserva(@PathVariable Long id) {
        cancelarReserva.executar(id);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<Reserva> listarReservasPorRestaurante(@PathVariable Long restauranteId) {
        return listarReservasPorRestaurante.executar(restauranteId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Reserva> listarReservasPorUsuario(@PathVariable Long usuarioId) {
        return listarReservasPorUsuario.executar(usuarioId);
    }
}