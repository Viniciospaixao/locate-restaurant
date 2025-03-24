package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Reserva;
import com.lr.LocateRestaurant.domain.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarReservasPorUsuario {
    private final ReservaRepository reservaRepository;

    public ListarReservasPorUsuario(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> executar(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }
}
