package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.entities.Reserva;
import com.lr.LocateRestaurant.domain.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class FazerReserva {
    private final ReservaRepository reservaRepository;

    public FazerReserva(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva executar(Reserva reserva) {

        return reservaRepository.save(reserva);
    }
}
