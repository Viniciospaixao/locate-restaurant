package com.lr.LocateRestaurant.domain.usecases;

import com.lr.LocateRestaurant.domain.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class CancelarReserva {
    private final ReservaRepository reservaRepository;

    public CancelarReserva(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void executar(Long reservaId) {
        // Validações podem ser adicionadas aqui (ex: verificar se a reserva existe)
        reservaRepository.deleteById(reservaId);
    }
}